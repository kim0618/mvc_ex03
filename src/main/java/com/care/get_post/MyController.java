package com.care.get_post;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	public MyController() {
		System.out.println("MyController 생성자 실행");
	}
	
	@RequestMapping(value="my/index", method = RequestMethod.GET)
	public String index() {
		return "/get_post/index";
	}
	
	@GetMapping("my/result")		// get 방식 @GetMapping(), @PostMapping() 사용 가능
	public String result_get(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("get방식으로 들어왔습니다");
		System.out.println("name : "+name);
		System.out.println("age : "+age);
		
		model.addAttribute("mothod", request.getMethod());
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "/get_post/result";
	}
	
	@RequestMapping(value="my/result", method = RequestMethod.POST)	// post 방식
	public String result_post(HttpServletRequest request, Model model,
								@RequestParam("name") String name, 
								@RequestParam("age") String age) {
		System.out.println("post방식으로 들어왔습니다");
		
		model.addAttribute("method", request.getMethod());
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "/get_post/result";
	}
	
	
}
