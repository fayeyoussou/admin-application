package sn.youdev.adminapplication.mapper;

import org.mapstruct.*;
import sn.youdev.adminapplication.dto.AppRoleDto;
import sn.youdev.adminapplication.entities.AppRole;

@Mapper(componentModel = "spring")
public interface AppRoleMapper {
    AppRole toAppRole(AppRoleDto appRoleDto);

    AppRoleDto fromAppRole(AppRole appRole);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AppRole partialUpdate(AppRoleDto appRoleDto, @MappingTarget AppRole appRole);
}