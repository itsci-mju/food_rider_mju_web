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

	/*
	 * @RequestMapping(value = "/loadeditProfile", method = RequestMethod.GET)
	 * public String loadeditProfile(HttpServletRequest request, Model md,
	 * HttpSession session) { try { String ef = request.getParameter("memEmail");
	 * LoginManager lm = new LoginManager(); List<Member> me = lm.getCustomer(ef);
	 * System.out.println("565656"); session.se5tAttribute("stCustomer",
	 * me.get(0).getMemEmail()); } catch (ArrayIndexOutOfBoundsException e) {
	 * System.out.println("Error: the array is empty!"); } return "editProfile"; }
	 */

	@RequestMapping(value = "/loadlogout", method = RequestMethod.GET)
	public String loadlogout(HttpSession session) {
		session.setMaxInactiveInterval(1);
		session.removeAttribute("customer");
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

	/*@RequestMapping(value = "/loadeditProfile", method = RequestMethod.GET)
	public ModelAndView getProfiles(HttpServletRequest request, Model md, HttpSession session) {
		int erorr = 0;
		ModelAndView mav = new ModelAndView("editProfile");
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				request.setCharacterEncoding("UTF-8");
				String memImageProfile = new String(data.get(0).get(), StandardCharsets.UTF_8);
				String memName = new String(data.get(1).get(), StandardCharsets.UTF_8);
				String memEmail = new String(data.get(2).get(), StandardCharsets.UTF_8);
				String memaddress = new String(data.get(3).get(), StandardCharsets.UTF_8);
				String memPhone = new String(data.get(4).get(), StandardCharsets.UTF_8);
				String memFeature = new String(data.get(5).get(), StandardCharsets.UTF_8);
				String password = new String(data.get(6).get(), StandardCharsets.UTF_8);
				LoginManager lm = new LoginManager();
				int ma = lm.getMaxMember();
				String s = String.valueOf(ma);
				String imgname = memImageProfile.split("\\.")[1];
				String imgname2 = ma + "." + imgname;
				Member mr = new Member(ma + 1, memImageProfile, memName, memEmail, memaddress, memPhone, memFeature,
						password);
				erorr = lm.EditProfile(mr);
				String path = request.getSession().getServletContext().getRealPath("/") + "//images//";
				data.get(0).write(new File(path + File.separator + imgname2));
			} catch (Exception e) {
				e.printStackTrace();
				erorr = -1;
			}
			mav.addObject("errorM", erorr);
			session.setAttribute("errorM", erorr);
			System.out.println("Member" + erorr);
		}
		return mav;
	}*/

	@RequestMapping(value = "/loadUSERS", method = RequestMethod.GET)
	public String USERSpage(HttpSession session) {
		LoginManager lm = new LoginManager();
		List<Member> m = lm.ShowUSERS();
		session.setAttribute("registerALL", m);
		return "users";
	}


	
	@RequestMapping(value = "/loadeditProfile", method = RequestMethod.GET)
	public ModelAndView getProfiles(HttpServletRequest request, Model md, HttpSession session) {
		int erorr = 0;
		ModelAndView mav = new ModelAndView("editProfile");
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				request.setCharacterEncoding("UTF-8");
				
				String memName = request.getParameter("memName");
				String memEmail = request.getParameter("memEmail");
				String memaddress = request.getParameter("memaddress");
				String memPhone = request.getParameter("memPhone");
				String memFeature = request.getParameter("memFeature");
				String memImageProfile =request.getParameter("memImageProfile");
				String password = request.getParameter("password");
				LoginManager lm = new LoginManager();
				int ma = lm.getMaxMember();
				String s = String.valueOf(ma);
				
				Member mr = new Member(ma + 1, memName , memEmail,memaddress,memPhone , memFeature, memImageProfile,
						password);
				erorr = lm.EditProfile(mr);
				
			} catch (Exception e) {
				e.printStackTrace();
				erorr = -1;
			}
			mav.addObject("errorM", erorr);
			session.setAttribute("errorM", erorr);
			System.out.println("Member" + erorr);
		}
		return mav;
	}
	@RequestMapping(value = "/loaddelMember", method = RequestMethod.GET)
	public String loadrdelMemberPage() {
		return "listMember";
	}
	@RequestMapping (value="/delMember",method=RequestMethod.GET)
	public String dodelMember(HttpServletRequest request) {
	try {
	request.setCharacterEncoding("UTF-8");
	}catch(UnsupportedEncodingException e) {
	e.printStackTrace();
	}
	String memID = request.getParameter("memID");
	System.out.println(memID);
	LoginManager sm = new LoginManager();
	int r = sm.deletemember(memID);
	request.setAttribute("rmember", r);
	return "index";

	}
}
