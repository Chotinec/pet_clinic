package ru.lesson.lessions;

import ru.lesson.lessions.Animals.Pet;

import java.util.ArrayList;
import java.util.List;

/**
*       Client class
*/
public class Client{

    private final  String id;
    private final String name;
    private List<Pet> pets;

    /*public Client(String id, String name){
        this.id = id;
        this.name = name;
        this.pets = new ArrayList<Pet>();
    }*/

    public Client(String id, String name, List<Pet> pets){
        this.id = id;
        this.name = name;
        if (pets == null){
            this.pets = new ArrayList<Pet>();
        }else {
            this.pets = pets;
        }
    }

    /**
     * Get pets
     * @return pets list
     */
    public List<Pet> getPets(){
                return this.pets;
        }

    /**
     * Get id
     * @return id
     */
    public String getId(){
                return this.id;
        }

    /**
     * Add new pet
     * @param pet pet
     */
    public void addPet(Pet pet){
         this.pets.add(pet);
    }

    /**
    * Get client name
    * @return client name
    */
    public String getName() {
                return this.name;
        }

    /**
     * Delete pet by name
     * @param name pet name
     */
    public void removePetByName(String name){
       Pet pet = findPetByName(name);
        if (pet != null){
            removePet(pet);
        }
    }

    /**
     * Remove pet
     * @param pet
     */
    private void removePet(Pet pet) {
        this.pets.remove(pet);
    }

    /**
     * Find pet by name
     * @param name
     * @return
     */
    private Pet findPetByName(String name){
        Pet pet = null;
        for (Pet p : pets){
            if (p.getName().equals(name)){
               pet = p;
            }
        }
        return pet;
    }

}
