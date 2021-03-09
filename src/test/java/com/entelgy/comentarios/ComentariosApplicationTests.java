package com.entelgy.comentarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.entelgy.comentarios.model.Comment;
import com.entelgy.comentarios.service.IRestructureService;

@SpringBootTest
class ComentariosApplicationTests {

	protected MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@Autowired
	private IRestructureService restructureService;

	@Test
	void restructureList() throws Exception {
		String uri = "/";
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int estado = mvcResult.getResponse().getStatus();
		assertEquals(200, estado);
	}

	@Test
	void listComments() throws Exception {
		List<Comment> lstCommets = restructureService.listarComentarios();
		assertTrue(lstCommets.size() > 0);
	}

	@Test
	void listCommentsVallNull() throws Exception {
		List<Comment> lstCommets = restructureService.listarComentarios();
		assertNull(lstCommets);
	}

}
