package com.tts.TechTalentTwitter.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tts.TechTalentTwitter.repository.RoleRepository;
import com.tts.TechTalentTwitter.repository.UserRepository;
import com.tts.TechTalentTwitter.model.Role;
import com.tts.TechTalentTwitter.model.user; 

@Service
public class UserService
{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private UserService(UserRepository userRepository,
                        RoleRepository roleRepository,
                        BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    public user findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
        
    public List<user> findAll(){
        return (List<user>) userRepository.findAll();
    }
        
    public void save(user user) {
        userRepository.save(user);
    }
    
    public user saveNewUser(user user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }
    public user getLoggedInUser() {
        String loggedInUsername = SecurityContextHolder.
          getContext().getAuthentication().getName();
        
        return findByUsername(loggedInUsername);
    }
}
