package com.tek.com.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tek.com.demo.model.Items;
import com.tek.com.demo.model.finalorder;
import com.tek.com.demo.repository.LinkedClass;

@Component
public class ServicesOfShop {
	@Autowired
	LinkedClass c;

	List<Items> itemslist = new ArrayList<Items>(Arrays.asList(new Items("1", "Intel", 650, "Specs: HDD=1 TB,RAM-4gb"),
			new Items("2", "Dell", 750, "Specs: HDD=1 TB,RAM-6gb"),
			new Items("3", "Apple", 850, "Specs: SDD=256 GB ,RAM-5gb"),
			new Items("4", "Sony", 950, "Specs: SDD=256 GB ,RAM-3gb"),
			new Items("5", "Hp", 1050, "Specs: HDD=1 TB,RAM-4gb")));

	public List<Items> getItems() {
		return itemslist;
	}

	public void save(finalorder r) {
	
		c.save(r);
	}

	public Items getitem(String id) {
		Items it = null;
		Items returnItem = null;
		Optional<Items> optional = itemslist.stream().filter(t -> t.getItemNo().equals(id)).findFirst();

		if (optional.isPresent()) {
			it = optional.get();
		}
		return it;
	}
}
