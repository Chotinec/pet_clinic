package ru.lesson.lessions.clinicEmulation;

import ru.lesson.lessions.Clinic;


import java.util.Arrays;
import java.util.List;

/**
 * Clinic emulator
 * Created by art on 22.05.16.
 */
class ClinicEmulator {

    public static void main(String[] args) throws InterruptedException {
        Clinic clinic = new Clinic();
        String[] clienName = {"Sam", "Volf", "Cristal","Sandra", "Jym"};
        String[] petName = {"Forty", "Dinky", "Popy", "Liev", "Samson"};
        String[] petType = {"dog", "cat", "cat", "dog", "cat"};

        List<User> users = Arrays.asList(new User(clinic), new User(clinic), new User(clinic));

        for (User user : users){
            user.start();
        }

        Admin admin1= new Admin(clinic, clienName, petName, petType);

        admin1.start();
        admin1.join();

    }



}
