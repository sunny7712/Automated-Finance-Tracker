package org.fta.repositories;

import org.fta.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<User, String> {
}
