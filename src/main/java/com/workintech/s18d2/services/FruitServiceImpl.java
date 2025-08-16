package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository){
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(Long id) {
        Fruit fruit = fruitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fruit not found"));
        fruitRepository.deleteById(id);
        return fruit;
    }

    @Override
    public Optional<Fruit> findById(Long id) {
        return fruitRepository.findById(id);
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit getById(Long id) {
        return fruitRepository.findById(id).orElseThrow(() -> new RuntimeException("Fruit not found with id: " + id));
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.findByNameContainingIgnoreCase(name);
    }
}
