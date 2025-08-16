package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;

import java.util.List;
import java.util.Optional;

public interface VegetableService {

    Vegetable save(Vegetable vegetable);
    void delete(Long id);
    Optional<Vegetable> findById(Long id);
    List<Vegetable> findAll();

    List<Vegetable> findAllByOrderByPriceDesc();
    List<Vegetable> findAllByOrderByPriceAsc();
    List<Vegetable> findByNameContainingIgnoreCase(String name);
}
