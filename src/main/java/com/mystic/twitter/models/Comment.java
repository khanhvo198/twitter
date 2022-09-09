package com.mystic.twitter.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment implements Serializable {
  @Id
  private Long id;

  private String text;

  @OneToMany(mappedBy = "comment")
  private List<Image> images;

  @ManyToMany
  @JoinTable(name = "comment_tags", joinColumns = @JoinColumn(name = "comment_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
  private List<Tag> tags;

  @ManyToOne
  @JoinColumn(name = "tweet_id")
  private Tweet tweet;

  private Date created_at;

  private Date updated_at;
}
