package com.perfumeProject.PerfumeProject.Service;

import com.perfumeProject.PerfumeProject.Model.Role;
import com.perfumeProject.PerfumeProject.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByRoleName(String roleName){
        return roleRepository.findByRoleName(roleName);
    }
}
