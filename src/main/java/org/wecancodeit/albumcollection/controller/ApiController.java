package org.wecancodeit.albumcollection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
