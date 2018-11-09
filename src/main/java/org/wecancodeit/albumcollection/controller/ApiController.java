package org.wecancodeit.albumcollection.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.albumcollection.model.Album;
import org.wecancodeit.albumcollection.model.Artist;
import org.wecancodeit.albumcollection.model.Song;
import org.wecancodeit.albumcollection.repository.AlbumRepository;
import org.wecancodeit.albumcollection.repository.ArtistRepository;
import org.wecancodeit.albumcollection.repository.SongRepository;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private ArtistRepository artistRepo;
	
	@Autowired
	private AlbumRepository albumRepo;
	
	@Autowired
	private SongRepository songRepo;

	@GetMapping("/artists")
	public Iterable<Artist> getArtists() {
		return artistRepo.findAll();
	}
	
	@GetMapping("/artists/{id}")
	public Artist getArtist(@PathVariable(value = "id") Long id) {
		return artistRepo.findById(id).get();
	}
	
	@GetMapping("/albums")
	public Iterable<Album> getAlbums() {
		return albumRepo.findAll();
	}
	
	@GetMapping("/artists/{id}/albums")
	public Iterable<Album> getArtistAlbums(@PathVariable(value = "id") Long id) {
		return artistRepo.findById(id).get().getAlbums();
	}
	
	@GetMapping("/artists/{id}/albums/{albumId}")
	public Album getAlbum(@PathVariable(value = "id") Long id, @PathVariable(value = "albumId") Long albumId) {
		return albumRepo.findById(albumId).get();
	}
	
	@GetMapping("/songs")
	public Iterable<Song> getSongs() {
		return songRepo.findAll();
	}
	
	@GetMapping("/artists/{id}/albums/{albumId}/songs")
	public Iterable<Song> getAlbumSongs(@PathVariable(value = "id") Long id, @PathVariable(value = "albumId") Long albumId) {
		return albumRepo.findById(albumId).get().getSongs();
	}
	
	@GetMapping("/artists/{id}/albums/{albumId}/songs/{songId}")
	public Song getSong(@PathVariable(value = "id") Long id, @PathVariable(value = "albumId") Long albumId, @PathVariable(value = "songId") Long songId) {
		return songRepo.findById(songId).get();
	}
	
	@PostMapping("/artists/add")
	public Iterable<Artist> addArtist(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String name = json.getString("name");
		int rating = Integer.parseInt(json.getString("rating"));
		String imageUrl = json.getString("imageUrl");
		artistRepo.save(new Artist(rating, name, imageUrl));

		return artistRepo.findAll();
	}
	
	@PostMapping("/albums/add")
	public Iterable<Album> addAlbum(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		
		String title = json.getString("title");
		int rating = Integer.parseInt(json.getString("rating"));
		String recordLabel = json.getString("recordLabel");
		String imageUrl = json.getString("imageUrl");
		Artist artist = artistRepo.findById(Long.parseLong(json.getString("artist"))).get();
		albumRepo.save(new Album(rating, title, imageUrl, recordLabel, artist));

		return albumRepo.findAll();
	}
	
	@PostMapping("/songs/add")
	public Iterable<Song> addSong(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		
		String title = json.getString("title");
		int rating = Integer.parseInt(json.getString("rating"));
		String duration = json.getString("duration");
		Album album = albumRepo.findById(Long.parseLong(json.getString("album"))).get();
		songRepo.save(new Song(rating, title, duration, album));

		return songRepo.findAll();
	}

}
