package letocha.michal.petsProject.entity;

import letocha.michal.petsProject.validator.EmailExistence;
import letocha.michal.petsProject.validator.EmailExistenceEdit;
import letocha.michal.petsProject.validator.PasswordMatches;
import letocha.michal.petsProject.validator.UserExistence;
import letocha.michal.petsProject.validator.validationGroups.EditPasswordValidationGroupName;
import letocha.michal.petsProject.validator.validationGroups.EditValidationGroupName;
import letocha.michal.petsProject.validator.validationGroups.LoginValidationGroupName;
import lombok.Data;

import javax.persistence.CascadeType;
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
import javax.validation.groups.Default;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@PasswordMatches(groups = {EditPasswordValidationGroupName.class, Default.class})
@UserExistence(groups = {LoginValidationGroupName.class})
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(groups = {EditValidationGroupName.class, Default.class})
    @Size(min = 4, groups = {EditValidationGroupName.class, Default.class})
    private String username;

    @NotBlank(groups = {EditValidationGroupName.class, Default.class})
    @Email(groups = {EditValidationGroupName.class, Default.class})
    @EmailExistence
    @EmailExistenceEdit(groups = {EditValidationGroupName.class})
    private String email;

    @NotBlank(groups = {EditPasswordValidationGroupName.class, Default.class})
    @Pattern(regexp = "(?=.*\\d).{6,}", groups = {EditPasswordValidationGroupName.class, Default.class})
    private String password;

    @NotBlank
    @Transient
    private String repassword;

    private String description;

    private int admin = 0;
    private int enable = 1;
    //    Defaultowa nazwa zdjecia przypisana odrazu, pozniej bedziemy zmieniac
    @Pattern(regexp = ".*\\.(jpg|png|gif)", groups = {EditValidationGroupName.class}, message = "Niepoprawny plik," +
            " poprawne pliki to .jpg, .png, .gif")
    private String photo = "userNoPhoto.jpg";

    @AssertTrue
    private boolean acceptRules;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Animal> animals;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles")
    private Set<Role> roles;
}