package com.dayana.market.domain.service;

import com.dayana.market.domain.Purchase;
import com.dayana.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository PurchaseRepository;

    public List<Purchase> getAll(){
        return PurchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clientId) {
        return PurchaseRepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase) {
        return PurchaseRepository.save(purchase);
    }
}
