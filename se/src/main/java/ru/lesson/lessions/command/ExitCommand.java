package ru.lesson.lessions.command;

import ru.lesson.lessions.Clinic;
import ru.lesson.lessions.ConsoleHelper;
import ru.lesson.lessions.exception.InterruptOperationException;

/**
 * Exit command
 * Created by art on 15.05.16.
 */
class ExitCommand implements Command {

    /**
     * Exute exit operatin
     * @param clinic clinic
     * @throws InterruptOperationException
     */
    @Override
    public void execute(Clinic clinic) throws InterruptOperationException {
        System.out.println("Do you whant to Exit?");
        String exit = exit = ConsoleHelper.readString();
        if ("yes".toUpperCase().equals(exit.toUpperCase().trim())){
            ConsoleHelper.printMessage("Good by!");
        }
    }
}
