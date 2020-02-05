package letocha.michal.petsProject.entity;

import letocha.michal.petsProject.validator.validationGroups.FirstPartAnimalAddFormGroupName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(groups = FirstPartAnimalAddFormGroupName.class)
    @Size(min = 2, groups = FirstPartAnimalAddFormGroupName.class)
    private String name;

    //    Rodzaj zwierzecia
    @NotNull(groups = FirstPartAnimalAddFormGroupName.class)
    @OneToOne
    @JoinColumn(name = "type_id")
    private Type type;

    private String description;

    //    Miesiace
    @Min(1)
    private Integer age;

    @ManyToMany
    @JoinTable(name = "animals_animalCharacters")
    private List<AnimalCharacter> animalCharacters;
}