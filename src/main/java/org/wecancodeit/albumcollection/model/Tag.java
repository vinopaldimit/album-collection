package org.wecancodeit.albumcollection.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {
	@Id
	@GeneratedValue
	private Long id;
	
	private String tagName;
	@JsonIgnore
	@ManyToMany
	private Collection<Artist> artists = new HashSet<>();
	@JsonIgnore
	@ManyToMany
	private Collection<Album> albums = new HashSet<>();
	@JsonIgnore
	@ManyToMany
	private Collection<Song> songs = new HashSet<>();
	
	public Tag() {}
	
	public Tag(String tagName) {
		this.tagName = tagName;
	}

	public Long getId() {
		return id;
	}

	public String getTagName() {
		return tagName;
	}

	public Collection<Artist> getArtists() {
		return artists;
	}

	public Collection<Album> getAlbums() {
		return albums;
	}

	public Collection<Song> getSongs() {
		return songs;
	}
	
}
