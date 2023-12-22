package sn.youdev.adminapplication.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * DTO for {@link sn.youdev.adminapplication.entities.Produit}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProduitRequest implements Serializable {
    @NotNull(message = "Veuillez remplir le champs libelle")
    @Length(message = "La taille du libelle doit etre entre 2 et 200", min = 2, max = 200)
    private String libelle;
    @PositiveOrZero(message = "La quantite doit etre positive")
    private double qtStock;
    private Integer appUserId;
}