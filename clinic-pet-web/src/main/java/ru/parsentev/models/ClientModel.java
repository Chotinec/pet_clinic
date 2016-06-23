package ru.parsentev.models;

import java.util.Set;

/**
 * Created by art on 19.06.16.
 */
public class ClientModel extends Base{

    private String login;
    private String password;
    private String name;
    private String email;
    private String phone;

    private Set<PetModel> petModels;

    public ClientModel(){}

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
