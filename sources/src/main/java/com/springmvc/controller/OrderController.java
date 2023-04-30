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
public class OrderController {
	@RequestMapping(value = "/loadorder", method = RequestMethod.GET)
	public String loadorderPage(HttpServletRequest request, Model md, HttpSession session) {
		PostManager sm = new PostManager();
		Member member_PostID = (Member)session.getAttribute("Customer");
		List<Post> st = sm.Showpost(member_PostID.getMemID());
		session.setAttribute("st",st);
		System.out.println("dasdas");
		return "orders";
	}
}
