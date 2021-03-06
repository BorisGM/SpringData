package com.example.examprep.repository;

import com.example.examprep.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

     boolean existsByUsername(String username);

     Optional<User> findByUsername(String username);

     @Query("SELECT u from User u order by size(u.orders)  DESC ")
     List<User> findAllByOrderCountDescending();
}
