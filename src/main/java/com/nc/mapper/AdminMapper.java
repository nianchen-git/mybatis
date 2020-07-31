package com.nc.mapper;

import com.nc.model.Admin;
import com.nc.model.Role;

public interface AdminMapper {
    Admin getAdminById(Integer id);
    Admin getAdminByIdToLazy(Integer id);
    Role getRoleByAid(Integer id);
}
