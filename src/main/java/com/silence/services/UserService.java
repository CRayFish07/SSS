package com.silence.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silence.enties.User;
import com.silence.repositories.UserRepository;

@Service
public class UserService extends BaseServiceImpl<User>{

	@Autowired
	private UserRepository userDao;

	@Override
	public void update(User user) {
		userDao.update(user.getName(), user.getBirthday(),user.getTelephone(),user.getId());
	}
	
	public List<Object[]> findByAgeCount(){
		return userDao.findByAgeCount();
	}
	
	@Override
	public User exist(User t) {
		return userDao.exist(t.getTelephone());
	}
}