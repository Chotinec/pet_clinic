package ru.parsentev.models;

import java.util.Set;

/**
 * Pet type model
 * Created by art on 19.06.16.
 */
public class PetTypeModel {

    private Long type_id;
    private String type;

    private Set<PetModel> petModels;

    public PetTypeModel(){}


    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<PetModel> getPetModels() {
        return petModels;
    }

    public void setPetModels(Set<PetModel> petModels) {
        this.petModels = petModels;
    }
}
