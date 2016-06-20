package ru.lesson.lessions;

import ru.lesson.lessions.command.CommandExecutor;
import ru.lesson.lessions.exception.InterruptOperationException;

/**
*       Work clinic
*/
public class ClinicRunner{
        
        public static void main(String[] args) {
            Clinic clinic = new Clinic();
            try
            {
                Client client1 = new Client("147","Brown",null);
                client1.addPet(PetCreator.createPet("dog","Nick"));
                client1.addPet(PetCreator.createPet("dog","Buch"));
                Client client2 = new Client("156","Nick",null);
                client2.addPet(PetCreator.createPet("cat","Mouse"));
                clinic.addClient(client1);
                clinic.addClient(client2);
                Operation operation;
                do
                {
                    operation = ConsoleHelper.askOperation();
                    CommandExecutor.execute(operation,clinic);
                }
                while (operation != Operation.EXIT);
            }catch (InterruptOperationException e){
                ConsoleHelper.printMessage(e.getMessage());
            }

        }

}
