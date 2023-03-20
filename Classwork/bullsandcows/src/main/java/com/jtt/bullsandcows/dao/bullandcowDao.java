package com.jtt.bullsandcows.dao;
import com.jtt.bullsandcows.dto.bullandcowTurn;

import java.util.List;

public interface bullandcowDao {

    int maxGameId();
    bullandcowTurn add(bullandcowTurn todo);

    List<bullandcowTurn> getAll();

    List<bullandcowTurn> findById(int id) ;

    // true if item exists and is updated
    boolean update(bullandcowTurn todo);

    // true if item exists and is deleted
    boolean deleteById(int id);
}