package org.wecancodeit.albumcollection.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Album {

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
	private String imageUrl;
	@OneToMany(mappedBy = "album")
	private Collection<Song> songs;
	private String recordLabel;
	@ManyToOne
	private Artist artist;
	
	public Album() {}
	
	public Album(int rating, Collection<Comment> comments, Collection<Tag> tags, String title, String imageUrl,
			Collection<Song> songs, String recordLabel) {
		this.rating = rating;
		this.comments = comments;
		this.tags = tags;
		this.title = title;
		this.imageUrl = imageUrl;
		this.songs = songs;
		this.recordLabel = recordLabel;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public Collection<Song> getSongs() {
		return songs;
	}

	public String getRecordLabel() {
		return recordLabel;
	}
	
	
	
}
