package ru.lesson.lessions.command;

import ru.lesson.lessions.Animals.Pet;
import ru.lesson.lessions.Clinic;
import ru.lesson.lessions.ConsoleHelper;
import ru.lesson.lessions.PetCreator;
import ru.lesson.lessions.exception.InterruptOperationException;

/**
 * Adding pet command
 * Created by art on 30.05.16.
 */
public class AddPetCommand implements Command {

    private static final String NO_SUCH_PET = "There is no such pet!";

    /**
     * Add pet
     * @param clinic clinic
     * @throws InterruptOperationException
     */
    @Override
    public void execute(Clinic clinic) throws InterruptOperationException {
        String id = ConsoleHelper.askClientId();
        String[] petParams = ConsoleHelper.askPet();
        Pet pet = PetCreator.createPet(petParams[0],petParams[1]);
        if (pet == null) throw new InterruptOperationException(NO_SUCH_PET);
        clinic.get(id).addPet(pet);
    }
}
