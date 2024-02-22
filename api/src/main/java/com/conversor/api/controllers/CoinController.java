package com.conversor.api.controllers;

import com.conversor.api.model.Coin;
import com.conversor.api.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CoinController {

    private final CoinService coinService;

    @Autowired
    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @PostMapping("/add-coin")
    public ResponseEntity<String> addCoin(@RequestBody Coin coin) {
        coinService.addCoin(coin);
        return ResponseEntity.ok("Moeda adicionada com sucesso");
    }

    @GetMapping("/coins")
    public ResponseEntity<List<Coin>> getCoins() {
        List<Coin> coinList = coinService.getCoinList();
        return ResponseEntity.ok(coinList);
    }
}