package ru.lesson.lessions.Animals;

/**
 *      Dog realisation
 */
public class Dog extends Pet {

        /**
         *      Constructor.
         *      @param name animal name
         */
        public Dog(final String name){
                super(name,"cat");
        }


        /**
         *      (@inheritDoc)
         */

        public void makeSound(){
                System.out.println(String.format("Gav %s : ",this.getName()));
        }
}
