package com.CarRentalUser.Repository;


import com.CarRentalUser.UserEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findByEmail(String name);
    //User findByPassword(String password);
}
