package sn.youdev.adminapplication.dto;


import sn.youdev.adminapplication.dto.request.AppUserRequest;
import sn.youdev.adminapplication.dto.request.ProduitRequest;

import sn.youdev.adminapplication.dto.response.AppUserResp;
import sn.youdev.adminapplication.dto.response.ProduitResp;
import sn.youdev.adminapplication.entities.AppRole;
import sn.youdev.adminapplication.entities.AppUser;
import sn.youdev.adminapplication.entities.Produit;
import sn.youdev.adminapplication.exception.NoInstatiateException;

import java.util.List;

public class Mapper {
    private Mapper() {
        throw new NoInstatiateException(this.getClass().getName());
    }
    public static AppRole appRoleDtoToAppRole(AppRoleDto appRoleDto){
        AppRole appRole = new AppRole();
        appRole.setNom(appRoleDto.getNom());
        return appRole;
    }
    public static AppRoleDto appRoleToAppRoleDto(AppRole appRole){
        return new AppRoleDto(appRole.getId() ,appRole.getNom());

    }
    public static AppUser appUserRequestToAppUser(AppUserRequest appUserRequest){
        AppUser appUser = new AppUser();
        appUser.setEtat(appUserRequest.getEtat());
        appUser.setEmail(appUserRequest.getEmail());
        appUser.setNom(appUserRequest.getNom());
        appUser.setPrenom(appUserRequest.getPrenom());
        appUser.setMotDePasse(appUserRequest.getMotDePasse());
        return appUser;
    }
    public static AppUserResp appUserToAppUserResponse(AppUser appUser){
        List<AppRoleDto> roles = appUser.getAppRoles().stream().map(Mapper::appRoleToAppRoleDto).toList();
        return new AppUserResp(
                appUser.getId(),
                appUser.getPrenom(),
                appUser.getNom(),
                roles,
                appUser.getEmail(),
                appUser.getMotDePasse(),
                appUser.getEtat()
        );
    }
    public static List<AppUserResp> appUsersToAppUserResps(List<AppUser> users){
        return users.stream().map(Mapper::appUserToAppUserResponse).toList();
    }
    public static Produit produitRequestToProduit(ProduitRequest produitRequest){
        Produit produit = new Produit();
        produit.setLibelle(produitRequest.getLibelle());
        produit.setQtStock(produitRequest.getQtStock());
        return produit;
    }
    public static ProduitResp produitToProduitResp(Produit produit){
        return new ProduitResp(
                produit.getId(),
                produit.getLibelle(),
                produit.getQtStock(),
                appUserToAppUserResponse(produit.getAppUser())
        );
    }
    public static List<ProduitResp> produitsToProduitResps(List<Produit> produits){
        return produits.stream().map(Mapper::produitToProduitResp).toList();
    }
}
