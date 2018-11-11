package org.wecancodeit.albumcollection.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Long Id;
	
	private String userName;
	@Lob
	private String comment;
	
	@JsonIgnore
	@ManyToOne
	private Artist artist;
	@JsonIgnore
	@ManyToOne
	private Album album;
	@JsonIgnore
	@ManyToOne
	private Song song;
	
	public Comment() {}

	public Comment(String userName, String comment, Artist artist) {
		this.userName = userName;
		this.comment = comment;
		this.artist = artist;
	}
	
	public Comment(String userName, String comment, Album album) {
		this.userName = userName;
		this.comment = comment;
		this.album = album;
	}
	
	public Comment(String userName, String comment, Song song) {
		this.userName = userName;
		this.comment = comment;
		this.song = song;
	}

	public Long getId() {
		return Id;
	}

	public String getUserName() {
		return userName;
	}

	public String getComment() {
		return comment;
	}

	public Artist getArtist() {
		return artist;
	}
	
}
