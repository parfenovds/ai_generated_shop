package com.example.ai_generated_shop.service;

import com.example.ai_generated_shop.entity.User;
import com.example.ai_generated_shop.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserService userService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testRegisterUser_SuccessfulRegistration() {
    when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());

    userService.registerUser("testUser", "testPassword");

    verify(userRepository, times(1)).findByUsername("testUser");
    verify(userRepository, times(1)).save(any(User.class));
  }

  @Test
  public void testRegisterUser_UsernameExists() {
    when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(new User()));

    userService.registerUser("existingUser", "testPassword");

    verify(userRepository, times(1)).findByUsername("existingUser");
    verify(userRepository, never()).save(any(User.class));
  }

  @Test
  public void testAuthenticateUser_ValidCredentials() {
    User user = new User();
    user.setUsername("testUser");
    user.setPassword("testPassword");
    when(userRepository.findByUsername("testUser")).thenReturn(Optional.of(user));

    boolean isAuthenticated = userService.authenticateUser("testUser", "testPassword");

    assertTrue(isAuthenticated);
  }

  @Test
  public void testAuthenticateUser_InvalidCredentials() {
    when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());

    boolean isAuthenticated = userService.authenticateUser("nonExistingUser", "invalidPassword");

    assertFalse(isAuthenticated);
  }

  @Test
  public void testGetUserByUsername_UserExists() {
    User user = new User();
    user.setUsername("testUser");
    when(userRepository.findByUsername("testUser")).thenReturn(Optional.of(user));

    Optional<User> foundUser = userService.getUserByUsername("testUser");

    assertTrue(foundUser.isPresent());
    assertEquals("testUser", foundUser.get().getUsername());
  }

  @Test
  public void testGetUserByUsername_UserDoesNotExist() {
    when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());

    Optional<User> foundUser = userService.getUserByUsername("nonExistingUser");

    assertFalse(foundUser.isPresent());
  }

  @Test
  public void testFindById_UserExists() {
    User user = new User();
    user.setId(1L);
    when(userRepository.findById(1L)).thenReturn(Optional.of(user));

    User foundUser = userService.findById(1L);

    assertNotNull(foundUser);
    assertEquals(1L, foundUser.getId());
  }

  @Test
  public void testFindById_UserDoesNotExist() {
    when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

    assertThrows(RuntimeException.class, () -> userService.findById(1L));
  }
}
