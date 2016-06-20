package ru.lesson.lessions.Animals;


/**
 *      Cat realisation. He can say "Miau" and catch mouses.
 */
public class Cat extends Pet {

        /**
         *      Constructor.
         *      @param name animal name
         */
        public Cat(final String name){
                super(name,"cat");
        }

        /**
         *      Catch mouse
         */
        public void catchMouse(){}

         /**
         *      (@inheritDoc)
         */

        public void makeSound(){
                System.out.println(String.format("May %s : ",this.getName()));
        }
}
