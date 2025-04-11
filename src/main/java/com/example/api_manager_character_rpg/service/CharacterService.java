package com.example.api_manager_character_rpg.service;

import com.example.api_manager_character_rpg.model.Character;
import com.example.api_manager_character_rpg.model.Item;
import com.example.api_manager_character_rpg.repository.CharacterRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CharacterService {

    private final CharacterRepository repository;

    public Character create(Character character){
        return repository.save(character);
    }

    public List<Character> findAll(){
        return repository.findAll();
    }

    public Character findById(Long id){
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Character not found"));
    }

    public void updateNameSummoner(Long id, String updatedNameSummoner){
        Character characterFound = this.findById(id);
        characterFound.setNameSummoner(updatedNameSummoner);
        repository.save(characterFound);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<Item>findItems(Long idCharacter){
        return null;
    }

    public void addItem(){

    }

    public void removeItem(){

    }



}

