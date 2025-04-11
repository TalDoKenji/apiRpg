package com.example.api_manager_character_rpg.controller;

import com.example.api_manager_character_rpg.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ItemController {

    private final ItemService service;
}
