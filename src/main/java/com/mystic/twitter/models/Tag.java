package com.mystic.twitter.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

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
