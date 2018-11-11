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
import org.wecancodeit.albumcollection.model.Comment;
import org.wecancodeit.albumcollection.model.Song;
import org.wecancodeit.albumcollection.model.Tag;
import org.wecancodeit.albumcollection.repository.AlbumRepository;
import org.wecancodeit.albumcollection.repository.ArtistRepository;
import org.wecancodeit.albumcollection.repository.CommentRepository;
import org.wecancodeit.albumcollection.repository.SongRepository;
import org.wecancodeit.albumcollection.repository.TagRepository;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private ArtistRepository artistRepo;
	
	@Autowired
	private AlbumRepository albumRepo;
	
	@Autowired
	private SongRepository songRepo;
	
	@Autowired
	private TagRepository tagRepo;
	
	@Autowired
	private CommentRepository commentRepo;

	@GetMapping("/artists")
	public Iterable<Artist> getArtists() {
		return artistRepo.findAll();
	}
	
	@GetMapping("/artists/{id}")
	public Artist getArtist(@PathVariable(value = "id") Long id) {
		return artistRepo.findById(id).get();
	}
	
	//tags
	@GetMapping("/artists/{id}/tags")
	public Iterable<Tag> getArtistTags(@PathVariable(value = "id") Long id) {
		return artistRepo.findById(id).get().getTags();
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
	
	//tags
	@GetMapping("/artists/{id}/albums/{albumId}/tags")
	public Iterable<Tag> getAlbumTags(@PathVariable(value = "id") Long id, @PathVariable(value = "albumId") Long albumId) {
		return albumRepo.findById(albumId).get().getTags();
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
	
	//tags
	@GetMapping("/artists/{id}/albums/{albumId}/songs/{songId}/tags")
	public Iterable<Tag> getSongTags(@PathVariable(value = "id") Long id, @PathVariable(value = "albumId") Long albumId, @PathVariable(value = "songId") Long songId) {
		return songRepo.findById(songId).get().getTags();
	}
	
	@GetMapping("/tags")
	public Iterable<Tag> getTags() {
		return tagRepo.findAll();
	}
	
	@PostMapping("/artists/add")
	public Iterable<Artist> addArtist(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String name = json.getString("name");
		String rating = json.getString("rating");
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
	
	@PostMapping("/artists/{artistId}/comments/add")
	public Iterable<Comment> addCommentToArtist(@RequestBody String body, @PathVariable(value = "artistId") Long artistId) throws JSONException {
		JSONObject json = new JSONObject(body);
		
		String userName = json.getString("userName");
		String comment = json.getString("comment");
		Artist artist = artistRepo.findById(artistId).get();
		commentRepo.save(new Comment(userName, comment, artist));

		return commentRepo.findAll();
	}
	
	@PostMapping("/artists/{artistId}/tags/add")
	public Iterable<Tag> addTagToArtist(@RequestBody String body, @PathVariable(value = "artistId") Long artistId) throws JSONException {
		JSONObject json = new JSONObject(body);
		String newTag = json.getString("tagName");

		if(tagRepo.findByTagNameIgnoreCase(newTag) == null) {
			tagRepo.save(new Tag(newTag));
		}

		Artist artistToUpdate = artistRepo.findById(artistId).get();
		artistToUpdate.addTag(tagRepo.findByTagNameIgnoreCase(newTag));
		Artist updatedArtist = artistRepo.save(artistToUpdate);

		return updatedArtist.getTags();
	}
	
	@PostMapping("/artists/{artistId}/rating/change")
	public String changeArtistRating(@RequestBody String body, @PathVariable(value = "artistId") Long artistId) throws JSONException {
		JSONObject json = new JSONObject(body);
		String rating = json.getString("rating");

		artistRepo.findById(artistId).get().setRating(rating);

		return artistRepo.findById(artistId).get().getRating();
	}

}
