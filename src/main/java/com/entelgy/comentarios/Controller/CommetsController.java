package com.entelgy.comentarios.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entelgy.comentarios.model.Comment;
import com.entelgy.comentarios.model.Restructure;
import com.entelgy.comentarios.service.IRestructureService;

@RestController
public class CommetsController {

	@Autowired
	private IRestructureService restructureService;
 
	@PostMapping(value = "/", produces = "application/json;charset=UTF-8")
	public ResponseEntity<Restructure> restructurar() throws Exception {
		List<Comment> lsComments = restructureService.listarComentarios();
		ArrayList<String> ResultadoArray = new ArrayList<String>();

		for (Comment comment : lsComments) {
			StringBuilder sb = new StringBuilder();
			sb.append(comment.getPostId()).append("\\").append(comment.getId()).append("\\").append(comment.getEmail());
			ResultadoArray.add(sb.toString());
		}

		Restructure restructure = new Restructure();
		restructure.setData(ResultadoArray);
		return new ResponseEntity<Restructure>(restructure, HttpStatus.OK);

	}

}
