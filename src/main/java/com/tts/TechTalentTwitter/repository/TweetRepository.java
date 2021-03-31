package com.tts.TechTalentTwitter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.TechTalentTwitter.model.Tweet;
import com.tts.TechTalentTwitter.model.user;

@Repository
public interface TweetRepository extends CrudRepository<Tweet, Long>
{
    List<Tweet> findAllByOrderByCreatedAtDesc();
    List<Tweet> findAllByUserOrderByCreatedAtDesc(user user);
    List<Tweet> findAllByUserInOrderByCreatedAtDesc(List<user> users);
    List<Tweet> findByTags_PhraseOrderByCreatedAtDesc(String phrase);

}
