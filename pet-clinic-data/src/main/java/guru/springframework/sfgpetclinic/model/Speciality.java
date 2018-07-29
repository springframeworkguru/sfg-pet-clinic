package guru.springframework.sfgpetclinic.model;

/**
 * Created by jt on 7/29/18.
 */
public class Speciality extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
