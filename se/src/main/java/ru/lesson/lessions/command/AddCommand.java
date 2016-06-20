package ru.lesson.lessions.command;

import ru.lesson.lessions.Animals.Pet;
import ru.lesson.lessions.Client;
import ru.lesson.lessions.Clinic;
import ru.lesson.lessions.ConsoleHelper;
import ru.lesson.lessions.PetCreator;
import ru.lesson.lessions.exception.InterruptOperationException;

/**
 * Add command
 * Created by art on 15.05.16.
 */
class AddCommand implements Command {

    private static final String NO_SUCH_PET = "There is no such pet!";

    /**
     * Execute add commmand
     * @param clinic clinic
     * @throws InterruptOperationException
     */
    @Override
    public void execute(Clinic clinic) throws InterruptOperationException {
        String[] clientsParams = ConsoleHelper.askClient();
        Pet pet = PetCreator.createPet(clientsParams[0],clientsParams[1]);
        if (pet == null){
            throw new InterruptOperationException(NO_SUCH_PET);
        }
        clinic.addClient(new Client(clientsParams[0],clientsParams[1],null));
    }
}
