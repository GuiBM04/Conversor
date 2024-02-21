package com.conversor.api.controllers;

import com.conversor.api.model.Coin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddCoinController {

    @PostMapping("/api/add-coin")
    public ResponseEntity<String> addCoin(@RequestBody Coin coin) {
        // Lógica para adicionar uma moeda
        return ResponseEntity.ok("Moeda adicionada com sucesso");
    }
}