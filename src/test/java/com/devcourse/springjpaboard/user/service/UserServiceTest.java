package com.devcourse.springjpaboard.user.service;

import static com.devcourse.springjpaboard.core.exception.ExceptionMessage.NOT_FOUND_USER;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

import com.devcourse.springjpaboard.application.user.repository.UserRepository;
import com.devcourse.springjpaboard.application.user.service.UserServiceImpl;
import com.devcourse.springjpaboard.core.exception.NotFoundException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Disabled
class UserServiceTest {

  @InjectMocks
  UserServiceImpl userService;

  @Mock
  UserRepository userRepository;

  @Test
  @DisplayName("존재하지 않는 회원 ID로 조회시 예외 발생 테스트")
  void getUserByIdFailTest() throws Exception {
    // given
    Long request = 3L;

    // when
    when(userService.findById(request)).thenThrow(new NotFoundException(NOT_FOUND_USER));

    // then
    assertThatExceptionOfType(NotFoundException.class)
        .isThrownBy(() -> userService.findById(request));
  }
}