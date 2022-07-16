package com.mystic.twitter.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    @ManyToMany
    @JoinTable(name = "tweet_tags",
            joinColumns = @JoinColumn(name = "tweet_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

}
