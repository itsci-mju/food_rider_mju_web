package com.springmvc.controller;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public ModelAndView do_posts(HttpServletRequest request, Model md, HttpSession session) {
		int message = 0;
		ModelAndView mav = new ModelAndView("post");
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				String profile_pic = new File(data.get(0).getName()).getName();
				String restaurant = new String(data.get(1).get(), StandardCharsets.UTF_8);
				
				Date postDate = new Date();
				Date postTime = new Date();
				Date now = new Date();
		        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		        String timeString = format.format(now);
		        
				String detail = new String(data.get(4).get(), StandardCharsets.UTF_8);
				int amount = Integer.parseInt(data.get(5).getString());
				int deliveryfee = Integer.parseInt(data.get(6).getString());
				String location = new String(data.get(7).get(), StandardCharsets.UTF_8);
				System.out.println(data.get(2).get());
				PostManager pm = new PostManager();
				System.out.println(profile_pic);
				int mp = pm.getMaxPost();
				String imgname = profile_pic.split("\\.")[1];
				String imgname2 = mp + "." + imgname;

				Post p = new Post(mp + 1, restaurant,postDate ,postTime , detail, amount, deliveryfee,
						location, imgname2);
				message = pm.insertPost(p);
				String path = request.getSession().getServletContext().getRealPath("/") + "//images//";
				System.out.println(path);

				data.get(0).write(new File(path + File.separator + imgname2));
				
				

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("55555");
				message = -1;
			}
		}
		mav.addObject("message", message);
		return mav;
	}

	/*@RequestMapping(value = "/losdposts", method = RequestMethod.POST)
	public @ResponseBody ModelAndView do_posts(HttpServletRequest request, Model md, HttpSession session) {
		int message = 0;
		PostManager pm = new PostManager();
		ModelAndView mav = new ModelAndView("index");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

				int postPhone = Integer.parseInt("Phone");
				String restaurant = request.getParameter("restaurant");
				Date postDate = Date.from(null);
				Date postTime = Date.from(null);
				String detail = request.getParameter("detail");
				int amount = Integer.parseInt("amount");
				int deliveryfee = Integer.parseInt("deliveryfee");
				String location = request.getParameter("location");
				String profile_pic = request.getParameter("profile_pic");

				int mp = pm.getMaxPost();
				Post p = new Post(mp, postPhone, restaurant, postDate, postTime, detail, amount, deliveryfee, location,
						profile_pic);
				message = pm.insertPost(p);

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("55555");
				message = -1;
			}
		}
		session.setAttribute("messagePost", message);
		System.out.println(message + "yse");
		return mav;
	}*/

	/*
	 * @RequestMapping(value = "/losdposts", method = RequestMethod.POST) public
	 * ModelAndView do_post(HttpServletRequest request, HttpSession session) { int
	 * erorr = 0; ModelAndView mav = new ModelAndView("index"); if
	 * (ServletFileUpload.isMultipartContent(request)) { try { List<FileItem> data =
	 * new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	 * 
	 * String profile_pic = new File(data.get(0).getName()).getName(); String postID
	 * = new String(data.get(1).get(), StandardCharsets.UTF_8); String restaurant =
	 * new String(data.get(2).get(), StandardCharsets.UTF_8); String postDate = new
	 * String(data.get(3).get(), StandardCharsets.UTF_8); String postTime = new
	 * String(data.get(4).get(), StandardCharsets.UTF_8); String detail = new
	 * String(data.get(5).get(), StandardCharsets.UTF_8); String amount = new
	 * String(data.get(6).get(), StandardCharsets.UTF_8); String deliveryfee = new
	 * String(data.get(7).get(), StandardCharsets.UTF_8); String location = new
	 * String(data.get(8).get(), StandardCharsets.UTF_8); PostManager pm = new
	 * PostManager(); int ma = pm.getMaxPost(); String imgname =
	 * profile_pic.split("\\.")[1]; String imgname2 = ma + "." + imgname;
	 * 
	 * Post p = new Post(postID, restaurant, postDate, postTime, detail, amount,
	 * deliveryfee, location, imgname2);
	 * 
	 * erorr = pm.insertPost(p); String path =
	 * request.getSession().getServletContext().getRealPath("/") + "//images//";
	 * data.get(0).write(new File(path + File.separator + imgname2));
	 * System.out.println("OK 55 "); } catch (Exception e) { e.printStackTrace();
	 * erorr = -1; } session.setAttribute("ERROR_P", erorr);
	 * System.out.println("Post" + erorr); } return mav; }
	 */
	@RequestMapping(value = "/loadaddmeun", method = RequestMethod.GET)
	public String loadaddmeunPage() {
		return "addmenu";
	}

	@RequestMapping(value = "/losdmenus", method = RequestMethod.POST)
	public ModelAndView do_menu(HttpServletRequest request, HttpSession session) {
		int erorr = 0;
		ModelAndView mav = new ModelAndView("post");
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				String nameMenu = new String(data.get(0).get(), StandardCharsets.UTF_8);
				String meunPrice = new String(data.get(1).get(), StandardCharsets.UTF_8);

				PostManager pm = new PostManager();

				int ma = pm.getMaxPost();
				Meun m = new Meun(ma + 1, nameMenu, meunPrice);
				System.out.println(m.getIdmeun() + m.getNameMenu() + m.getMeunPrice());
				System.out.println(pm + "    55");
				erorr = pm.insertMeun(m);

			} catch (Exception e) {
				System.out.println("  gdsgsd  55");
				e.printStackTrace();
				erorr = -1;
			}
			session.setAttribute("errorM", erorr);
			System.out.println("Member" + erorr);
		}
		return mav;
	}

	/*
	 * @RequestMapping (value="/searchPost",method=RequestMethod.POST) public String
	 * searchhotel(HttpServletRequest request , HttpSession session) { String
	 * restaurant = ""; String provincen = ""; try {
	 * request.setCharacterEncoding("UTF-8"); }catch(UnsupportedEncodingException
	 * e1) { e1.printStackTrace(); }
	 * 
	 * String typesearch = request.getParameter("typesearch"); String search =
	 * request.getParameter("search"); System.out.println(typesearch);
	 * System.out.println(search); if(typesearch.equals("name") ) { restaurant =
	 * search; provincen = "";
	 * 
	 * }else if(typesearch.equals("province")) { restaurant = ""; provincen =
	 * search; } PostManager PM = new PostManager(); List<Post> st =
	 * PM.SearchPost(); session.setAttribute("hot", st); return "Post"; }
	 */
	@RequestMapping(value = "/loadorder", method = RequestMethod.GET)
	public String loadorderPage() {
		return "Order";
	}
	/*
	 * @RequestMapping(value = "/losdorders", method = RequestMethod.POST) public
	 * ModelAndView do_order(HttpServletRequest request, HttpSession session) { int
	 * erorr = 0; ModelAndView mav = new ModelAndView("index"); if
	 * (ServletFileUpload.isMultipartContent(request)) { try { List<FileItem> data =
	 * new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	 * 
	 * String reportRemark = new String(data.get(0).get(), StandardCharsets.UTF_8);
	 * String qtyFood = new String(data.get(1).get(), StandardCharsets.UTF_8);
	 * 
	 * PostManager pm = new PostManager(); int ma = pm.getMaxPost();
	 * 
	 * ReportOrder ro = new ReportOrder();
	 * 
	 * erorr = pm.insertOrder(ro);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); erorr = -1; }
	 * session.setAttribute("errorM", erorr); System.out.println("Member" + erorr);
	 * } return mav; }
	 */
}
