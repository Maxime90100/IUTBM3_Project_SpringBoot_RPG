package fr.iutbm.theveneau.maxime.rpg.control.exceptions;

import fr.iutbm.theveneau.maxime.rpg.commons.ErrorList;
import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {

    protected Integer errorNumber;
    protected String context;

    public ResourceNotFoundException(Integer errorNumber, String context, String message) {
        super(message);
        this.errorNumber = errorNumber;
        this.context = context;
    }

    public ResourceNotFoundException(String context) {
        this(ErrorList.RESOURCE_NOT_FOUND, context, ErrorList.getMessage(ErrorList.RESOURCE_NOT_FOUND));
    }

    public ResourceNotFoundException() {
        this(ErrorList.RESOURCE_NOT_FOUND, "", ErrorList.getMessage(ErrorList.RESOURCE_NOT_FOUND));
    }

}
