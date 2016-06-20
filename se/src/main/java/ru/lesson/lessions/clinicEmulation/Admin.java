package ru.lesson.lessions.clinicEmulation;

import ru.lesson.lessions.Animals.Pet;
import ru.lesson.lessions.Client;
import ru.lesson.lessions.Clinic;
import ru.lesson.lessions.PetCreator;
import ru.lesson.lessions.exception.InterruptOperationException;

/**
 * Admin emulation
 * Created by art on 22.05.16.
 */
class Admin extends Thread {

    private final Clinic clinic;
    private final String[] onerName;
    private final String[] petName;
    private final String[] petType;


     Admin(Clinic clinic, String[] onerName, String[] petName, String[] petType) {
        super();
        this.clinic = clinic;
        this.onerName = onerName;
        this.petName = petName;
        this.petType = petType;
    }

    @Override
    public void run(){

        for (int i = 0; i < onerName.length; i++){
            Client client = new Client(
                    ""+i,
                    onerName[i],
                    null
            );
            client.addPet(PetCreator.createPet(petType[i],petName[i]));
            try {
                clinic.addClient(client);
                for (Pet pet : client.getPets()) {
                    System.out.println(String.format(
                            "Admin: Add new client %s, with pet %s",
                            client.getId(), pet.getName()));
                }
            } catch (InterruptOperationException e) {
                e.printStackTrace();
            }
        }
    }
}
