package com.example.api_manager_character_rpg.service;

import com.example.api_manager_character_rpg.model.Item;
import com.example.api_manager_character_rpg.repository.ItemRepository;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository repository;

    public void create(Item item){
        repository.save(item);
    }

    public List<Item> findAll(){
        return repository.findAll();
    }

    public Item findById(Long id){
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Item not found"));
    }
}
