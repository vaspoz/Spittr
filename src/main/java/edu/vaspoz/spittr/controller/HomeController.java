package edu.vaspoz.spittr.controller;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	private MongoClient mongoClient;

	@RequestMapping(value="/")
	public String home(){
		return "home";
	}
}
