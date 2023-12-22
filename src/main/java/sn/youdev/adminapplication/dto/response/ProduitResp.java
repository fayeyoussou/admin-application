package sn.youdev.adminapplication.dto.response;


import java.io.Serializable;

/**
 * DTO for {@link sn.youdev.adminapplication.entities.Produit}
 */
public record ProduitResp(Integer id, String libelle, double qtStock, AppUserResp appUser) implements Serializable {
}