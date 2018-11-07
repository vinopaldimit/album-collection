package org.wecancodeit.albumcollection.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Long Id;
	
	private String userName;
	@Lob
	private String comment;
	
	@ManyToOne
	private Artist artist;
	@ManyToOne
	private Album album;
	@ManyToOne
	private Song song;
	
	public Comment() {}

	public Comment(String userName, String comment, Artist artist) {
		this.userName = userName;
		this.comment = comment;
		this.artist = artist;
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
