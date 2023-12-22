package sn.youdev.adminapplication.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.youdev.adminapplication.dto.AppRoleDto;
import sn.youdev.adminapplication.service.AppRoleService;

import java.util.List;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class AppRoleController {
    private final AppRoleService appRoleService;

    @GetMapping
    public List<AppRoleDto> getRoles(){
        return appRoleService.getAppRoles();
    }
    @GetMapping("/{nom}")
    public AppRoleDto getAppRoleById(@PathVariable("nom") final String nom){
        return appRoleService.getAppRoleByNom(nom);
    }
    @PostMapping
    public AppRoleDto saveAppRole(@RequestBody final @Valid AppRoleDto appRoleDto){
        return appRoleService.createAppRoles(appRoleDto);
    }
    @PutMapping("/{id}")
    public AppRoleDto majAppRole(@PathVariable("id") final Integer id,@RequestBody final AppRoleDto appRoleDto){
        return appRoleService.updateAppRoles(id,appRoleDto);
    }
    @DeleteMapping("/{id}")
    public void deleteAppRole(@PathVariable("id") final Integer id){
        appRoleService.deleteAppRoles(id);
    }

}
