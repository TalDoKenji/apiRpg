package com.example.api_manager_character_rpg.controller;

import com.example.api_manager_character_rpg.model.Item;
import com.example.api_manager_character_rpg.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {

    private final ItemService service;

    @GetMapping()
    public ResponseEntity<List<Item>> findAll() {
        List<Item> items = service.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> findById(@PathVariable Long id) {
        Item item = service.findById(id);
        return ResponseEntity.ok(item);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody Item item) throws Exception {
        Item newItem = service.create(item);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newItem.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
