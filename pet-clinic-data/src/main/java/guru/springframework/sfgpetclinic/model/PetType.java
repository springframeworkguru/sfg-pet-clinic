package guru.springframework.sfgpetclinic.model;

/**
 * Created by jt on 7/13/18.
 */

public class PetType extends BaseEntity {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
