package fr.iutbm.theveneau.maxime.rpg.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDTO {

    private Integer errorNumber;
    private String context;
    private String message;

    @Override
    public String toString() {
        return "ErrorDTO{" +
                "errorNumber=" + errorNumber +
                ", context='" + context + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
