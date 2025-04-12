package com.example.api_manager_character_rpg.service;

import com.example.api_manager_character_rpg.DTO.UpdateNameSummonerDTO;
import com.example.api_manager_character_rpg.model.Character;
import com.example.api_manager_character_rpg.model.Item;
import com.example.api_manager_character_rpg.repository.CharacterRepository;
import com.example.api_manager_character_rpg.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import java.util.List;


import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final ItemRepository itemRepository;

    public Character create(Character character){
        return characterRepository.save(character);
    }

    public List<Character> findAll(){
        return characterRepository.findAll();
    }

    public Character findById(Long id){
        return characterRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("not found"));
    }

    public void updateNameSummoner(Long id, UpdateNameSummonerDTO updatedNameSummonerDTO){
        Character characterFound = this.findById(id);
        characterFound.setNameSummoner(updatedNameSummonerDTO.getNameSummoner());
        characterRepository.save(characterFound);
    }

    public void delete(Long id){
        characterRepository.deleteById(id);
    }

    public List<Item> findItems(Long idCharacter){
        return this.findById(idCharacter).getItems();
    }

    public void updateAddPointsCharacter(Long idCharacter, Long idItem){
        Character character = this.findById(idCharacter);
        Item item = this.findItemById(idItem);
        character.setAttackPoints(character.getAttackPoints() + item.getAttackPoints());
        character.setDefensePoints(character.getDefensePoints() + item.getDefensePoints());
        characterRepository.save(character);
    }

    public void updateRemovePointsCharacter(Long idCharacter, Long idItem){
        Character character = this.findById(idCharacter);
        Item item = this.findItemById(idItem);

        character.setAttackPoints(character.getAttackPoints() - item.getAttackPoints());
        character.setDefensePoints(character.getDefensePoints() - item.getDefensePoints());
        characterRepository.save(character);
    }

    private Item findItemById(Long idItem){
        return itemRepository.findById(idItem).orElseThrow(()->new EntityNotFoundException("item not found"));
    }


}

