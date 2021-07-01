package de.students.utils;

public class Constants {

    public static final String[] ALLOWED_CHARACTERS_MATRIKEL = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static boolean isCorrect(String matrikel){

        for(String character : ALLOWED_CHARACTERS_MATRIKEL){

            if(matrikel.contentEquals(character) || matrikel.length() != 7){
                return false;
            }

        }
        return true;

    }

    public static boolean isCorrectName(String name){

        if(name.matches("^[a-zA-Z]+$") && name.length() > 0) return true;

        return false;

    }
    
    public static boolean isCorrectKursName(String name){

        if(name.matches("^[a-zA-Z0-9]+$") && name.length() > 0) return true;

        return false;

    }

}
