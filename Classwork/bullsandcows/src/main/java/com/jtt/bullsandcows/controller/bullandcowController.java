package com.jtt.bullsandcows.controller;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.jtt.bullsandcows.dao.bullandcowDao;
import com.jtt.bullsandcows.dto.bullandcowTurn;
import com.jtt.bullsandcows.service.bullandcowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
// @RequestMapping("/game")
public class bullandcowController {

    private final bullandcowDao dao;
    private final bullandcowService bandcService;
    public bullandcowController(bullandcowDao dao) {
        this.dao = dao;
        bandcService = new bullandcowService();
    }

    @GetMapping("/game")
    public List<bullandcowTurn> all()
    {
        List<bullandcowTurn> retvals;
        retvals=dao.getAll();
        for (int i = 0; i < retvals.size(); i++)
        {
            bullandcowTurn td=retvals.get(i);
            td.setSecret("Redacted");
        }
        return retvals;
    }
    @PostMapping("/begin")
    public String begin() {
        bullandcowTurn todo = new bullandcowTurn();
        todo.setSecret(bandcService.CreateSecret());
        todo.setRoundTime(bandcService.GetTime());
        todo.setFinished(false);
        todo.setGuess("begin");
        int count=dao.maxGameId()+1;
        todo.setGameId(count);
        dao.add(todo);
        String retval=String.format("Game Created GameId = %d",count);
        return retval;
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<List<bullandcowTurn>> findById(@PathVariable int id) {
        List<bullandcowTurn> result = dao.findById(id);
        if (result.size() == 0) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        for (int i = 0; i < result.size(); i++)
        {
            bullandcowTurn td=result.get(i);
            td.setSecret("Redacted");
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/rounds/{id}")
    public ResponseEntity<List<bullandcowTurn>> findandSortById(@PathVariable int id) {
        List<bullandcowTurn> result = dao.findById(id);
        if (result.size() == 0) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        for (int i = 0; i < result.size(); i++)
        {
            bullandcowTurn td=result.get(i);
            td.setSecret("Redacted");
        }
        Collections.sort(result, Comparator.comparing(bullandcowTurn::getRoundTime));

        return ResponseEntity.ok(result);
    }
    @PostMapping("/guess")
    public ResponseEntity<bullandcowTurn> guess(
            @RequestParam("guess")String guess,
            @RequestParam("gameId")int gameId){
        List<bullandcowTurn> lst;
        lst=dao.findById(gameId);
        bullandcowTurn rnd= new bullandcowTurn();
        rnd.setGuess(guess);
        rnd.setRoundTime(bandcService.GetTime());
        rnd.setGameId(-1);
        rnd.setSecret("Game ID not found.");
        if(lst.size()==0)
        {
            return new ResponseEntity(rnd,HttpStatus.NOT_FOUND);
        }

        rnd.setSecret(lst.get(0).getSecret());
        rnd.setGameId(lst.get(0).getGameId());

        String answer=bandcService.CheckGuess(rnd.getSecret(),rnd.getGuess());
        if(answer.contains("e:4"))
        {
            rnd.setFinished(true);
        }
        else
            rnd.setFinished(false);
        dao.add(rnd);
        rnd.setSecret(answer);
        return new ResponseEntity(rnd,HttpStatus.OK);
    }

}