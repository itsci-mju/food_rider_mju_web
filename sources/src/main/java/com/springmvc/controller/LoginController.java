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
import org.springframework.ui.Model;
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

	@RequestMapping(value = "/loginCustomer", method = RequestMethod.POST)
	public String doLogin(HttpServletRequest request, Model md, HttpSession session) {
		String memEmail = request.getParameter("Email");
		String memFeature = request.getParameter("Feature");
		String password = request.getParameter("password");
		Member m = new Member(0, "", "", memEmail, "", memFeature, "", password);
		LoginManager lm = new LoginManager();
		m = lm.verifyLogin(m);

		if (m != null) {
			session.setAttribute("m", m.getMemEmail());
			session.setAttribute("Customer", m);
			return "index";
		} else {
			session.setAttribute("login", -1);
			return "login";
		}
	}

	@RequestMapping(value = "/loadlogout", method = RequestMethod.GET)
	public String loadlogout(HttpSession session) {
		session.setMaxInactiveInterval(1);
		session.removeAttribute("disabledperson");
		return "index";
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

				Member m = new Member(ma + 1, memName, memPhone, memEmail, imgname2, memaddress, memFeature, password);
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

	/*
	 * @RequestMapping(value = "/searchCustomer", method = RequestMethod.GET) public
	 * String loadsearchRelsPage(HttpSession session) { LoginManager sm = new
	 * LoginManager(); try { List<Member> st = sm.SearchCustomer();
	 * session.setAttribute("result", st); } catch (Exception e) {
	 * e.printStackTrace(); } return "relations";
	 * 
	 * }
	 */

	@RequestMapping(value = "/edilprofile", method = RequestMethod.GET)
	public String do_edilprofile(HttpServletRequest request, Model md, HttpSession session) {
		int erorr = 0;
		ModelAndView EdilPro = new ModelAndView("index");
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

				Member m = new Member(ma + 1, memName, memPhone, memEmail, imgname2, memaddress, memFeature, password);

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
		return EdilPro;
	}

}
