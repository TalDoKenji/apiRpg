package com.example.api_manager_character_rpg.validation;

import com.example.api_manager_character_rpg.enums.TypeItem;
import com.example.api_manager_character_rpg.model.Character;
import jakarta.validation.Validator;
import org.springframework.stereotype.Component;

@Component
public class CharacterValidator  {

   public void validStatusCharacter(Character character) throws Exception{
       if (character.getAttackPoints()+ character.getDefensePoints() > 10){
           throw new Exception("the amount of points distributed exceeds 10\n");
       }
   }

}
