package sn.youdev.adminapplication.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link sn.youdev.adminapplication.entities.AppUser}
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUserRequest implements Serializable {
    @NotNull(message = "le prenom ne peut etre null")
    @NotEmpty(message = "donner une valeur au prenom")
    @NotBlank(message = "donner une valeur au prenom")
    @Length(message = "La taille doit etre entre 2 et 100", min = 2, max = 200)
    private String prenom;
    @NotNull
    @NotBlank
    @Length(min = 1, max = 150)
    private String nom;
    @Size(min = 1)
    private List<Integer> appRoleIds;
    @NotNull
    @Email(message = "format email invalide")
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    @Length(message = "La taille du mot de passe doit etre superieur a 6 et inferieur a 30", min = 6, max = 30)
    private String motDePasse;
    private int etat;
}