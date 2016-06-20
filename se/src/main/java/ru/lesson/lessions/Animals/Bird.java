package ru.lesson.lessions.Animals;

/**
 * Created by art on 29.05.16.
 */
public class Bird extends Pet {

    public Bird(final String name){
        super(name,"bird");
    }

    /**
     *      (@inheritDoc)
     */
    @Override
    public void makeSound(){
        System.out.println(String.format("Ku-Ka-ReCU %s : ",this.getName()));
    }
}
