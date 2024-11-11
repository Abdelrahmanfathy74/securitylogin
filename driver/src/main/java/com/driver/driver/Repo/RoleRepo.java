package com.driver.driver.Repo;

import com.driver.driver.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
@Query("select r from Role r where r.name= :name")
    Optional<Set<Role>> findByName(@Param("name") String name);
}
