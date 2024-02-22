package com.conversor.api.controllers;

import com.conversor.api.model.Coin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CoinController {

    private List<Coin> coinList = new ArrayList<>();

    @PostMapping("/add-coin")
    public ResponseEntity<String> addCoin(@RequestBody Coin coin) {
        coinList.add(coin);
        return ResponseEntity.ok("Moeda adicionada com sucesso");
    }

    @GetMapping("/coins")
    public ResponseEntity<List<Coin>> getCoins() {
        return ResponseEntity.ok(coinList);
    }
}