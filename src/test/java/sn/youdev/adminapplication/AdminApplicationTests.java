package sn.youdev.adminapplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import sn.youdev.adminapplication.entities.Produit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class AdminApplicationTests {

    @Test
    void contextLoads() {
        Produit produit = new Produit();
        assertNotNull(produit);
        assertNull(produit.getId());
    }

}
