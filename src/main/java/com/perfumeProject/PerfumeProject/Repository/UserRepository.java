package com.perfumeProject.PerfumeProject.Repository;


import com.perfumeProject.PerfumeProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
