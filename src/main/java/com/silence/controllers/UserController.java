package com.silence.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.silence.enties.User;
import com.silence.services.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	private static Gson gson = new Gson();

	/*
	 * 获取不同年龄的人数
	 */
	@RequestMapping(value="/getCountByAge",method=RequestMethod.GET)
	public void getCountByAge(HttpServletResponse response) throws IOException{
		List<Object[]> data = userService.findByAgeCount();
		System.out.println(gson.toJson(data));
		response.getWriter().print(gson.toJson(data));
	}

	
	/*
	 * 更新病人
	 */
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	public void updateUser(@RequestParam("id") Integer id,@RequestParam("name") String name,
			@RequestParam("birthday") Date birthday,@RequestParam("telephone") String telephone,
			@RequestParam("insuranceCompany") String insuranceCompany,
			@RequestParam("polictNumber") String polictNumber,PrintWriter writer){
		User user = new User(id, name, telephone, birthday);
		userService.update(user);
	}
	/*
	 * 分页查询
	 */
	@RequestMapping(value="/findUsersByPage",method=RequestMethod.GET)
	public String findUsersByPage(@RequestParam("page") Integer page,
			Map<String,Object> map){
		//总共有多少记录
		Long count = userService.count();
		count = (count % 7 == 0 ? count / 7 : count / 7 + 1);
		if (page > count){
			page = count.intValue();
		}
		List<User> users = userService.findPage(page, 7);
		map.put("users", users);
		map.put("count", count);
		map.put("page", page);
		return "showusers";
	}
	/*
	 * 删除用户
	 */
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	public void deleteUser(@RequestParam("id") Integer id,PrintWriter writer){
		userService.delete(id);
		writer.print(1);
	}
	
	/*
	 * 保存用户
	 */
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute @Valid User user,BindingResult result){
		userService.add(user);
		return "redirect:findUsersByPage?page=1";
	}
	/*
	 * 查找所有的用户
	 */
	@RequestMapping(value = "/findUsers", method = RequestMethod.GET)
	public String findUser(Map<String,Object> map) {
		List<User> users = userService.find();
		map.put("users", users);
		return "users";
	}
	
	/*
	 * 检查电话号码是否存在
	 */
	@RequestMapping(value="/checkExistTelephone",method=RequestMethod.POST)
	public void checkTelephone(@RequestParam("telephone") String telephone,
			PrintWriter writer){
		User user = new User(telephone);
		if (userService.exist(user) == null){
			writer.print(1);
			return;
		}
	}
}