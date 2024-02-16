package com.conversor.api.controllers;

import com.conversor.api.model.Coin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class addCoinController {

    @PostMapping("/api/add-coin")
    public String addCoin(@RequestBody Coin coin) {
        // Lógica para processar o objeto Coin recebido
        // Pode salvar no banco de dados, realizar operações, etc.
        return "Coin recebido com sucesso!";
    }
}