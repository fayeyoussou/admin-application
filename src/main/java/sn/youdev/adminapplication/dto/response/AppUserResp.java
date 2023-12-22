package sn.youdev.adminapplication.dto.response;

import sn.youdev.adminapplication.dto.AppRoleDto;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link sn.youdev.adminapplication.entities.AppUser}
 */
public record AppUserResp(Integer id, String prenom, String nom, List<AppRoleDto> appRoles, String email,
                          String motDePasse, int etat) implements Serializable {
}