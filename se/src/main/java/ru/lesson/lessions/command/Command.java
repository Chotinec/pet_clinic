package ru.lesson.lessions.command;

import ru.lesson.lessions.Clinic;
import ru.lesson.lessions.exception.InterruptOperationException;

/**
 * Command interface
 * Created by art on 15.05.16.
 */
interface Command {
    void execute(Clinic clinic) throws InterruptOperationException;
}
