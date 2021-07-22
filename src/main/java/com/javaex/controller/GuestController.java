package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestController {

	
			//필드
			//생성자	
			//메소드 gs
			//메소드 일반
		
	//리스트
	@RequestMapping(value="/list",method= {RequestMethod.GET,RequestMethod.POST})
	public String list(Model model) {
		
		//Dao 사용
		GuestbookDao guestbookDao = new GuestbookDao();
		
		//Dao 메소드 사용
		
		 List<GuestbookVo> guestList = guestbookDao.getList();
		//model 담기 (택배박스에 담기) --> ds 전달된다 --> request의 attribute 영역에 넣는다.!!
		
		 model.addAttribute( "guestList" , guestList);
		return "/WEB-INF/views/addList.jsp";
		
	}
	
	@RequestMapping(value="/insert",method= {RequestMethod.GET,RequestMethod.POST})
	public String insert(@ModelAttribute GuestbookVo guestbookVo) {
		
		
		System.out.println("insert들어옴");
		
		System.out.println(guestbookVo);
		
		GuestbookDao guestbookDao = new GuestbookDao();
		guestbookDao.Insert(guestbookVo);
		
		
		return "redirect:/list";
		
	}
	
	@RequestMapping(value="/deleteForm",method= {RequestMethod.GET,RequestMethod.POST})
	public String deleteForm() {
		System.out.println("deleteForm접속");
		
		return "/WEB-INF/views/deleteForm.jsp";
		
	}
	
	@RequestMapping(value="delete",method= {RequestMethod.GET,RequestMethod.POST})
	public String delete(@ModelAttribute GuestbookVo guestVo) {
		System.out.println("delete들어옴");
		
		//(@RequestParam("no") int id, @RequestParam("password") String password)
		//GuestbookVo guestVo = new GuestbookVo(id, password);
		
		System.out.println(guestVo);
		
		//@ModelAttribute GuestbookVo guestVo
		GuestbookDao guestDao = new GuestbookDao();
		guestDao.delete(guestVo);
		
		return "redirect:/list";
	
	}
}
