package com.example.api_manager_character_rpg.controller;

import com.example.api_manager_character_rpg.DTO.UpdateNameSummonerDTO;
import com.example.api_manager_character_rpg.model.Character;
import com.example.api_manager_character_rpg.model.Item;
import com.example.api_manager_character_rpg.service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller()
@RequestMapping("/characters")
@AllArgsConstructor
public class CharacterController {

    private final CharacterService service;

    @GetMapping()
    public ResponseEntity<List<Character>> findAll() {
        List<Character> characters = service.findAll();
        return ResponseEntity.ok(characters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> findById(@PathVariable Long id) {
        Character character = service.findById(id);
        return ResponseEntity.ok(character);
    }

    @GetMapping("/findItems/{id}")
    public ResponseEntity<List<Item>> findItems(@PathVariable Long id) {
        List<Item> items = service.findItems(id);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/findAmulet/{id}")
    public ResponseEntity<Item> findAmulet(@PathVariable Long id) {
        Item item = service.findAmulet(id);
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Character character) throws Exception {
        Character newCharacter = service.create(character);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newCharacter.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UpdateNameSummonerDTO updatedNameSummonerDTO) {
        service.updateNameSummoner(id, updatedNameSummonerDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
