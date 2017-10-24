package com.tek.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tek.demo.DAO.DaoClass;
import com.tek.demo.basic.Supportclass;


@Service
public class BasicService {
	@Autowired
	DaoClass daoclass;
	private static List<Supportclass> supportclasses;

	public List<Supportclass> findAll() {
		return daoclass.getSupportclass();
		
	}

}
