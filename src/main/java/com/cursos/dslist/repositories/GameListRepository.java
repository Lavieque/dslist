package com.cursos.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursos.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
