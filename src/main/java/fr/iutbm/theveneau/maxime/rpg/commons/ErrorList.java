package fr.iutbm.theveneau.maxime.rpg.commons;

import java.util.HashMap;
import java.util.Map;

public final class ErrorList {

    public static final Integer NOERROR = 0;
    public static final Integer RESOURCE_NOT_FOUND = 100;
    public static final Integer HERO_NOT_FOUND = 101;

    public static Map<Integer, String> errorList;
    static {
        errorList = new HashMap<>();
        errorList.put(NOERROR, "no error");
        errorList.put(RESOURCE_NOT_FOUND, "resource not found");
        errorList.put(HERO_NOT_FOUND, "hero not found");
    }

    public static void register(Integer number, String message) {
        if ((!errorList.containsKey(number)) && (!errorList.containsValue(message)) )  {
            errorList.put(number, message);
        }
    }

    public static String getMessage(Integer number) {
        if (errorList.containsKey(number)) return errorList.get(number);
        return "";
    }

}
