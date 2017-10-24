package com.tek.demo.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tek.demo.pojo.Items_pojo;
import com.tek.demo.service.ItemService;


@RestController
public class ItemController {
	@Autowired
	ItemService itemservice;
	// Display list

		@RequestMapping(value = "/item", method = RequestMethod.GET)
		public ResponseEntity<List<Items_pojo>> listAllProducts() {
			List<Items_pojo> itemss = itemservice.findAllitems();
			if (itemss.isEmpty()) {

				return new ResponseEntity<List<Items_pojo>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Items_pojo>>(itemss, HttpStatus.OK);
		}

}
