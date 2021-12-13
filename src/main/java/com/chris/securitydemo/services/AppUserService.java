package com.chris.securitydemo.services;

import com.chris.securitydemo.models.AppUser;
import com.chris.securitydemo.models.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveAppUser(AppUser appUser);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getAppUser(String userName);
    List<AppUser> getAppUsers();

}
