package ru.lesson.lessions.command;

import ru.lesson.lessions.Clinic;
import ru.lesson.lessions.ConsoleHelper;
import ru.lesson.lessions.exception.InterruptOperationException;

/**
 * Show command
 * Created by art on 15.05.16.
 */
class ShowCommand implements Command {

    private static final String SHOW_ALL_CLIENTS = "Show all clients in the clinic: ";

    /**
     * Execute show command
     * @param clinic clinic
     * @throws InterruptOperationException
     */
    @Override
    public void execute(Clinic clinic) throws InterruptOperationException {
        ConsoleHelper.printMessage(SHOW_ALL_CLIENTS);
        ConsoleHelper.printList(clinic.getClients());
    }
}
