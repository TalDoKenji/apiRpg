package com.example.api_manager_character_rpg.validation;

import com.example.api_manager_character_rpg.enums.TypeItem;
import com.example.api_manager_character_rpg.model.Character;
import com.example.api_manager_character_rpg.model.Item;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ItemValidator {

    public void validStatus(Item item)throws Exception{
        if(item.getDefensePoints() == 0 && item.getAttackPoints() ==0){
            throw new Exception("the item cannot have attack and defense equal to 0");
        }
    }

    public void validTypeItem(Item item)throws Exception{
        if (item.getTypeItem() == TypeItem.WEAPON && item.getDefensePoints() != 0){
            throw new Exception("attack type weapons cannot have defense points");
        }
        if (item.getTypeItem() == TypeItem.ARMOR && item.getAttackPoints() != 0){
            throw new Exception("defense type weapons cannot have attack points");
        }
    }

    public void validAmulet(Character character) {
        List<Item> items = character.getItems();
        long qtde = items.stream().filter(item -> item.getTypeItem() == (TypeItem.AMULET)).count();
        if(qtde >= 1){
            throw new IllegalArgumentException("the character cannot have more than one amulet");
        }
    }
}
