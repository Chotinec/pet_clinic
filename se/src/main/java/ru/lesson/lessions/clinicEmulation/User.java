package ru.lesson.lessions.clinicEmulation;

import ru.lesson.lessions.Animals.Pet;
import ru.lesson.lessions.Client;
import ru.lesson.lessions.Clinic;

/**
 * User emulation
 * Created by art on 22.05.16.
 */
 class User extends Thread {
    private Clinic clinic;

    User(Clinic clinic) {
        super();
        this.clinic = clinic;
    }

    @Override
    public void run(){

        for (Client client : clinic.getClients()){
            for (Pet pet : client.getPets()) {
                String oldName = pet.getName();
                String newName = new StringBuilder(oldName).reverse().toString();
                //pet.setName(newName);
                System.out.println(String.format("User: old name %s : new name %s", oldName, newName));
            }
        }
    }
}
