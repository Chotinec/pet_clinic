package ru.lesson.lessions.command;

import ru.lesson.lessions.Client;
import ru.lesson.lessions.Clinic;
import ru.lesson.lessions.ConsoleHelper;
import ru.lesson.lessions.exception.InterruptOperationException;

import java.util.ArrayList;

/**
 * Find command
 * Created by art on 15.05.16.
 */
class FindCommand implements Command {

    private static final String ASK_CLIENT_NAME = "Write client name:";
    private static final String ASK_PET_NAME = "Write pet name name:";

    /**
     * Exute find command
     * @param clinic clinic
     * @throws InterruptOperationException
     */
    @Override
    public void execute(Clinic clinic) throws InterruptOperationException {
        int number = ConsoleHelper.askFindOperation();
        String name;
        ArrayList<Client> findClients = new ArrayList<Client>();
        if (number == 1){
            name = ConsoleHelper.askString(ASK_CLIENT_NAME);
            findClients = clinic.findClientByClientName(name);
        }
        if (number == 2){
            name = ConsoleHelper.askString(ASK_PET_NAME);
            findClients = clinic.findClientByPetName(name);
        }

        ConsoleHelper.printList(findClients);
    }
}
