package com.appdevlopers.api.users.photoappapiusers.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

}
