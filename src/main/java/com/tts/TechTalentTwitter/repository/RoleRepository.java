package com.tts.TechTalentTwitter.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.tts.TechTalentTwitter.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>
{
    Role findByRole(String role);
}