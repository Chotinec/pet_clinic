package ru.lesson.lessions;

/**
 * Created by art on 15.05.16.
 * All operations
 */
public enum Operation {
    ADDCLIENT, DELETECLIENT, ADDPET,SHOW, FIND, EXIT;;

    /**
     * Find operation by number
     * @param i number operation
     * @return operation
     * @throws IllegalAccessException if notsuch number
     */
    public static Operation getAllowableOperationByOrdinal(Integer i) throws IllegalAccessException{
        switch (i){
            case 1: return Operation.ADDCLIENT;
            case 2: return Operation.DELETECLIENT;
            case 3: return Operation.SHOW;
            case 4: return Operation.FIND;
            case 5: return Operation.EXIT;
            case 6: return Operation.ADDPET;
            default:
                throw new IllegalArgumentException();
        }
    }
}
