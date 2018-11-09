package org.wecancodeit.albumcollection;

import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.albumcollection.model.Album;
import org.wecancodeit.albumcollection.model.Artist;
import org.wecancodeit.albumcollection.model.Song;
import org.wecancodeit.albumcollection.repository.AlbumRepository;
import org.wecancodeit.albumcollection.repository.ArtistRepository;
import org.wecancodeit.albumcollection.repository.SongRepository;

@Service
public class CollectionPopulator implements CommandLineRunner {

	@Resource
	ArtistRepository artistRepo;

	@Resource
	AlbumRepository albumRepo;

	@Resource
	SongRepository songRepo;

	@Override
	public void run(String... args) throws Exception {

		createArtistList(new Artist[] { new Artist(10, "Against Me!", "../images/againstMe.png") })
				.forEach(this::saveArtistToRepo);

		createAlbumList(new Album[] {
				new Album(9, "Searching For A Former Clarity", "../images/searchingForAFormerClarity.jpg", "Fat Wreck Chords",
						artistRepo.findByNameIgnoreCase("Against Me!")),
				new Album(10, "White Crosses", "../images/whiteCrosses.jpg", "Sire",
						artistRepo.findByNameIgnoreCase("Against Me!")) }).forEach(this::saveAlbumToRepo);

		createSongList(new Song[] {
				new Song(10, "Miami", "3:37", albumRepo.findByTitleIgnoreCase("Searching For A Former Clarity")),
				new Song(9, "How Low", "3:16", albumRepo.findByTitleIgnoreCase("Searching For A Former Clarity")),
				new Song(10, "Total Clarity", "3:25", albumRepo.findByTitleIgnoreCase("Searching For A Former Clarity")),
				new Song(8, "Because Of The Shame", "4:21", albumRepo.findByTitleIgnoreCase("White Crosses")), 
				new Song(10, "Ache With Me", "3:38", albumRepo.findByTitleIgnoreCase("White Crosses")),
				new Song(9, "Spanish Moss", "3:51", albumRepo.findByTitleIgnoreCase("White Crosses")) }).forEach(this::saveSongToRepo);
	}

	private ArrayList<Artist> createArtistList(Artist[] artists) {
		return new ArrayList<>(Arrays.asList(artists));
	}

	private void saveArtistToRepo(Artist artist) {
		artistRepo.save(artist);
	}

	private ArrayList<Album> createAlbumList(Album[] albums) {
		return new ArrayList<>(Arrays.asList(albums));
	}

	private void saveAlbumToRepo(Album album) {
		albumRepo.save(album);
	}

	private ArrayList<Song> createSongList(Song[] songs) {
		return new ArrayList<>(Arrays.asList(songs));
	}

	private void saveSongToRepo(Song song) {
		songRepo.save(song);
	}

}