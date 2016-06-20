package ru.lesson.lessions.Animals;

/**
 * Created by art on 29.05.16.
 */
public class Mouse extends Pet {

    public Mouse(final String name){
        super(name,"mouse");
    }

    /**
     *      (@inheritDoc)
     */
    @Override
    public void makeSound(){
        System.out.println(String.format("Pic-Pic %s : ",this.getName()));
    }
}
