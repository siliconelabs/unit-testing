package com.minutes.unittesting.unittesting.business;

import java.util.List;

import com.minutes.unittesting.unittesting.data.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.minutes.unittesting.unittesting.model.Item;

@Component
public class ItemBusinessService {
	
	@Autowired
	private ItemRepository repository;
	
	public Item retreiveHardcodedItem() {

		return new Item(1, "Ball", 10, 100);
	}
	
	public List<Item> retrieveAllItems()
	{
		List<Item> items = repository.findAll();
		
		for(Item item:items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		
		return items;	
	}
	
}
