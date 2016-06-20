package ru.lesson.lessions;

import ru.lesson.lessions.Animals.Pet;
import ru.lesson.lessions.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by art on 15.05.16.
 * Operations with console
 */
public class ConsoleHelper {

    private static final String UNVAILABLE_CONSOLE = "Console is unavailable.";
    private static final String EXIT = "EXIT";
    private static final String END = "The end!";
    private static final String ENTER_OPERATION = "Ener operation :";
    private static final String ADD_CLIENT = "1 - add client";
    private static final String DELETE_CLIENT = "2 - delete client";
    private static final String SHOW_CLIENT = "3 - show client";
    private static final String FIND_CLIENT = "4 - find client";
    private static final String EXIT_OPERATION = "5 - exit";
    private static final String ADD_PET_OPERATION = "6 - add pet";
    private static final String INCORRECT_DATA = "Incorrect data! Try again.";
    private static final String ASK_CLIENT_ID = "Enter client id";
    private static final String ASK_CLIENT_NAME = "Enter client name:";
    private static final String CHOOSE_PET = "Enter pet (dog/cat):";
    private static final String ASK_PET_NAME = "Enter pet name";
    private static final String NO_CLIENTS = "No clients in the clinic!";
    private static final String CLIENT_NAME = "Client name: %s";
    private static final String PET_NAME = "Pet name: %s";
    private static final String EMPTY_STRING = "";
    private static final String FIND_CLIENT_BY_ID = "1 - find client by id";
    private static final String FIND_CLIENT_BY_NAME = "2 - find clients by client name";
    private static final String FIND_CLIENT_BY_PET_NAME = "3 - find clients by pet name";


    private static Logger logger = Logger.getLogger(ConsoleHelper.class.getName());

    /* Input stream */
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Print message
     * @param message to print
     */
    public static void printMessage(String message){
        System.out.println(message);
    }

    /**
     * Read input string
     * @return string
     * @throws InterruptOperationException if console is unavailable
     */
    public static String readString() throws InterruptOperationException {
        String str = null;
        try {
            str = reader.readLine();
        } catch (IOException e) {
            logger.log(Level.SEVERE, UNVAILABLE_CONSOLE);
        }
        if (EXIT.equalsIgnoreCase(str))
        {
            throw new InterruptOperationException(END);
        }
        return str;
    }

    /**
     * Ask operartion from user
     * @return operation
     * @throws InterruptOperationException
     */
     static Operation askOperation() throws InterruptOperationException {
        printMessage(ENTER_OPERATION);
        printMessage(ADD_CLIENT);
        printMessage(DELETE_CLIENT);
        printMessage(SHOW_CLIENT);
        printMessage(FIND_CLIENT);
        printMessage(EXIT_OPERATION);
        printMessage(ADD_PET_OPERATION);

        Operation operation ;

        while (true)
        {
            String string = readString();
            try
            {
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(string));
            }
            catch (IllegalAccessException e)
            {
                printMessage(INCORRECT_DATA);
                continue;
            }
            break;
        }

        return operation;
    }

    /**
     * Ask client id
     * @return client id
     * @throws InterruptOperationException
     */
    public static String askClientId() throws InterruptOperationException {
        printMessage( ASK_CLIENT_ID);
        return readString();
    }

    /**
     * Ask pet params
     * @return pet params
     * @throws InterruptOperationException
     */
    public static String[] askPet() throws InterruptOperationException {
        String[] params = new String[2];
        printMessage(CHOOSE_PET);
        params[0] = readString();
        printMessage(ASK_PET_NAME);
        params[1] = readString();
        return params;
    }

    /**
     * Ask client params
     * @return client params
     * @throws InterruptOperationException
     */
    public static String[] askClient() throws InterruptOperationException {
        String[] params = new String[2];
        printMessage(ASK_CLIENT_ID);
        params[0] = readString();
        printMessage(ASK_CLIENT_NAME);
        return params;
    }

    /**
     * Ask string
     * @param message question
     * @return answer
     * @throws InterruptOperationException
     */
    public static String askString(String message) throws InterruptOperationException {
        printMessage(message);
        return readString();
    }

    /**
     * Print list of clients
     * @param list list
     */
    public static void printList(Collection<Client> list) throws InterruptOperationException {
        if (list == null){
            throw new InterruptOperationException(NO_CLIENTS);
        }
        if (list.isEmpty()){
            printMessage(NO_CLIENTS);
        }

        for (Client client : list) {
            printMessage(String.format(CLIENT_NAME, client.getName()));
            for (Pet pet : client.getPets()) {
                printMessage(String.format(PET_NAME, pet.getName()));
            }
        }
        printMessage(EMPTY_STRING);
    }

    /**
     * Ask number of delete operation
     * @return number of delete operation
     */
    public static String askDeleteOperation() throws InterruptOperationException {
        printMessage(ASK_CLIENT_ID);
        return readString();
    }


    /**
     * Ask find operation number
     * @return operation number
     */
    public static int askFindOperation() throws InterruptOperationException {
        printMessage(ENTER_OPERATION);
        printMessage(FIND_CLIENT_BY_ID);
        printMessage(FIND_CLIENT_BY_NAME);
        printMessage(FIND_CLIENT_BY_PET_NAME);

        int operation ;

        while (true)
        {
            String string = readString();
            try
            {
                operation = Integer.parseInt(string);
            }
            catch (Exception e)
            {
                printMessage(INCORRECT_DATA);
                continue;
            }

            if (operation > 3 && operation <= 0){
                printMessage(INCORRECT_DATA);
                continue;
            }

            break;
        }

        return operation;
    }

}
