package org.wecancodeit.albumcollection.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Song {
	@Id
	@GeneratedValue
	private Long id;
	
	//all entities have these
	private int rating;
	@OneToMany(mappedBy = "artist")
	private Collection<Comment> comments;
	@ManyToMany
	private Collection<Tag> tags = new HashSet<>();//needs to be set up
		
	//unique
	private String title;
	private String duration;
	@JsonIgnore
	@ManyToOne
	private Album album;
	
	public Song() {}
	
	public Song(int rating, String title, String duration, Album album) {
		this.rating = rating;
		this.title = title;
		this.duration = duration;
		this.album = album;
	}

	public Long getId() {
		return id;
	}

	public int getRating() {
		return rating;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	public String getTitle() {
		return title;
	}

	public String getDuration() {
		return duration;
	}

	public Album getAlbum() {
		return album;
	}
	
}
