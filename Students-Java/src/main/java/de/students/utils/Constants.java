package de.students.utils;

public class Constants {

    public static final String[] ALLOWED_CHARACTERS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static boolean isCorrect(String matrikel){

        for(String character : ALLOWED_CHARACTERS){

            if(matrikel.contentEquals(character)){
                return true;
            }

        }
        return false;

    }

}
