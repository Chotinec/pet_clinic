package ru.lesson.lessions.command;

import ru.lesson.lessions.Clinic;
import ru.lesson.lessions.Operation;
import ru.lesson.lessions.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Command executor
 * Created by art on 15.05.16.
 */
public class CommandExecutor {

    /*
    * Lis of commands
    */
    private static Map<Operation, Command> comands;

    static {
        comands = new HashMap<Operation, Command>();
        comands.put(Operation.ADDCLIENT, new AddCommand());
        comands.put(Operation.DELETECLIENT, new DeleteCommand());
        comands.put(Operation.FIND, new FindCommand());
        comands.put(Operation.SHOW, new ShowCommand());
        comands.put(Operation.EXIT, new ShowCommand());
        comands.put(Operation.ADDPET, new AddPetCommand());
    }

    private CommandExecutor(){}

    /**
     * Execute command
     * @param operation operation
     * @param clinic clinic
     * @throws InterruptOperationException
     */
    public static void execute(Operation operation, Clinic clinic) throws InterruptOperationException
    {
        comands.get(operation).execute(clinic);
    }
}
