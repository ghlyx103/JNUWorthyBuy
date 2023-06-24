package com.xiaoge.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaoge.SpringbootMybatisApplication;
import com.xiaoge.pojo.Comment;
import com.xiaoge.pojo.Good;
import com.xiaoge.pojo.User;
import com.xiaoge.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



@RequestMapping("/mybatis")
@RestController
public class MybatisController {

	private final static Logger LOGGER = LoggerFactory.getLogger(SpringbootMybatisApplication.class);
	@Autowired
	private UserService userService;
	//关于商品部分
	
	//添加商品
	@RequestMapping(path = "/addProduct")
	private static void addProduct(@RequestBody String string) throws IOException{
		System.out.println(string);
		ObjectMapper mapper = new ObjectMapper();  
		Good product = new Good();
		try {
			product = mapper.readValue(string, Good.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		//1、添加商品至数据库
		product.setGoods_id(java.util.UUID.randomUUID().toString().replaceAll("-", ""));
		
		System.out.println(product.toString()); 
		LOGGER.info("addProduct succeed!");
    }
	
	//审核商品
	@RequestMapping(path = "/reviewProduct")
	private static void reviewProduct(@RequestBody String string) throws IOException{
		System.out.println(string);
		ObjectMapper mapper = new ObjectMapper();  
		Good product = new Good();
		try {
			product = mapper.readValue(string, Good.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		//2、保存修改后的商品数据
		
		System.out.println(product.toString()); 
		LOGGER.info("reviewProduct succeed!");
	}
	
	//获取商品列表
	@RequestMapping("/getProductList")
	@ResponseBody
	private static List<Good> getProducts(@RequestParam("list")int list,
			@RequestParam("good_position")int good_position) throws ParseException{
		List<Good> products = new ArrayList<Good>();//存储从数据库获取的数据列表
		
		if(list == 1) {
			//3、获取首页商品列表
			
			if(good_position != 0 && good_position < products.size())
			{
				List<Good> products_index = new ArrayList<Good>();
				products_index.add(products.get(good_position-1));
				LOGGER.info("getProductList index succeed!");
				return products_index;
			}
			System.out.println(products.size());
			LOGGER.info("getProductList1 succeed!");
		}
		else if(list == 2)
		{
			//4、读取精选商品表的商品列表
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			
			if(good_position != 0 && good_position < products.size())
			{
				List<Good> products_index = new ArrayList<Good>();
				products_index.add(products.get(good_position-1));
				LOGGER.info("getProductList index succeed!");
				return products_index;
			}
			
			LOGGER.info("getProductList精选 succeed!");
		}
		else if(list == 3)
		{
			//5、获取商品表未审核商品数据
			
			if(good_position != 0 && good_position < products.size())
			{
				List<Good> products_index = new ArrayList<Good>();
				products_index.add(products.get(good_position-1));
				LOGGER.info("getProductList index succeed!");
				return products_index;
			}
			System.out.println(products.size());
			LOGGER.info("getProductList3 succeed!");
		}
		else if(list == 4)
		{
			//6、获取商品表中价格降低的数据
			if(good_position != 0 && good_position < products.size())
			{
				List<Good> products_index = new ArrayList<Good>();
				products_index.add(products.get(good_position-1));
				LOGGER.info("getProductList index succeed!");
				return products_index;
			}
			
			LOGGER.info("getProductList4 succeed!");
		}
		else if(list > 4 && list < 0)
		{
			LOGGER.info("getProductList failed! not list like");
			System.out.println(list);
		}
		
		
		return products;
    }
	
	//搜索商品
	@RequestMapping("/searchProductList")
	@ResponseBody
	private static List<Good> searchProducts(@RequestParam("good_name")String good_name,
			@RequestParam("type")String type) throws ParseException{
		//search product data by good_name
		List<Good> products = new ArrayList<Good>();//存储从数据库获取的数据列表
		//7、按名字good_name在商品表里搜索商品数据列表
		
		//sort by type
		Good product = new Good();
		if(type.equals("time")) {
			products = product.sortTime(products);
			LOGGER.info("searchProductList time succeed!");
			return products;
		}
		else {
			System.out.println(type);
			products = product.sortPrice(products);
			LOGGER.info("searchProductList price succeed!");
			return products;
		}
	}
	
	
	//关于用户部分

	@GetMapping("/query")
	public List<User> queryUserList() {
		List<User> users = userService.queryUserList();
		return users;
	}

	//保存用户
	@RequestMapping("/saveUser")
	public String saveUser(@RequestBody String string) throws IOException {
		ObjectMapper mapper = new ObjectMapper();  
		User user = new User();
		try {
			user = mapper.readValue(string, User.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		userService.saveUser(user);
		return "saved";
	}
	
	//修改用户权限
	@RequestMapping(path = "/modifyUser")
	private static void modifyUser(@RequestBody String string) throws IOException{
		System.out.println(string);
		ObjectMapper mapper = new ObjectMapper();  
		User user = new User();
		try {
			user = mapper.readValue(string, User.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		//8、通过user的wx_id获取用户表的用户，对比权限是否修改
		User user0 = new User();
		if(user0.getWx_id() == user.getWx_id())
		{
			if(user0.isUesr_publish() != user.isUesr_publish())
				user0.setUesr_publish(user.isUesr_publish());
			if(user0.isUesr_comment() != user.isUesr_comment())
				user0.setUesr_comment(user.isUesr_comment());
		}
		System.out.println(user0.toString()); 
		LOGGER.info("modifyUser succeed!");
    }
	
	//关于评论部分
	
	@RequestMapping(path = "/addComment")
	private static void addComment(@RequestBody String string) throws IOException{
		System.out.println(string);
		ObjectMapper mapper = new ObjectMapper();  
		Comment comment = new Comment();
		try {
			comment = mapper.readValue(string, Comment.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		//9、添加评价进评价表（以下两行可删除）
		List<Comment> comments = new ArrayList<Comment>();
		comments.add(comment);
		
		System.out.println(comment.toString()); 
		LOGGER.info("addComment succeed!");
    }
	
	@RequestMapping("/getCommentList")
	@ResponseBody
	private static List<Comment> getComments(@RequestBody String string) throws ParseException{
		List<Comment> comments = new ArrayList<Comment>();
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		//10、获取评论
		
		LOGGER.info("getCommentList succeed!");
		return comments;
	}
	
	
}

