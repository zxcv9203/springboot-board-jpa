package com.devcourse.springjpaboard.application.user.converter;

import com.devcourse.springjpaboard.application.user.controller.dto.CreateUserRequest;
import com.devcourse.springjpaboard.application.user.controller.dto.UserResponse;
import com.devcourse.springjpaboard.application.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

  public User convertUserRequest(CreateUserRequest createUserRequest) {
    User user = new User();
    user.setName(createUserRequest.name());
    user.setAge(createUserRequest.age());
    user.setHobby(createUserRequest.hobby());
    return user;
  }

  public UserResponse convertUserResponse(User user) {
    return new UserResponse(user.getId(), user.getName(), user.getAge(), user.getHobby());
  }
}
