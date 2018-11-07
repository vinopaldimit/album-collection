package org.wecancodeit.albumcollection.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.albumcollection.model.Album;
import org.wecancodeit.albumcollection.model.Artist;

@RunWith(SpringRunner.class)
@WebMvcTest(ApiController.class)
public class ApiControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ApiController apiController;

	@Test
	public void shouldGetArtists() throws Exception {
		Artist artist = new Artist();
		List<Artist> artists = Collections.singletonList(artist);

		given(apiController.getArtists()).willReturn(artists);
		mvc.perform(get("/api/artists").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name", is(artist.getName())));
	}
	
	@Test
	public void shouldGetAlbums() throws Exception {
		Album album = new Album();
		List<Album> albums = Collections.singletonList(album);

		given(apiController.getAlbums()).willReturn(albums);
		mvc.perform(get("/api/albums").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].title", is(album.getTitle())));
	}
	
//	@Test
//	public void shouldGetArtist() throws Exception {
//		Artist artist = new Artist();
//		//List<Artist> artists = Collections.singletonList(artist);
//
//		given(apiController.getArtist(1L)).willReturn(artist);
//		mvc.perform(get("/api/artists/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//				.andExpect(jsonPath("$[0].name", is(artist.getName())));
//	}
	
//	@Test
//	public void getLimitedArtists() throws Exception {
//		Artist artist0 = new Artist();
//		Artist artist1 = new Artist();
//		Artist artist2 = new Artist();
//		Artist artist3 = new Artist();
//		List<Artist> artists = Arrays.asList(artist0, artist1, artist2);
//
//		given(apiController.getArtists(3L)).willReturn(artists);
//		mvc.perform(get("/api/artists/?limit=3").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//				.andExpect(jsonPath("$", hasSize(3)));
//	}
}