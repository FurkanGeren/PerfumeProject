package com.perfumeProject.PerfumeProject.Service;

import com.perfumeProject.PerfumeProject.Exception.EmailExistsException;
import com.perfumeProject.PerfumeProject.Model.User;
import com.perfumeProject.PerfumeProject.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<User> getUser();

    User addUser(User user);

    User findByEmail(String email);

    void save(WebUser webUser);
}
