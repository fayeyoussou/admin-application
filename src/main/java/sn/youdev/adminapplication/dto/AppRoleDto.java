package sn.youdev.adminapplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link sn.youdev.adminapplication.entities.AppRole}
 */
@Value
@Getter
@Setter
public class AppRoleDto implements Serializable {
    Integer id;
    @NotNull @NotBlank
    String nom;
}