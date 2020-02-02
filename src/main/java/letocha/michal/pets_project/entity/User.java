package letocha.michal.pets_project.entity;

import letocha.michal.pets_project.validator.EmailExistence;
import letocha.michal.pets_project.validator.PasswordMatches;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@PasswordMatches
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 4)
    private String username;

    @NotBlank
    @Email
    @EmailExistence
    private String email;

    @NotBlank
    @Pattern(regexp = "(?=.*\\d).{6,}")
    private String password;

    @NotBlank
    @Transient
    private String repassword;

    private String description;

    private int admin = 0;
    private int enable = 1;
    //    Defaultowa nazwa zdjecia przypisana odrazu, pozniej bedziemy zmieniac
    private String photo = "userNoPhoto.jpg";

    @AssertTrue
    private boolean acceptRules;

    public boolean isAcceptRules() {
        return acceptRules;
    }

    public void setAcceptRules(boolean acceptRules) {
        this.acceptRules = acceptRules;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
