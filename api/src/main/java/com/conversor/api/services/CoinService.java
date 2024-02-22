package com.conversor.api.services;

import com.conversor.api.model.Coin;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoinService {

    private List<Coin> coinList = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Adiciona uma moeda padrão ao inicializar a lista (opcional)
        addCoin(new Coin(getNextId(), "Dolar", 5.0));
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void addCoin(Coin coin) {
        int nextId = getNextId();
        coin.setId(nextId);
        coinList.add(coin);
    }


    private int getNextId() {
        if (coinList.isEmpty()) {
            return 1;
        } else {
            int maxId = coinList.stream().mapToInt(Coin::getId).max().orElse(0);
            return maxId + 1;
        }
    }
}
