package com.yebelo.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yebelo.repository.CategoryRepo;
import com.yebelo.service.Service;
import com.yebelo.table.CategoryTable;

@Controller
public class AdminController {
	
	@Autowired
	CategoryRepo repo;
	
	Service service=new Service();
	
	@GetMapping("/")
	public String get(ModelMap model) {
		
		return "searchpage";
	}
	
	@PostMapping("/showtable")
	public String show(ModelMap model, @ModelAttribute("categoryTable") CategoryTable table,HttpSession session) {
		
		String code = table.getCategoryCode();
		System.out.println(table.getCategoryCode());
		session.setAttribute("category_code",table.getCategoryCode());
		if(repo.existsById(code)) {
			Optional<CategoryTable> tabledata = repo.findById(code);
			String value = tabledata.get().getValue();
			System.out.println(value);
			return "showtable";
		}
		else {
			model.put("errorMSG", "value dont't exits");
			return "searchpage";
		}
		
	}
	
	@GetMapping("/update")
	public String update(ModelMap model, @ModelAttribute("categoryTable") CategoryTable table,HttpSession session) {
		
		String code = table.getCategoryCode();
		System.out.println(table.getCategoryCode());
		System.out.println(session.getAttribute("category_code"));
		if(code==null) {
			code = ""+session.getAttribute("category_code");
		}
		session.setAttribute("category_code",table.getCategoryCode());
		if(repo.existsById(code)) {
			Optional<CategoryTable> tabledata = repo.findById(code);
			String value = tabledata.get().getValue();
			String newValue = ""+service.nextNum(Integer.valueOf(value));
			repo.updateValue(code, newValue);
			System.out.println(newValue);
		}
		model.addAttribute("user","s");
		return "updated";
	}
}
	













