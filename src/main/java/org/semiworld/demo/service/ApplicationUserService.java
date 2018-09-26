package org.semiworld.demo.service;

import org.semiworld.demo.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserService extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
