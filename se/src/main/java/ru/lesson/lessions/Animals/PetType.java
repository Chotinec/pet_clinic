package ru.lesson.lessions.Animals;




/**
 * Created by art on 01.06.16.
 */
public enum PetType {
    CAT, DOG, BIRD, MOUSE, ATHER;

    /**
     * String pet types
     */
    private static final String STRING_FOR_CAT = "1";
    private static final String STRING_FOR_DOG = "2";
    private static final String STRING_FOR_BIRD = "3";
    private static final String STRING_FOR_MOUSE = "4";
    private static final String STRING_FOR_ATHER = "100";

    /**
     * Get pet type
     * @param type pet type
     * @return
     */
    public static PetType getType(String type){
        if (STRING_FOR_CAT.equals(type))return CAT;
        if (STRING_FOR_DOG.equals(type))return DOG;
        if (STRING_FOR_BIRD.equals(type))return BIRD;
        if (STRING_FOR_MOUSE.equals(type))return MOUSE;
        if (STRING_FOR_ATHER.equals(type))return ATHER;

        return ATHER;
    }
}
