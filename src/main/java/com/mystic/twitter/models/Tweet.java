package com.mystic.twitter.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
public class Tweet implements Serializable {

    @Id
    private Long id;

    private String text;

    @OneToMany(mappedBy = "tweet")
    private List<Image> images;

    @OneToMany(mappedBy = "tweet")
    private List<Comment> comments;

    private Date created_at;

    private Date updated_at;

    @ManyToMany
    @JoinTable(name = "tweet_tags",
            joinColumns = @JoinColumn(name = "tweet_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

}
