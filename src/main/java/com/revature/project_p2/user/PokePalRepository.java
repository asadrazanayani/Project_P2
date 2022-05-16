package com.revature.project_p2.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokePalRepository extends JpaRepository<PokePal, Long> {

    @Query(value = "SELECT * from user where user_email = ?1, user_password = ?2", nativeQuery = true)
    public List<PokePal> findUserForLogin(String user_email, String user_password);


}
