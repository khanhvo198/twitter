package com.mystic.twitter.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

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
