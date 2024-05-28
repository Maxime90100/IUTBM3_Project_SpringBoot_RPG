package fr.iutbm.theveneau.maxime.rpg.control.exceptions;

import fr.iutbm.theveneau.maxime.rpg.commons.ErrorList;

public class HeroNotFoundException extends ResourceNotFoundException {

    public HeroNotFoundException(String context) {
        super(ErrorList.HERO_NOT_FOUND, context, ErrorList.getMessage(ErrorList.HERO_NOT_FOUND));
    }
}
