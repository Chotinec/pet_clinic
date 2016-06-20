package ru.parsentev.models;

import java.util.Set;

/**
 * Created by art on 19.06.16.
 */
public class ClientModel {

    private String client_id;
    private String name;
    private String email;
    private String phone;

    private Set<PetModel> petModels;

    public ClientModel(){}

    public ClientModel(String client_id, String name, String email, String phone){
        this.client_id = client_id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }


    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<PetModel> getPetModels() {
        return petModels;
    }

    public void setPetModels(Set<PetModel> petModels) {
        this.petModels = petModels;
    }
}
