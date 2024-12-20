package com.wish_list.wish_list_server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wish_list.wish_list_server.model.Wish;
import com.wish_list.wish_list_server.repository.WishRepository;

@Service
public class WishService {
  private final WishRepository repository;

  public WishService(WishRepository repository) {
    this.repository = repository;
  }

  public List<Wish> getAllWishes() {
    return repository.findAll();
  }

  public Wish getOneWish(Long id) throws RuntimeException {
    Optional<Wish> wish = repository.findById(id);

    if (wish.isPresent()) {
      return wish.get();
    }
    else {
      throw new RuntimeException("Could not find the wish you are looking for.");
    }
  }

  public Wish reserveWish(Long id) {
    Wish wish = getOneWish(id);

    wish.reserve();

    return repository.save(wish);
  }
}
