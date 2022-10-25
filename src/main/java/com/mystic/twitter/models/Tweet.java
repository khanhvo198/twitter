package com.mystic.twitter.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tweet implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tweets_seq")
  @SequenceGenerator(name = "tweets_seq", sequenceName = "tweets_seq", initialValue = 100, allocationSize = 1)
  @Column(updatable = false, nullable = false)
  private Long id;

  private String text;

  @OneToMany(mappedBy = "tweet")
  private List<Image> images;

  @OneToMany(mappedBy = "tweet")
  private List<Comment> comments;

  private LocalDateTime created_at;

  private LocalDateTime updated_at;

  @ManyToMany
  @JoinTable(name = "tweet_tags", joinColumns = @JoinColumn(name = "tweet_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
  private List<Tag> tags;

}
