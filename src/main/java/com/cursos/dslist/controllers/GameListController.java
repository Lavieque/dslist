package com.cursos.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.dslist.dto.GameListDTO;
import com.cursos.dslist.dto.GameMinDTO;
import com.cursos.dslist.services.GameListService;

@RestController
@RequestMapping(value ="/lists")
public class GameListController {

	@Autowired
	private GameListService gameListService;
		
	@GetMapping
	public List<GameListDTO> findAll()
	{
		List<GameListDTO> result = gameListService.findAll();
		return result;
	};
}
