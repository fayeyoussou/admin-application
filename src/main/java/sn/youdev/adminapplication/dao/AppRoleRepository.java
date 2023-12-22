package sn.youdev.adminapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import sn.youdev.adminapplication.entities.AppRole;

import java.util.Optional;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Integer>, JpaSpecificationExecutor<AppRole> {
    Optional<AppRole> findAppRoleByNom(String nom);
}