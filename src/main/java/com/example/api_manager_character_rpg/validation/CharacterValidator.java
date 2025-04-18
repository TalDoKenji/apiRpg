package com.example.api_manager_character_rpg.validation;

import com.example.api_manager_character_rpg.exception.InvalidArgument;
import com.example.api_manager_character_rpg.model.Character;
import org.springframework.stereotype.Component;

@Component
public class CharacterValidator {

    public void validStatusCharacter(Character character) throws Exception {
        if (character.getAttackPoints() + character.getDefensePoints() > 10) {
            throw new InvalidArgument("the amount of points distributed exceeds 10");
        }
    }

}
