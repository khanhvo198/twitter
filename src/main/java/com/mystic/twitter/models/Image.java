package com.mystic.twitter.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Getter
@Setter
public class Image implements Serializable {
    @Id
    private Long id;

    private String src;
    @ManyToOne
    @JoinColumn(name = "tweet_id")
    private Tweet tweet;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

}
