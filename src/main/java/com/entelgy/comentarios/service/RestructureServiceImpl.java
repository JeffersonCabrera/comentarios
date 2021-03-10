package com.entelgy.comentarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entelgy.comentarios.model.Comment;

@Service
public class RestructureServiceImpl implements IRestructureService {

	@Value("${rest.comments}")
	private String urlRestCommets;

	@Override
	public List<Comment> listarComentarios() throws Exception {
		RestTemplate restTemple = new RestTemplate();
		ResponseEntity<List<Comment>> response = restTemple.exchange(urlRestCommets, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Comment>>() {
				});
		return response.getBody();
	}

}
