package sn.youdev.adminapplication.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.youdev.adminapplication.dto.request.AppUserRequest;
import sn.youdev.adminapplication.dto.response.AppUserResp;
import sn.youdev.adminapplication.service.AppUserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;
    @GetMapping
    public List<AppUserResp> listUsers(){
        return appUserService.getAppUsers();
    }
    @GetMapping("{id}")
    public AppUserResp findOneUser(@PathVariable final int id){
        return appUserService.getAppUserById(id);
    }
    @PostMapping
    public AppUserResp createUser(@RequestBody @Valid AppUserRequest request){
        return appUserService.createAppUser(request);
    }
    @PutMapping("{id}")
    public AppUserResp updateUser(@PathVariable final int id,@RequestBody final AppUserRequest request){
        return appUserService.updateAppUser(id,request);
    }
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable final int id){
         appUserService.deleteAppUser(id);
    }
}
