package sn.youdev.adminapplication.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.youdev.adminapplication.dto.AppRoleDto;
import sn.youdev.adminapplication.entities.AppRole;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class AppRoleServiceTest {
    @Autowired
    private AppRoleService appRolesService;

    @Test
    void getAppRoles() {
        List<AppRoleDto> appRolesList =
                appRolesService.getAppRoles();

        Assertions.assertEquals(1, appRolesList.size());
    }

    @Test
    void getAppRole() {
        AppRoleDto appRoles = appRolesService.getAppRoleById(1);

        Assertions.assertNotNull(appRoles);
    }

    @Test
    void createAppRoles() {

        AppRoleDto appRoles = new AppRoleDto();
        appRoles.setNom("ROLE_USER");

        AppRoleDto appRolesSave = appRolesService.createAppRoles(appRoles);

        Assertions.assertNotNull(appRolesSave);
        //Assertions.assertEquals(appRoles.getNom(), appRolesSave.getNom());
    }

    @Test
    void updateAppRoles() {
        AppRoleDto appRoles = new AppRoleDto();
        appRoles.setNom("ROLE_TECH");

        AppRoleDto appRolesSave = appRolesService.updateAppRoles(3, appRoles);

        Assertions.assertEquals("ROLE_TECH", appRolesSave.getNom());

    }

    @Test
    void deleteAppRoles() {

        appRolesService.deleteAppRoles(3);
        Assertions.assertTrue(true);
    }

    @Test
    void operation() {
        int val1 = 1;
        int val2 = 2;
        int val3 = val1 + val2;
        Assertions.assertEquals(3, val3);
    }
}