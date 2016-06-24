package com.hackathon.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.hackathon.configuration.MongoDBConfiguration;
import com.hackathon.model.Category;
import com.hackathon.model.Currency;
import com.hackathon.model.Kid;
import com.hackathon.model.Parent;
import com.hackathon.model.Task;

@Service
public class ParentService {

	@Autowired
	private MongoDBConfiguration mongoDbConfig;
	@Autowired
	private CurrencyService currencyService;

	public void insertParent() throws UnknownHostException {
		Currency currency = currencyService.getCurrencyByName("EUR");
		List<Kid> children = new ArrayList<Kid>();
		Kid kid = new Kid("Alex", 15);
		Kid kid2 = new Kid("Raluca", 13);

		children.add(kid);
		children.add(kid2);

		List<String> owners = new ArrayList<String>();
		owners.add(kid.getName());

		List<Task> tasks = new ArrayList<Task>();
		Task task = new Task("Pick up toys", "", 1, 1, "TODO", owners);
		tasks.add(task);

		mongoDbConfig.getMongoTemplate().insert(
				new Parent(currency, "popescui", children, 1520, new Category("Chore", "Chores for kids", tasks)));
	}

	public Parent getParent() throws UnknownHostException {
		return mongoDbConfig.getMongoTemplate().findOne(new Query(where("category.tasks.owners").is("Alex")), Parent.class);
	}
	// db.getCollection("restaurants").find(or(eq("cuisine", "Italian"),
	// eq("address.zipcode", "10075")));
}