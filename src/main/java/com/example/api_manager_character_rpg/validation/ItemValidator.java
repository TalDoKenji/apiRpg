package com.example.api_manager_character_rpg.validation;

import com.example.api_manager_character_rpg.enums.TypeItem;
import com.example.api_manager_character_rpg.exception.InvalidArgument;
import com.example.api_manager_character_rpg.model.Character;
import com.example.api_manager_character_rpg.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemValidator {

    public void validStatus(Item item) throws Exception {
        if (item.getDefensePoints() == 0 && item.getAttackPoints() == 0) {
            throw new InvalidArgument("the item cannot have attack and defense equal to 0");
        }
    }

    public void validTypeItem(Item item) throws Exception {
        if (item.getTypeItem() == TypeItem.WEAPON && item.getDefensePoints() != 0) {
            throw new InvalidArgument("attack type weapons cannot have defense points");
        }
        if (item.getTypeItem() == TypeItem.ARMOR && item.getAttackPoints() != 0) {
            throw new InvalidArgument("defense type weapons cannot have attack points");
        }
    }

    public void validAmulet(Character character, Item item) {
        if (item.getTypeItem().equals(TypeItem.AMULET)) {
            boolean alreadyHasAmulet = character.getItems().stream()
                    .anyMatch(i -> i.getTypeItem().equals(TypeItem.AMULET));

            if (alreadyHasAmulet) {
                throw new InvalidArgument("The character already has an amulet.");
            }
        }
    }

}
