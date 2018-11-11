package org.wecancodeit.albumcollection.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Artist {

	@Id
	@GeneratedValue
	private Long id;
	
	//all entities have these
	private String rating;
	@OneToMany(mappedBy = "artist")
	private Collection<Comment> comments;
	@ManyToMany
	private Collection<Tag> tags = new HashSet<>();//needs to be set up
	
	//unique
	private String name;
	private String imageUrl;
	@OneToMany(mappedBy = "artist")
	private Collection<Album> albums;
	
	public Artist() {}
	
	//this will need to be altered eventually
	public Artist(String rating, String name, String imageUrl) {
		this.rating = rating;
		this.name = name;
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}

	public String getRating() {
		return rating;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	public String getName() {
		return name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Collection<Album> getAlbums() {
		return albums;
	}

	public void addTag(Tag tag) {
		tags.add(tag);
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
}
