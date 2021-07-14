package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.model.Emp;
import com.example.demo.model.Hospital;
import com.example.demo.repository.EmpRepository;
import com.example.demo.repository.HospitalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

//	@GetMapping("/home")
//	public String home(@RequestParam Map<String, Object> map, Model model) {
//		model.addAttribute("jeju", map.get("area"));
//		logger.error("lskdfjlsjdlfkj");
//		return "home";
//	}


	@Autowired
	HospitalRepository	hospitalRepository;

	@GetMapping("/home")
	public String home(@RequestParam (value = "area", defaultValue = "") String area, Model model) {
		model.addAttribute("jeju", area);
		return "home";
	}

	@GetMapping("/hospital")
	public String hospitals(Model model){
		model.addAttribute("hospitalList", hospitalRepository.findAll());
		return "hospital";
	}
	
	@GetMapping("/json")
	@ResponseBody
	public Map<String, Object> jsonMap(@RequestParam (value = "area", defaultValue = "") String area){
		Map<String, Object> areaMap = new HashMap<String, Object>();
			areaMap.put("area", area);
		return areaMap;
	}
}
