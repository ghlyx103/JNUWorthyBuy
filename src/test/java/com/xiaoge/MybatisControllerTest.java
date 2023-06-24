package com.xiaoge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaoge.controller.MybatisController;
import com.xiaoge.pojo.Comment;
import com.xiaoge.pojo.Good;
import com.xiaoge.pojo.User;
import com.xiaoge.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest
public class MybatisControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private MybatisController mybatisController;

    @BeforeEach
    public void setup() {
        initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(mybatisController).build();
    }

    @Test
    public void testAddProduct() throws Exception {
        Good product = new Good();
        product.setGoods_id(String.valueOf(123));
        product.setName("Product 1");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(product);

        mockMvc.perform(MockMvcRequestBuilders.post("/mybatis/addProduct")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        // Add your assertions here to verify the behavior
    }

    @Test
    public void testReviewProduct() throws Exception {
        Good product = new Good();
        product.setGoods_id("123");
        product.setName("Product 1");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(product);

        mockMvc.perform(MockMvcRequestBuilders.post("/mybatis/reviewProduct")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        // Add your assertions here to verify the behavior
    }

    @Test
    public void testGetProductList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/mybatis/getProductList")
                        .param("list", "1")
                        .param("good_position", "1"))
                .andReturn();

        // Add your assertions here to verify the behavior
    }

    @Test
    public void testSearchProductList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/mybatis/searchProductList")
                        .param("good_name", "Product")
                        .param("type", "time"))
                .andReturn();

        // Add your assertions here to verify the behavior
    }

    @Test
    public void testQueryUserList() throws Exception {
        List<User> userList = new ArrayList<>();
        userList.add(new User());

        when(userService.queryUserList()).thenReturn(userList);

        mockMvc.perform(MockMvcRequestBuilders.get("/mybatis/query"))
                .andReturn();

        // Add your assertions here to verify the behavior
    }

    @Test
    public void testSaveUser() throws Exception {
        User user = new User();
        user.setWx_id(Integer.parseInt("123"));
        user.setName("John Doe");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/mybatis/saveUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        // Add your assertions here to verify the behavior
    }

    @Test
    public void testModifyUser() throws Exception {
        User user = new User();
        user.setWx_id(Integer.parseInt("123"));
        user.setName("John Doe");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/mybatis/modifyUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        // Add your assertions here to verify the behavior
    }

    @Test
    public void testAddComment() throws Exception {
        Comment comment = new Comment();
        comment.setCommentId("123");
        comment.setContent("Great product");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(comment);

        mockMvc.perform(MockMvcRequestBuilders.post("/mybatis/addComment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        // Add your assertions here to verify the behavior
    }

    @Test
    public void testGetCommentList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/mybatis/getCommentList")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andReturn();

        // Add your assertions here to verify the behavior
    }
}

