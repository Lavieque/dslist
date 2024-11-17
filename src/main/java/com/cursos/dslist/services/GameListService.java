package com.cursos.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursos.dslist.dto.GameDTO;
import com.cursos.dslist.dto.GameListDTO;
import com.cursos.dslist.dto.GameMinDTO;
import com.cursos.dslist.entities.Game;
import com.cursos.dslist.entities.GameList;
import com.cursos.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll()
	{
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	};
}
