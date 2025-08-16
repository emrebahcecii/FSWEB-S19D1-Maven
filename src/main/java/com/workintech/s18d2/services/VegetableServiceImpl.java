package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{

    private VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository)
    {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public void delete(Long id) {
        vegetableRepository.deleteById(id);
    }

    @Override
    public Optional<Vegetable> findById(Long id) {
        return vegetableRepository.findById(id);
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public List<Vegetable> findAllByOrderByPriceDesc() {
        return vegetableRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public List<Vegetable> findAllByOrderByPriceAsc() {
        return vegetableRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Vegetable> findByNameContainingIgnoreCase(String name) {
        return vegetableRepository.findByNameContainingIgnoreCase(name);
    }
}
