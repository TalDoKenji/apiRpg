package com.example.api_manager_character_rpg.service;

import com.example.api_manager_character_rpg.exception.NotFound;
import com.example.api_manager_character_rpg.model.Item;
import com.example.api_manager_character_rpg.repository.ItemRepository;
import com.example.api_manager_character_rpg.validation.ItemValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final CharacterService characterService;
    private final ItemValidator validator;

    public Item create(Item item) throws Exception {
        validator.validStatus(item);
        validator.validAmulet(characterService.findById(item.getCharacter().getId()), item);
        validator.validTypeItem(item);
        Item itemSaved = itemRepository.save(item);
        characterService.updateAddPointsCharacter(itemSaved.getCharacter().getId(), itemSaved);
        return itemSaved;
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new NotFound("Item not found"));
    }

    public void delete(Long id) {
        Item itemFound = this.findById(id);
        characterService.updateRemovePointsCharacter(itemFound.getCharacter().getId(), itemFound);
        itemRepository.deleteById(id);
    }

}
