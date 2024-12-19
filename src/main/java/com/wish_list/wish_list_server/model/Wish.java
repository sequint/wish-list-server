package com.wish_list.wish_list_server.model;

import jakarta.persistence.*;

@Entity
public class Wish {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String url;
  private String imgUrl;
  private boolean reserved;

  // Only getters in current version since users should not set item values
  public long getId() { return id; }
  public String getName() { return name; }
  public String getUrl() { return url; }
  public String getImgUrl() { return imgUrl; }
  public boolean isReserved() { return reserved; }
}
