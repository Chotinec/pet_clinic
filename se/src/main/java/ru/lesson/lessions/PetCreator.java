package ru.lesson.lessions;

import ru.lesson.lessions.Animals.*;

/**
 * Pet fatory
 * Created by art on 12.05.16.
 */
public class PetCreator {

    private static final String DOG = "dog";
    private static final String CAT = "cat";
    private static final String BIRD = "bird";
    private static final String MOUSE = "mouse";

    /**
     * Pet factory
     * @param petType (cat, dog, bird, mouse)
     * @param name pet name
     * @return pet
     */
    public static Pet createPet(String petType, String name){
        Pet pet = null;
        if (DOG.equals(petType)){
            pet = new Dog(name);
        }
        if (CAT.equals(petType)){
            pet = new Cat(name);
        }
        if (BIRD.equals(petType)){
            pet = new Bird(name);
        }
        if (MOUSE.equals(petType)){
            pet = new Mouse(name);
        }
        return pet;
    }

    public static Pet createPetByType(PetType type,String name){
        Pet pet = null;
        if (PetType.DOG.equals(type)){
            pet = new Dog(name);
        }
        if (PetType.CAT.equals(type)){
            pet = new Cat(name);
        }
        if (PetType.BIRD.equals(type)){
            pet = new Bird(name);
        }
        if (PetType.MOUSE.equals(type)){
            pet = new Mouse(name);
        }
        if(PetType.ATHER.equals(type)){
            pet = new SomePet(name);
        }
        return pet;
    }
}
