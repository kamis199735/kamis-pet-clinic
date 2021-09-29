package kamis199735.springframework.kamispetclinic.model;

public class PetType extends BaseEntity {
    //komentarz

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
