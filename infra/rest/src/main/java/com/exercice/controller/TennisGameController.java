package com.exercice.controller;

import com.exercice.ports.api.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TennisGameController {

    @Autowired
    public IGameService gameService;

    @PostMapping("/tennis/game")
    public ResponseEntity<List<String>> playFulllGame(@RequestParam String gamePoints) {
        return ResponseEntity.ok(gameService.executeFullGame(gamePoints));
    }
}
