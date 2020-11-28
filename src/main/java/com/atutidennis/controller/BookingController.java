package com.atutidennis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.atutidennis.model.Booking;

@Controller
public class BookingController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/bookingPage")
	public String showForm(Model model) {
		model.addAttribute("booking",new Booking());
	    return "bookingPage";
	}

}
