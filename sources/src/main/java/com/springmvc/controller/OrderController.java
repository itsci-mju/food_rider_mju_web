package com.springmvc.controller;


import java.util.List;

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

import bean.Member;
import bean.Post;
import bean.ReportOrder;
import util.OrderManager;
import util.PostManager;
@Controller
public class OrderController {
	@RequestMapping(value = "/loadorder", method = RequestMethod.GET)
	public String loadorderPage(HttpServletRequest request, Model md, HttpSession session) {
			
			OrderManager sm = new OrderManager();
			String PostID = request.getParameter("postID");
			System.out.println("Do Se "+PostID);
			
			List<Post> sp = sm.Showpostt(PostID);
			session.setAttribute("sp", sp);
		return "orders";
	}
	@RequestMapping(value = "/loadReportOrder", method = RequestMethod.GET)
	public ModelAndView getReportOrder(HttpServletRequest request, Model md, HttpSession session) {
		int erorr = 0;
		ModelAndView mav = new ModelAndView("orders");
		if (ServletFileUpload.isMultipartContent(request)) {
			
				Post reportRemark = (Post) session.getAttribute("sp");
				Post reportDate = (Post) session.getAttribute("sp");
				Post reportTime= (Post) session.getAttribute("sp");
				double qtyFood = Double.valueOf(request.getParameter("qtyFood"));
				Member member_OrderID = (Member) session.getAttribute("Customer");
				Post post_postID = (Post) session.getAttribute("sp");
			
				OrderManager pm = new OrderManager();
				int mp = pm.getMaxOrder();
				ReportOrder ro = new ReportOrder(mp+1,reportRemark.getRestaurant(),reportDate.getPostDate()
												,reportTime.getPostTime(),qtyFood,member_OrderID.getMemID()
												,post_postID.getPostID());
				erorr = pm.insertReportOrder(ro);
		
			mav.addObject("errorM", erorr);
			session.setAttribute("errorM", erorr);
			System.out.println("Post" + erorr);
		}
		return mav;
	}
	
}
