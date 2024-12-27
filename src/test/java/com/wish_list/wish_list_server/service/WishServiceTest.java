package com.wish_list.wish_list_server.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wish_list.wish_list_server.model.Wish;
import com.wish_list.wish_list_server.repository.WishRepository;

public class WishServiceTest {
  @Mock
  private WishRepository wishRepository;

  @InjectMocks
  private WishService wishService;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testGetAllWishes() {
    // Arrange mock data
    Wish wish1 = new Wish("Cool Book", "coolbook.com", "coolbookimg.png");
    Wish wish2 = new Wish("Car", "dreamcar.com", "carimg.png");
    when(wishRepository.findAll()).thenReturn(Arrays.asList(wish1, wish2));

    // Act
    var wishes = wishService.getAllWishes();

    // Assert
    assertEquals(2, wishes.size());
    assertEquals("Cool Book", wishes.get(0).getName());
    assertEquals(false, wishes.get(0).getReserved());
    verify(wishRepository, times(1)).findAll();
  }
}
