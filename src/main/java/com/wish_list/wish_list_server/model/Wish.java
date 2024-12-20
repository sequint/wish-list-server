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

  public long getId() { return id; }
  public String getName() { return name; }
  public String getUrl() { return url; }
  public String getImgUrl() { return imgUrl; }
  public boolean getReserved() { return reserved; }

  public void setReserved(boolean reserved) { this.reserved = reserved; }
}
