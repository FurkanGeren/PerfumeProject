package com.perfumeProject.PerfumeProject.Service;

import com.perfumeProject.PerfumeProject.Model.Role;

public interface IRoleService {
    Role findByRoleName(String roleName);
}
