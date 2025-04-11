package com.example.api_manager_character_rpg.controller;

import com.example.api_manager_character_rpg.model.Character;
import com.example.api_manager_character_rpg.service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller()
@RequestMapping("/characters")
@AllArgsConstructor
public class CharacterController {

    private final CharacterService service;

    @GetMapping()
    public ResponseEntity<List<Character>> findAll(){
        service.findAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> findById(@PathVariable Long id){
        service.findById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Character character){
        Character newCharacter = service.create(character);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newCharacter.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody String updatedNameSummoner){
        service.updateNameSummoner(id, updatedNameSummoner);
        return ResponseEntity.ok().build();
    }
}
