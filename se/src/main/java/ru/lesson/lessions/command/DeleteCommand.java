package ru.lesson.lessions.command;

import ru.lesson.lessions.Clinic;
import ru.lesson.lessions.ConsoleHelper;
import ru.lesson.lessions.exception.InterruptOperationException;

/**
 * Delete command
 * Created by art on 15.05.16.
 */
class DeleteCommand implements Command {

    /**
     * Execute delete command
     * @param clinic clinic
     * @throws InterruptOperationException
     */
    @Override
    public void execute(Clinic clinic) throws InterruptOperationException {
        String id = ConsoleHelper.askDeleteOperation();
        clinic.delete(id);
    }
}
