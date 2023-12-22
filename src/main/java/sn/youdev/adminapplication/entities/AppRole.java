package sn.youdev.adminapplication.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "app_roles")
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(unique = true,nullable = false,length = 100)
    private String nom;
    @ManyToMany(mappedBy = "appRoles")
    private List<AppUser> appUsers;
}