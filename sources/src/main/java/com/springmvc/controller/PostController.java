package com.springmvc.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bean.*;
import util.*;

@Controller
public class PostController {

	@RequestMapping(value = "/loadmain", method = RequestMethod.GET)
	public String loadmainPage() {
		return "addmain";
	}
	@RequestMapping(value = "/loadpost", method = RequestMethod.GET)
	public String loadaddpostPage() {
		return "post";
	}
	@RequestMapping(value = "/losdposts", method = RequestMethod.POST)
	public ModelAndView do_post(HttpServletRequest request, HttpSession session) {
		int erorr = 0;
		ModelAndView mav = new ModelAndView("index");
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				String profile_pic = new File(data.get(0).getName()).getName();

				String restaurant = new String(data.get(1).get(), StandardCharsets.UTF_8);

				String amount = new String(data.get(2).get(), StandardCharsets.UTF_8);

				String postDate = new String(data.get(3).get(), StandardCharsets.UTF_8);

				String postTime = new String(data.get(4).get(), StandardCharsets.UTF_8);

				String deliveryfee = new String(data.get(5).get(), StandardCharsets.UTF_8);

				String detail = new String(data.get(6).get(), StandardCharsets.UTF_8);

				String location = new String(data.get(7).get(), StandardCharsets.UTF_8);

				PostManager pm = new PostManager();
				int ma = pm.getMaxPost();
				String imgname = profile_pic.split("\\.")[1];
				String imgname2 = ma + "." + imgname;

				Post p = new Post(ma + 1, restaurant, postDate, postTime, detail, amount,
						deliveryfee, location, imgname2);

				erorr = pm.insertPost(p);
				String path = request.getSession().getServletContext().getRealPath("/") + "//images//";
				data.get(0).write(new File(path + File.separator + imgname2));
			} catch (Exception e) {
				e.printStackTrace();
				erorr = -1;
			}
			session.setAttribute("errorM", erorr);
			System.out.println("Member" + erorr);
		}
		return mav;
	}
	@RequestMapping(value = "/loadaddmeun", method = RequestMethod.GET)
	public String loadaddmeunPage() {
		return "addmenu";
	}
	@RequestMapping(value = "/losdmenus", method = RequestMethod.POST)
	public ModelAndView do_menu(HttpServletRequest request, HttpSession session) {
		int erorr = 0;
		ModelAndView mav = new ModelAndView("index");
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				
				String nameMenu = new String(data.get(0).get(), StandardCharsets.UTF_8);
				String meunPrice = new String(data.get(1).get(), StandardCharsets.UTF_8);
				
				PostManager pm = new PostManager();
				int ma = pm.getMaxPost();

				Meun m = new Meun(nameMenu,meunPrice);

				erorr = pm.insertMeun(m);
			
			} catch (Exception e) {
				e.printStackTrace();
				erorr = -1;
			}
			session.setAttribute("errorM", erorr);
			System.out.println("Member" + erorr);
		}
		return mav;
	}

	@RequestMapping (value="/searchPost",method=RequestMethod.POST)
	public String searchhotel(HttpServletRequest  request , HttpSession session) {
		 String restaurant = "";
		 String provincen = "";
		try {
			request.setCharacterEncoding("UTF-8");
		}catch(UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		 String typesearch = request.getParameter("typesearch");
		 String search = request.getParameter("search");
		 System.out.println(typesearch);
		 System.out.println(search);
		 if(typesearch.equals("name") ) {
			 restaurant = search;
			  provincen = "";
			 
		 }else if(typesearch.equals("province")) {
			 restaurant = "";
			  provincen = search;
		 }
		PostManager   PM = new PostManager();
		List<Post> st = PM.SearchPost();
		session.setAttribute("hot", st);
		return "Post";
	}
	@RequestMapping(value = "/loadorder", method = RequestMethod.GET)
	public String loadorderPage() {
		return "Order";
	}
	@RequestMapping(value = "/losdorders", method = RequestMethod.POST)
	public ModelAndView do_order(HttpServletRequest request, HttpSession session) {
		int erorr = 0;
		ModelAndView mav = new ModelAndView("index");
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				
				String reportRemark = new String(data.get(0).get(), StandardCharsets.UTF_8);
				String qtyFood = new String(data.get(1).get(), StandardCharsets.UTF_8);
				
				PostManager pm = new PostManager();
				int ma = pm.getMaxPost();

				ReportOrder ro = new ReportOrder();

				erorr = pm.insertOrder(ro);
			
			} catch (Exception e) {
				e.printStackTrace();
				erorr = -1;
			}
			session.setAttribute("errorM", erorr);
			System.out.println("Member" + erorr);
		}
		return mav;
	}
}
