package com.example.api_manager_character_rpg.repository;

import com.example.api_manager_character_rpg.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
