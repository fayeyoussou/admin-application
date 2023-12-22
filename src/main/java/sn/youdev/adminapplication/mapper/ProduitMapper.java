package sn.youdev.adminapplication.mapper;


import org.mapstruct.Mapper;
import sn.youdev.adminapplication.dto.request.ProduitRequest;
import sn.youdev.adminapplication.dto.response.ProduitResp;
import sn.youdev.adminapplication.entities.Produit;


@Mapper(componentModel = "spring")
public interface ProduitMapper {
    Produit toProduit(ProduitRequest produitRequest);
    ProduitResp fromProduit(Produit produit);
}
