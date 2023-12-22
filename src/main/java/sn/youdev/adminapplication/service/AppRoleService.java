package sn.youdev.adminapplication.service;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.youdev.adminapplication.dao.AppRoleRepository;
import sn.youdev.adminapplication.dto.AppRoleDto;
import sn.youdev.adminapplication.exception.EntityNotFoundException;
import sn.youdev.adminapplication.exception.RequestException;
import sn.youdev.adminapplication.mapper.AppRoleMapper;

import java.util.List;
import java.util.Locale;
import java.util.stream.StreamSupport;

@Service
public class AppRoleService {
    private final AppRoleRepository appRoleRepository;
    private final AppRoleMapper appRolesMapper;
    private final MessageSource messageSource;
    public AppRoleService(AppRoleRepository appRoleRepository, AppRoleMapper appRolesMapper,MessageSource messageSource) {
        this.appRoleRepository = appRoleRepository;

        this.appRolesMapper = appRolesMapper;
        this.messageSource = messageSource;
    }




    @Transactional(readOnly = true)
    public List<AppRoleDto> getAppRoles() {
        return StreamSupport.stream(appRoleRepository.findAll().spliterator(), false)
                .map(appRolesMapper::fromAppRole)
                .toList();
    }

    @Transactional(readOnly = true)
    public AppRoleDto getAppRoleById(int id) {
        return appRolesMapper.fromAppRole(appRoleRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }
    @Transactional(readOnly = true)
    public AppRoleDto getAppRoleByNom(String nom) {
        return appRolesMapper.fromAppRole(appRoleRepository.findAppRoleByNom(nom)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{nom},
                                Locale.getDefault()))));
    }

    @Transactional
    public AppRoleDto createAppRoles(AppRoleDto appRoles) {
        return appRolesMapper.fromAppRole(appRoleRepository.save(appRolesMapper.toAppRole(appRoles)));
    }

    @Transactional
    public AppRoleDto updateAppRoles(int id, AppRoleDto appRoles) {
        return appRoleRepository.findById(id)
                .map(entity -> appRolesMapper.fromAppRole(
                            appRoleRepository.save(appRolesMapper.toAppRole(appRoles)))
                ).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteAppRoles(int id) {
        try {
            appRoleRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("role.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
