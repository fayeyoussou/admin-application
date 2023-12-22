package sn.youdev.adminapplication.mapper;

import org.mapstruct.Mapper;
import sn.youdev.adminapplication.dto.request.AppUserRequest;
import sn.youdev.adminapplication.dto.response.AppUserResp;
import sn.youdev.adminapplication.entities.AppUser;

@Mapper(componentModel = "spring")
public interface AppUserMapper {
    AppUser toAppUser(AppUserRequest appUserRequest);
    AppUserResp fromAppUser(AppUser appUser);
}
