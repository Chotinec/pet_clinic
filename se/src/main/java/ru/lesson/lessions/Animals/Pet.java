package ru.lesson.lessions.Animals;


/**
 *       Base class Animal
 */
public abstract class Pet  {

        /* Pets name */
        private String name;
        private String type;

        /**
         *      constructor.
         *      @param name animal name
         */
        public Pet(final String name, final String type){
            this.name = name;
            this.type = type;
        }

        /**
         *      the votes cast
         */
        public void makeSound(){
                System.out.println(String.format("%s say : %s",this.name,"beep"));
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getType() {
            return type;
        }

        public String getName(){
                return this.name;
        }

        /**
         *      Is animal hungry?
         *      return true if yes.
         */
        private boolean isHungry(){
                //TODO create algoriym
                return true;
        }



}
