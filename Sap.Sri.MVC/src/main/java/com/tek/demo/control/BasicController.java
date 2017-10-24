package com.tek.demo.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tek.demo.DAO.DaoClass;
import com.tek.demo.basic.Supportclass;
import com.tek.demo.service.BasicService;

@RestController
public class BasicController {
	@Autowired
	BasicService basicservice;
	@Autowired
	DaoClass daoclass;
	
	@RequestMapping(value = "/basic", method = RequestMethod.GET)
	public ResponseEntity<List<Supportclass>> listAll() {
		List<Supportclass> supportclasses = basicservice.findAll();
		return new ResponseEntity<List<Supportclass>>(supportclasses, HttpStatus.OK);
	}
}

	


