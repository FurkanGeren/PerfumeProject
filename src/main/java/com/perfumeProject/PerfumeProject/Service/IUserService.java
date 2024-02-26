package com.perfumeProject.PerfumeProject.Service;

import com.perfumeProject.PerfumeProject.Model.User;

import java.util.List;

public interface IUserService {
    List<User> getUser();

    User addUser(User user);
}
