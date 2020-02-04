package letocha.michal.petsProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2)
    private String name;

    @NotBlank
    private String type;

    @NotBlank
    private String breed;

    private String description;

    @NotNull
    private Integer age;

    @NotBlank
    private String animalCharacter;
}