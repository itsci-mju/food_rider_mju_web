package com.springmvc.controller;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.io.File;
import java.io.UnsupportedEncodingException;
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

	@RequestMapping(value = "/loadpost", method = RequestMethod.GET)
	public String loadaddpostPage() {
		return "post";
	}

	@RequestMapping(value = "/losdposts", method = RequestMethod.POST)
	public ModelAndView do_posts(HttpServletRequest request, Model md, HttpSession session) {
		int message = 0;
		ModelAndView mav = new ModelAndView("index");
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				String profile_pic = new File(data.get(0).getName()).getName();
				String restaurant = new String(data.get(1).get(), StandardCharsets.UTF_8);
				String meun = new File(data.get(2).getName()).getName();
				System.out.println(meun);
				String postDate = new String(data.get(3).get(), StandardCharsets.UTF_8);
				String postTime = new String(data.get(4).get(), StandardCharsets.UTF_8);
				/*
				 * Date now = new Date(); SimpleDateFormat format = new
				 * SimpleDateFormat("HH:mm:ss"); String timeString = format.format(now);
				 */
				int amount = Integer.parseInt(data.get(5).getString());
				int deliveryfee = Integer.parseInt(data.get(6).getString());
				String detail = new String(data.get(7).get(), StandardCharsets.UTF_8);
				String location = new String(data.get(8).get(), StandardCharsets.UTF_8);
				Member member_PostID = (Member) session.getAttribute("Customer");

				System.out.println(postDate);
				System.out.println(postTime);
				PostManager pm = new PostManager();
				System.out.println(profile_pic);
				int mp = pm.getMaxPost();
				String imgname = profile_pic.split("\\.")[1];
				String imgmeun = meun.split("\\.")[1];
				String imgname2 = mp + "." + imgname;
				String imgmeun2 = mp + "." + imgmeun;
				Post p = new Post(mp + 1, restaurant, imgmeun2, postDate, postTime, detail, amount, deliveryfee,
						location, imgname2, member_PostID.getMemID());
				message = pm.insertPost(p);
				String path = request.getSession().getServletContext().getRealPath("/") + "//images//";
				System.out.println(path);
				System.out.println("g5" + imgmeun);
				System.out.println("member_PostID" + member_PostID.getMemID());
				data.get(0).write(new File(path + File.separator + imgname2));
				data.get(2).write(new File(path + File.separator + imgmeun2));

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("444");
				message = -1;
			}
		}
		mav.addObject("message", message);
		return mav;
	}

	@RequestMapping(value = "/loadeditPost", method = RequestMethod.GET)
	public ModelAndView geteditPost(HttpServletRequest request, Model md, HttpSession session) {
		int erorr = 0;
		ModelAndView mav = new ModelAndView("editPost");
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				request.setCharacterEncoding("UTF-8");

				int postID = Integer.parseInt(request.getParameter("postID"));
				String restaurant = request.getParameter("restaurant");
				String meun = request.getParameter("meun");
				String postDate = request.getParameter("postDate");
				String postTime = request.getParameter("postTime");
				int amount = Integer.parseInt(request.getParameter("amount"));
				int deliveryfee = Integer.parseInt(request.getParameter("deliveryfee"));
				String detail = request.getParameter("detail");
				String location = request.getParameter("location");
				String profile_pic = request.getParameter("profile_pic");
				Member member_PostID = (Member) session.getAttribute("Customer");
				PostManager lm = new PostManager();
				int ma = lm.getMaxPost();
				String s = String.valueOf(ma);

				Post mr = new Post(postID, restaurant, meun, postDate, postTime, detail, amount, deliveryfee, location,
						profile_pic, member_PostID.getMemID());
				erorr = lm.EditPost(mr);

			} catch (Exception e) {
				e.printStackTrace();
				erorr = -1;
			}
			mav.addObject("errorM", erorr);
			session.setAttribute("errorM", erorr);
			System.out.println("Post" + erorr);
		}
		return mav;
	}

	@RequestMapping(value = "/loadeditP", method = RequestMethod.GET)
	public String loadeditPostsPage(HttpSession session, HttpServletRequest request) {
		System.out.println("id+dvsdvvs+ ");
		String postID = request.getParameter("postID");

		PostManager sm = new PostManager();
		Post s = sm.getpost(postID);
		session.setAttribute("Epost", s);
		System.out.println("id+ " + postID);
		return "editPost";
	}

	@RequestMapping(value = "/loadlistPost", method = RequestMethod.GET)
	public String do_listPost(HttpSession session) {
		PostManager sm = new PostManager();
		session.setMaxInactiveInterval(1);
		session.removeAttribute("posts");
		return "listPost";
	}

	@RequestMapping(value = "/ShowPost", method = RequestMethod.GET)
	public String doShowPost(HttpSession session, HttpServletRequest request) {
		PostManager sm = new PostManager();
		Member member_PostID = (Member) session.getAttribute("Customer");
		List<Post> sp = sm.Showpost(member_PostID.getMemID());
		for (Post m : sp) {
			System.out.println("ko" + m.getPostID());
		}
		session.removeAttribute("sp");
		session.setAttribute("sp", sp);
		return "listPost";
	}

	@RequestMapping(value = "/delPost", method = RequestMethod.GET)
	public String dodelPost(HttpServletRequest request, HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String postID = request.getParameter("postID");
		System.out.println(postID);
		PostManager sm = new PostManager();
		Member member_PostID = (Member) session.getAttribute("Customer");
		int r = sm.deletePost(postID);
		request.setAttribute("rpost", r);
		List<Post> st = sm.Showpost(member_PostID.getMemID());
		session.setAttribute("st", st);
		return "listPost";
	}

	
}
