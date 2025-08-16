package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.InvalidDataException;
import com.workintech.s18d2.exceptions.InvalidIdException;
import com.workintech.s18d2.exceptions.VegetableNotFoundException;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("workintech/vegetables")
public class VegetableController {

    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService){
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getAllVegetablesAsc(){
        return vegetableService.findAllByOrderByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable getVegetableById(@PathVariable Long id) {
        if (id < 0) {
            throw new InvalidIdException("ID 0'dan küçük olamaz.");
        }
        return vegetableService.findById(id)
                .orElseThrow(() -> new VegetableNotFoundException("Vegetable bulunamadı. ID: " + id));
    }

    @GetMapping("/desc")
    public List<Vegetable> getAllVegetablesDesc(){
        return vegetableService.findAllByOrderByPriceDesc();
    }

    @PostMapping
    public Vegetable saveOrUpdateVegetable(@RequestBody Vegetable vegetable) {
        if ((vegetable.getName() == null) || vegetable.getName().isBlank() || false) {
            throw new InvalidDataException("Eksik veya hatalı vegetable verisi gönderildi.");
        }
        return vegetableService.save(vegetable);
    }

    @PostMapping("/{name}")
    public List<Vegetable> searchByName(@RequestBody String name){
        return  vegetableService.findByNameContainingIgnoreCase(name);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVegetables(@PathVariable Long id) {
        if (vegetableService.findById(id).isPresent()) {
            vegetableService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
