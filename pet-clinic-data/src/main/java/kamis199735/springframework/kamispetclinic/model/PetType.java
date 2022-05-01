package kamis199735.springframework.kamispetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {
    //komentarz

    @Column(name="name")
    private String name;

    @Override
    public String toString() {
        return "PetTypik{" +
                "name='" + name + '\'' +
                '}';
    }
}
