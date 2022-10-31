package com.springmvc.controller;

import java.io.File;
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
public class LoginController {

	@RequestMapping(value = "/loadlogin", method = RequestMethod.GET)
	public String loadloginPage() {
		return "login";
	}

	@RequestMapping(value = "/loadloginadmin", method = RequestMethod.GET)
	public String loadloginadminPage() {
		return "loginadmin";
	}

	@RequestMapping(value = "/loadregister", method = RequestMethod.GET)
	public String loadregisterPage() {
		return "register";
	}

	@RequestMapping(value = "/mregister", method = RequestMethod.POST)
	public ModelAndView do_register(HttpServletRequest request, HttpSession session) {
		int erorr = 0;
		ModelAndView mav = new ModelAndView("index");
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				String memImageProfile = new File(data.get(0).getName()).getName();

				String memName = new String(data.get(1).get(), StandardCharsets.UTF_8);

				String memEmail = new String(data.get(2).get(), StandardCharsets.UTF_8);

				String memaddress = new String(data.get(3).get(), StandardCharsets.UTF_8);

				String memPhone = new String(data.get(4).get(), StandardCharsets.UTF_8);

				String memFeature = new String(data.get(5).get(), StandardCharsets.UTF_8);

				String password = new String(data.get(6).get(), StandardCharsets.UTF_8);
				System.out.println(memFeature);

				LoginManager lm = new LoginManager();
				int ma = lm.getMaxMember();
				String imgname = memImageProfile.split("\\.")[1];
				String imgname2 = ma + "." + imgname;

				Member m = new Member(ma + 1, memName, memPhone, memEmail, imgname2,memaddress , memFeature, password);
				// System.out.println(m.getMemAID()+m.getMemAName()+m.getMemAPhone()+m.getMemAEmail()+m.getMemAaddress()+m.getMemAImageProfile()+m.getApassword());

				erorr = lm.insertMember(m);
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

	@RequestMapping(value = "/loadregisteradmin", method = RequestMethod.GET)
	public String loadregisteradminPage() {
		return "registeradmin";
	}

	@RequestMapping(value = "/mregisteradmin", method = RequestMethod.POST)
	public ModelAndView do_registeradmin(HttpServletRequest request, HttpSession session) {
		int erorr = 0;
		ModelAndView mav = new ModelAndView("index");
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				String memAImageProfile = new File(data.get(0).getName()).getName();

				String memAName = new String(data.get(1).get(), StandardCharsets.UTF_8);

				String memAEmail = new String(data.get(2).get(), StandardCharsets.UTF_8);

				String memAaddress = new String(data.get(3).get(), StandardCharsets.UTF_8);

				String memAPhone = new String(data.get(4).get(), StandardCharsets.UTF_8);

				String Apassword = new String(data.get(5).get(), StandardCharsets.UTF_8);

				LoginManager lm = new LoginManager();
				int ma = lm.getMaxMemberAdmin();
				String imgname = memAImageProfile.split("\\.")[1];
				String imgname2 = ma + "." + imgname;

				MemberAdmin m = new MemberAdmin(ma + 1, memAName, memAPhone, memAEmail, memAaddress, imgname2,
						Apassword);
				// System.out.println(m.getMemAID()+m.getMemAName()+m.getMemAPhone()+m.getMemAEmail()+m.getMemAaddress()+m.getMemAImageProfile()+m.getApassword());

				erorr = lm.insertMemberA(m);
				String path = request.getSession().getServletContext().getRealPath("/") + "//images//";
				data.get(0).write(new File(path + File.separator + imgname2));
			} catch (Exception e) {
				e.printStackTrace();
				erorr = -1;
			}
			session.setAttribute("errorA", erorr);
			System.out.println("Admin" + erorr);
		}
		return mav;
	}

	@RequestMapping(value = "/loadindex", method = RequestMethod.GET)
	public String loadindexPage() {
		return "index";
	}

	


}
