package com.devcourse.springjpaboard.post.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import com.devcourse.springjpaboard.application.post.controller.dto.CreatePostRequest;
import com.devcourse.springjpaboard.application.post.converter.PostConverter;
import com.devcourse.springjpaboard.application.post.model.Post;
import com.devcourse.springjpaboard.application.post.repository.PostRepository;
import com.devcourse.springjpaboard.application.post.service.PostServiceImpl;
import com.devcourse.springjpaboard.application.post.service.dto.PostResponse;
import com.devcourse.springjpaboard.application.user.model.User;
import com.devcourse.springjpaboard.application.user.repository.UserRepository;
import com.devcourse.springjpaboard.post.controller.stub.PostStubs;
import com.devcourse.springjpaboard.user.controller.stub.UserStubs;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@ExtendWith(MockitoExtension.class)
@Disabled
class PostServiceTest {

  private final ObjectMapper mapper = new ObjectMapper();

  private MockMvc mockMvc;

  @Mock
  private PostRepository postRepository;

  @Mock
  private UserRepository userRepository;

  @Mock
  private PostConverter postConverter;

  @InjectMocks
  private PostServiceImpl postService;

  @BeforeEach
  void init() {
    mockMvc = MockMvcBuilders.standaloneSetup(postService).build();
  }

  @Test
  @DisplayName("게시글 저장 테스트")
  void saveTest() {
    // given
    CreatePostRequest request = PostStubs.createPostRequest();
    User responseUser = UserStubs.findUser(request.userId());
    Post responsePost = PostStubs.post(responseUser);
    PostResponse response = PostStubs.createPostResponse();

    // when
    doReturn(responseUser)
        .when(userRepository)
        .findById(any(Long.class));
    doReturn(responsePost)
        .when(postConverter)
        .convertPostRequest(any(CreatePostRequest.class), any(User.class));
    // then
  }

  @Test
  @DisplayName("게시글 번호로 게시글을 찾을 수 있는지 테스트")
  void findOneTest() {
    // given

    // when

    // then
  }

  @Test
  @DisplayName("지정한 페이지만큼 게시글을 찾는지 테스트")
  void findAllTest() {
    // given

    // when

    // then
  }

  @Test
  @DisplayName("게시글 업데이트가 정상적으로 되는지 테스트")
  void updateTest() {
    // given

    // when

    // then
  }
}