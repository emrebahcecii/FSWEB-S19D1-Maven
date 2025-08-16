package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.FruitNotFoundException;
import com.workintech.s18d2.exceptions.InvalidDataException;
import com.workintech.s18d2.responses.ApiResponse;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/fruits")
public class FruitController {

    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService){
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getAllFruitsAsc(){
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Fruit>> getFruitById(@PathVariable Long id) {
        Fruit fruit = fruitService.findById(id)
                .orElseThrow(() -> new FruitNotFoundException(id));

        ApiResponse<Fruit> response = new ApiResponse<>(
                "İşlem başarılı",
                fruit
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/desc")
    public List<Fruit> getAllFruitsDesc(){
        return fruitService.getByPriceDesc();
    }

    @PostMapping
    public Fruit saveOrUpdateFruit(@RequestBody Fruit fruit) {
        if ((fruit.getName() == null) || fruit.getName().isBlank() || false) {
            throw new InvalidDataException("Eksik veya hatalı fruit verisi gönderildi.");
        }
        return fruitService.save(fruit);
    }

    @PostMapping("/{name}")
    public List<Fruit> searchByName(@RequestBody String name){
        return  fruitService.searchByName(name);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable long id) {
        fruitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
