package com.tek.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tek.demo.dao.ItemDao;
import com.tek.demo.pojo.Items_pojo;

@Service

public class ItemService {
	@Autowired
	ItemDao itemdao;
	//private static List<Items_pojo> items;

	public List<Items_pojo> findAllitems() {
		return itemdao.getitems();
	}

}
