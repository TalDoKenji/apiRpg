package com.example.api_manager_character_rpg.service;

import com.example.api_manager_character_rpg.DTO.ItemDTO;
import com.example.api_manager_character_rpg.DTO.UpdateNameSummonerDTO;
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
    private final ItemService itemService;

    public Character create(Character character){
        return repository.save(character);
    }

    public List<Character> findAll(){
        return repository.findAll();
    }

    public Character findById(Long id){
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("not found"));
    }

    public void updateNameSummoner(Long id, UpdateNameSummonerDTO updatedNameSummonerDTO){
        Character characterFound = this.findById(id);
        characterFound.setNameSummoner(updatedNameSummonerDTO.getNameSummoner());
        repository.save(characterFound);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<Item> findItems(Long idCharacter){
        return this.findById(idCharacter).getItems();
    }

    public void addItem(Long idCharacter, ItemDTO itemDTO){
        Character character = this.findById(idCharacter);
        character.getItems().add(itemService.findById(itemDTO.getId()));
        updateAddPointsCharacter(idCharacter, itemDTO.getId());
    }

    public void removeItem(Long idCharacter, ItemDTO itemDTO){
        Character character = this.findById(idCharacter);
        character.getItems().remove(itemService.findById(itemDTO.getId()));
        updateRemovePointsCharacter(idCharacter, itemDTO.getId());
    }

    private void updateAddPointsCharacter(Long idCharacter, Long idItem){
        Item item = itemService.findById(idItem);
        Character character = this.findById(idCharacter);

        character.setAttackPoints(character.getAttackPoints() + item.getAttackPoints());
        character.setDefensePoints(character.getDefensePoints() + item.getDefensePoints());
        repository.save(character);
    }

    private void updateRemovePointsCharacter(Long idCharacter, Long idItem){
        Item item = itemService.findById(idItem);
        Character character = this.findById(idCharacter);

        character.setAttackPoints(character.getAttackPoints() - item.getAttackPoints());
        character.setDefensePoints(character.getDefensePoints() - item.getDefensePoints());
        repository.save(character);
    }


}

