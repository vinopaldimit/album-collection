package org.wecancodeit.albumcollection.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.albumcollection.controller.CollectionController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(CollectionController.class)
public class CollectionControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldBeOkfromHome() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk());
	}

	@Test
	public void shouldShowHome() throws Exception {
		mockMvc.perform(get("/")).andExpect(view().name("../static/index"));
	}
}
