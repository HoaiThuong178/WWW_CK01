package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class User {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 15)
    private String mobile;
    @Column(name = "last_login")
    private LocalDateTime lastLogin;
    @Column(length = 50,name = "last_name")
    private String lastName;
    @Column(columnDefinition = "tinytext")
    private String intro;
    @Column(columnDefinition = "tinytext")
    private String profile;
    @Column(name = "registered_at",nullable = false)
    private LocalDateTime registeredAt;
    @Column(nullable = false,name = "password_hash",length = 32)
    private String passwordHash;
    @Column(length = 50,name = "middle_name")
    private String middleName;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Post> posts;
    @Column(length = 50,name = "first_name")
    private String firstName;
    @Column(length = 50)
    private String email;

    public User(LocalDateTime registeredAt, String passwordHash) {
        this.registeredAt = registeredAt;
        this.passwordHash = passwordHash;
    }

    public User(String mobile, LocalDateTime lastLogin, String lastName, String intro, String profile, LocalDateTime registeredAt, String passwordHash, String middleName, String firstName, String email) {
        this.mobile = mobile;
        this.lastLogin = lastLogin;
        this.lastName = lastName;
        this.intro = intro;
        this.profile = profile;
        this.registeredAt = registeredAt;
        this.passwordHash = passwordHash;
        this.middleName = middleName;
        this.firstName = firstName;
        this.email = email;
    }
}
