package com.example.api_manager_character_rpg.service;

import com.example.api_manager_character_rpg.DTO.UpdateNameSummonerDTO;
import com.example.api_manager_character_rpg.enums.TypeItem;
import com.example.api_manager_character_rpg.model.Character;
import com.example.api_manager_character_rpg.model.Item;
import com.example.api_manager_character_rpg.repository.CharacterRepository;
import com.example.api_manager_character_rpg.repository.ItemRepository;
import com.example.api_manager_character_rpg.validation.CharacterValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import java.util.List;


import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final ItemRepository itemRepository;
    private final CharacterValidator validator;

    public Character create(Character character) throws Exception {
        validator.validStatusCharacter(character);
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

    public void updateAddPointsCharacter(Long idCharacter, Item item){
        Character character = this.findById(idCharacter);

        character.setAttackPoints(character.getAttackPoints() + item.getAttackPoints());
        character.setDefensePoints(character.getDefensePoints() + item.getDefensePoints());
        characterRepository.save(character);
    }

    public void updateRemovePointsCharacter(Long idCharacter, Item item){
        Character character = this.findById(idCharacter);

        character.setAttackPoints(character.getAttackPoints() - item.getAttackPoints());
        character.setDefensePoints(character.getDefensePoints() - item.getDefensePoints());
        characterRepository.save(character);
    }

    public Item findAmulet(Long idCharacter){
        Character character = this.findById(idCharacter);

        return character.getItems()
                .stream()
                .filter(item -> item.getTypeItem().equals(TypeItem.AMULET))
                .findFirst()
                .orElseThrow(()-> new EntityNotFoundException("Amulet not found"));

    }

    private Item findItemById(Long idItem){
        return itemRepository.findById(idItem).orElseThrow(()->new EntityNotFoundException("item not found"));
    }


}

