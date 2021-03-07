package com.entelgy.comentarios.Controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.entelgy.comentarios.model.Comment;
import com.entelgy.comentarios.model.Restructure;

@RestController
public class CommetsController {

	@Value("${rest.comments}")
	private String urlRestCommets;

	private static final Logger log = LoggerFactory.getLogger(CommetsController.class);

	@PostMapping(value = "/", produces = "application/json;charset=UTF-8")
	public ResponseEntity<Restructure> restructurar() {
		RestTemplate restTemple = new RestTemplate();

		ResponseEntity<List<Comment>> response = restTemple.exchange(urlRestCommets, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Comment>>() {
				});

		List<Comment> lsComments = response.getBody();
		ArrayList<String> ResultadoArray = new ArrayList<String>(); 

		for (Comment comment : lsComments) {
			ResultadoArray.add( comment.getPostId().toString() +"\\"   
					+ comment.getId().toString()  +"\\" 
					+  comment.getEmail().toString()  );
		}
		Restructure restructure = new Restructure();
		restructure.setData(ResultadoArray);

		log.info("Hola Mundo \\ dos veces");

		for (String string : ResultadoArray) {
			log.info("Array restructure:  " + string);
		}

		return new ResponseEntity<Restructure>(restructure, HttpStatus.OK);

	}

}
