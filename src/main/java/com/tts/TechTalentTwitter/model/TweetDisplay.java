package com.tts.TechTalentTwitter.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//No entity tag -- we are not storing TweetDisplay in database!
public class TweetDisplay
{
    private user user;
    private String message;
    private String date;
    private List<Tag> tags;

}
