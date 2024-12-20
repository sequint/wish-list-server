package com.wish_list.wish_list_server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.wish_list.wish_list_server.model.Wish;
import com.wish_list.wish_list_server.service.WishService;

@RestController
@RequestMapping("/api/wish-list-server")
public class WishController {
  private final WishService service;

  public WishController(WishService service) {
    this.service = service;
  }

  @GetMapping
  public List<Wish> getAllWishes() {
    return service.getAllWishes();
  }

  @GetMapping("/{id}")
  public Wish getOneWish(@PathVariable Long id) throws RuntimeException {
    return service.getOneWish(id);
  }

  @PostMapping
  public Wish reserveWish(@RequestBody Wish wish) {
    return reserveWish(wish);
  }
}
