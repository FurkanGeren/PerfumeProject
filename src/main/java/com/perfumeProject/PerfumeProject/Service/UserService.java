package com.perfumeProject.PerfumeProject.Service;


import com.perfumeProject.PerfumeProject.Model.Role;
import com.perfumeProject.PerfumeProject.Model.User;
import com.perfumeProject.PerfumeProject.Repository.RoleRepository;
import com.perfumeProject.PerfumeProject.Repository.UserRepository;
import com.perfumeProject.PerfumeProject.user.WebUser;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;



    @Autowired
    private PasswordEncoder passwordEncoder;
    private Logger logger;

    @Override
    public List<User> getUser(){return userRepository.findAll();}

    @Override
    public User addUser(User user){return userRepository.save(user);}




    @Override
    public User findByEmail(String email){return userRepository.findByEmail(email);}

    @Override
    public void save(WebUser webUser) {
        User user = new User();

        // assign user details to the user object
        user.setUserName(webUser.getFirstName());
        user.setUserPassword(passwordEncoder.encode(webUser.getPassword()));
        user.setEmail(webUser.getEmail());
        user.setUserSurname(webUser.getLastName());

        user.setRoles(Arrays.asList(roleRepository.findByRoleName("ROLE_USER")));

        userRepository.save(user);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        Collection<SimpleGrantedAuthority> authorities = mapRolesToAuthorities(user.getRoles());

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(),
                authorities);
    }

    private Collection<SimpleGrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role tempRole : roles) {
            SimpleGrantedAuthority tempAuthority = new SimpleGrantedAuthority(tempRole.getRoleName());
            authorities.add(tempAuthority);
        }

        return authorities;
    }
}
