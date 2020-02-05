package letocha.michal.petsProject.entity;

import letocha.michal.petsProject.validator.EmailExistence;
import letocha.michal.petsProject.validator.EmailExistenceEdit;
import letocha.michal.petsProject.validator.PasswordMatches;
import letocha.michal.petsProject.validator.validationGroups.EditPasswordValidationGroupName;
import letocha.michal.petsProject.validator.validationGroups.EditPhotoValidationGroupName;
import letocha.michal.petsProject.validator.validationGroups.EditValidationGroupName;
import letocha.michal.petsProject.validator.validationGroups.RegisterValidationGroupName;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@PasswordMatches(groups = {EditPasswordValidationGroupName.class, RegisterValidationGroupName.class})
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(groups = {EditValidationGroupName.class, RegisterValidationGroupName.class})
    @Size(min = 4, groups = {EditValidationGroupName.class, RegisterValidationGroupName.class})
    private String username;

    @NotBlank(groups = {EditValidationGroupName.class, RegisterValidationGroupName.class})
    @Email(groups = {EditValidationGroupName.class, RegisterValidationGroupName.class})
    @EmailExistence(groups = {RegisterValidationGroupName.class})
    @EmailExistenceEdit(groups = EditValidationGroupName.class)
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(groups = {EditPasswordValidationGroupName.class, RegisterValidationGroupName.class})
    @Pattern(regexp = "(?=.*\\d).{6,}", groups = {EditPasswordValidationGroupName.class,
            RegisterValidationGroupName.class})
    private String password;

    @NotBlank(groups = {RegisterValidationGroupName.class, EditPasswordValidationGroupName.class})
    @Transient
    private String repassword;

    private String description;

    private int admin = 0;
    private int enable = 1;
    //    Defaultowa nazwa zdjecia przypisana odrazu, pozniej bedziemy zmieniac
    @Pattern(regexp = ".*\\.(jpg|png|gif)", groups = {EditPhotoValidationGroupName.class}, message = "Niepoprawny plik," +
            " poprawne pliki to .jpg, .png, .gif")
    private String photo = "userNoPhoto.jpg";

    @AssertTrue(groups = RegisterValidationGroupName.class)
    private boolean acceptRules;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Animal> animals;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}