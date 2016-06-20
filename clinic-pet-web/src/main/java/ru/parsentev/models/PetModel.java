package ru.parsentev.models;

/**
 * Pet model
 * Created by art on 19.06.16.
 */
public class PetModel {

    private Long id;
    private String name;

    private PetTypeModel petTypeModel;
    private ClientModel clientModel;

    public PetModel(){}

    public PetModel(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetTypeModel getPetTypeModel() {
        return petTypeModel;
    }

    public void setPetTypeModel(PetTypeModel petTypeModel) {
        this.petTypeModel = petTypeModel;
    }

    public ClientModel getClientModel() {
        return clientModel;
    }

    public void setClientModel(ClientModel clientModel) {
        this.clientModel = clientModel;
    }
}
