package com.silence.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	private JpaRepository<T, Integer> dao;
	
	public void add(T t) {
		dao.save(t);
	}

	public T find(Integer id) {
		return dao.findOne(id);
	}

	public T find(T t) {
		return null;
	}

	public List<T> find() {
		return dao.findAll();
	}

	public void delete(T t) {
		dao.delete(t);
	}

	public void delete(Integer id) {
		dao.delete(id);
	}

	public void update(T t) {
		
	}

	public Long count() {
		return dao.count();
	}

	/**
	 * 分页代码，默认一页为16条数据
	 * @see com.silence.services.BaseService#findPage(int, int)
	 */
	public List<T> findPage(int page, int pageSize) {
		if (page < 1){
			page = 1;
		}
		if (pageSize < 1){
			pageSize = 16;
		}
		Pageable pageable = new PageRequest(page - 1, pageSize);
		return dao.findAll(pageable).getContent();
	}

	public List<T> find(String[] Param) {
		return null;
	}

	public List<T> get(Integer id) {
		return null;
	}

	public List<Object[]> get() {
		return null;
	}

	public List<Object[]> get(T t) {
		return null;
	}

	public T exist(T t) {
		return null;
	}

	public T search() {
		return null;
	}

	public void update(Integer id) {
		
	}
}