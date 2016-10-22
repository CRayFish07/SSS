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
import org.springframework.web.bind.annotation.ResponseBody;

import com.silence.common.ResultPojo;
import com.silence.enties.User;
import com.silence.services.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/*
	 * 获取不同年龄的人数
	 */
	@ResponseBody
	@RequestMapping(value="/getCountByAge",method=RequestMethod.GET)
	public ResultPojo<List<Object[]>> getCountByAge(HttpServletResponse response) throws IOException{
		ResultPojo<List<Object[]>> resultPojo = new ResultPojo<>();
		List<Object[]> data = userService.findByAgeCount();
		resultPojo.setData(data);
		return resultPojo;
	}

	
	/*
	 * 更新用户
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
	@ResponseBody
	@RequestMapping(value="/findUsersByPage",method=RequestMethod.GET)
	public ResultPojo<List<User>> findUsersByPage(@RequestParam("page") Integer page){
		//总共有多少记录
		Long count = userService.count();
		count = (count % 7 == 0 ? count / 7 : count / 7 + 1);
		if (page > count){
			page = count.intValue();
		}
		List<User> users = userService.findPage(page, 7);
		ResultPojo<List<User>> resultPojo = new ResultPojo<>();
		resultPojo.setData(users);
		return resultPojo;
	}
	/*
	 * 删除用户
	 */
	@ResponseBody
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	public ResultPojo<String> deleteUser(@RequestParam("id") Integer id){
		userService.delete(id);
		return new ResultPojo<String>("删除成功");
	}
	
	/*
	 * 保存用户
	 */
	@ResponseBody
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	public ResultPojo<String> saveUser(@ModelAttribute @Valid User user,BindingResult result){
		userService.add(user);
		return new ResultPojo<String>("保存成功");
	}
	/*
	 * 检查电话号码是否存在
	 */
	@ResponseBody
	@RequestMapping(value="/checkExistTelephone",method=RequestMethod.POST)
	public ResultPojo<String> checkTelephone(@RequestParam("telephone") String telephone){
		User user = new User(telephone);
		ResultPojo<String> resultPojo = new ResultPojo<>();
		if (userService.exist(user) == null){
			resultPojo.setData("存在");
		}else{
			resultPojo.setData("不存在");			
		}
		return resultPojo;
	}
}