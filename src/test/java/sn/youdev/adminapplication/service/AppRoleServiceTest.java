package sn.youdev.adminapplication.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.youdev.adminapplication.dto.AppRoleDto;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppRoleServiceTest {
    @Autowired
    private AppRoleService appRolesService;

    @Test
    void getAppRoles() {
        List<AppRoleDto> appRolesList =
                appRolesService.getAppRoles();

        Assertions.assertEquals(3, appRolesList.size());
    }

    @Test
    void getAppRole() {
        AppRoleDto appRoles = appRolesService.getAppRoleById(1);

        Assertions.assertNotNull(appRoles);
    }

    @Test
    void createAppRoles() {

        AppRoleDto appRoles = new AppRoleDto();
        appRoles.setNom(RandomStringUtils.randomAlphabetic(5));

        AppRoleDto appRolesSave = appRolesService.createAppRoles(appRoles);

        Assertions.assertNotNull(appRolesSave);
        appRolesService.deleteAppRoles(appRolesSave.getId());
        //Assertions.assertEquals(appRoles.getNom(), appRolesSave.getNom());
    }

    @Test
    void updateAppRoles() {
        AppRoleDto appRoles = new AppRoleDto();
        appRoles.setNom("ROLE_TECH");

        AppRoleDto appRolesSave = appRolesService.updateAppRoles(5, appRoles);

        Assertions.assertEquals("ROLE_TECH", appRolesSave.getNom());

    }

//    @Test
//    void deleteAppRoles() {
//
//        appRolesService.deleteAppRoles(1);
//        appRolesService.createAdmin();
//        Assertions.assertTrue(true);
//    }


}