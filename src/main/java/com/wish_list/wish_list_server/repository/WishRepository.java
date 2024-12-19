package com.wish_list.wish_list_server.repository;

import com.wish_list.wish_list_server.model.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<Wish, Long> {}
