package sn.youdev.adminapplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link sn.youdev.adminapplication.entities.AppRole}
 */

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class AppRoleDto implements Serializable {
    private Integer id;
    @NotNull @NotBlank
    private String nom;
}