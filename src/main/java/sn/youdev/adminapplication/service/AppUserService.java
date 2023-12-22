package sn.youdev.adminapplication.service;


import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.youdev.adminapplication.dao.AppUserRepository;
import sn.youdev.adminapplication.dto.request.AppUserRequest;
import sn.youdev.adminapplication.dto.response.AppUserResp;
import sn.youdev.adminapplication.exception.EntityNotFoundException;
import sn.youdev.adminapplication.exception.RequestException;
import sn.youdev.adminapplication.mapper.AppUserMapper;

import java.util.List;
import java.util.Locale;
import java.util.stream.StreamSupport;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final AppUserMapper appUserMapper;
    private final MessageSource messageSource;

    public AppUserService(AppUserRepository appUserRepository, AppUserMapper appUserMapper, MessageSource messageSource) {
        this.appUserRepository = appUserRepository;
        this.appUserMapper = appUserMapper;
        this.messageSource = messageSource;
    }
    @Transactional(readOnly = true)
    public List<AppUserResp> getAppUsers() {
        return StreamSupport.stream(appUserRepository.findAll().spliterator(), false)
                .map(appUserMapper::fromAppUser)
                .toList();
    }
    @Transactional(readOnly = true)
    public AppUserResp getAppUserById(int id) {
        return appUserMapper.fromAppUser(appUserRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }
    @Transactional
    public AppUserResp createAppUser(AppUserRequest request) {
        return appUserMapper.fromAppUser(appUserRepository.save(appUserMapper.toAppUser(request)));
    }

    @Transactional
    public AppUserResp updateAppUser(int id, AppUserRequest request) {
        return appUserRepository.findById(id)
                .map(entity -> appUserMapper.fromAppUser(
                            appUserRepository.save(appUserMapper.toAppUser(request)))
                ).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                        Locale.getDefault())));
    }
    @Transactional
    public void deleteAppUser(int id) {
        try {
            appUserRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
