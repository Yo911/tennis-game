package com.exercice.rest.controller;

import com.exercice.ports.api.IGameService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class TennisGameController {

    @Autowired
    public IGameService gameService;

    @PostConstruct
    public void init() {
        System.out.println(">>> HelloController instancié");
    }

    @GetMapping("/tennis/game")
    public ResponseEntity<List<String>> playFulllGame(@RequestParam(name = "gamePoints") String gamePoints) {
        return ResponseEntity.ok(gameService.executeFullGame(gamePoints));
    }
}
