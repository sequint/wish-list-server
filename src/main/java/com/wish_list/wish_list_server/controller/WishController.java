package com.wish_list.wish_list_server.controller;

import com.wish_list.wish_list_server.model.Wish;
import com.wish_list.wish_list_server.repository.WishRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wish-list-server")
public class WishController {
  private final WishRepository repository;

  public WishController(WishRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Wish> getAllWishes() {
    return this.repository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Wish> getOneWish(@PathVariable Long id) {
    return this.repository.findById(id);
  }

  @PostMapping
  public Wish reserveWish(@RequestBody Wish wish) {
    wish.reserve();
    return this.repository.save(wish);
  }
}
