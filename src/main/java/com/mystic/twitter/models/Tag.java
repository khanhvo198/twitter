package com.mystic.twitter.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Tag implements Serializable {

    @Id
    private Long id;

    private Long count;

    @ManyToMany(mappedBy = "tags")
    private List<Tweet> tweets;

    @ManyToMany(mappedBy = "tags")
    private List<Comment> comments;


}
