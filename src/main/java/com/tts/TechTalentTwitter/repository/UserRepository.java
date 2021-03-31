package com.tts.TechTalentTwitter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.TechTalentTwitter.model.user; 

@Repository
public interface UserRepository extends CrudRepository<user, Long>
{
    user findByUsername(String username);
}
