package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FruitService {

    Fruit save(Fruit fruit);
    Fruit delete(Long id);
    Optional<Fruit> findById(Long id);
    List<Fruit> findAll();
    Fruit getById(Long id);



    List<Fruit> getByPriceDesc();
    List<Fruit> getByPriceAsc();
    List<Fruit> searchByName(String name);
}
