package com.jnelsonjava.codefellowship.models.user;

import com.jnelsonjava.codefellowship.models.user.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    public ApplicationUser findByUsername(String username);
}
