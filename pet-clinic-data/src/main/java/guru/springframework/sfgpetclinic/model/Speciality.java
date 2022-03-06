package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by jt on 7/29/18.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "specialties")
@SuppressWarnings("JpaDataSourceORMInspection")
public class Speciality extends BaseEntity {

    @Builder
    public Speciality(Long id, String description) {
        super(id);
        this.description = description;
    }

    @Column(name = "description")
    private String description;

}
