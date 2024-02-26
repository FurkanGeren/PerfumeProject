package com.perfumeProject.PerfumeProject.Service;


import com.perfumeProject.PerfumeProject.Model.User;
import com.perfumeProject.PerfumeProject.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {


    private final UserRepository userRepository;

    @Override
    public List<User> getUser(){return userRepository.findAll();}

    @Override
    public User addUser(User user){return userRepository.save(user);}
}
