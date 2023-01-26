package com.repairs.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.repairs.model.CustomerModel;
import com.repairs.model.TechnicianModel;
import com.repairs.service.CustomerService;
import com.repairs.service.TechnicianService;
import com.repairs.service.ValidateService;

@Controller
public class RepairsController {

	Logger log = LoggerFactory.getLogger(RepairsController.class);

	@Autowired
	private CustomerService customerService;

	@Autowired
	private TechnicianService technicianService;

	@Autowired
	private ValidateService validateService;

	CustomerModel custModel;
	String skills;
	int rates;

	static {

	}

	@RequestMapping("/")
	public String firstPage(@ModelAttribute("customerModel") CustomerModel customerModel, BindingResult result) {
		return "firstpage";
	}

	@RequestMapping("/register")
	public String registerPage(@ModelAttribute("customerModel") CustomerModel customerModel, Model model)
			throws ParseException, NullPointerException {

		log.info("gen" + customerModel.getCustomerGender());
		if (validateService.inputCheck(customerModel).equals("1")) {

			if (customerService.insertCustomerService(customerModel)) {
				model.addAttribute("msg", "Successfully registered...\n Just Login to continue");
				customerModel.setCustomerLocation(null);
				customerModel.setCustomerName(null);
				customerModel.setCustomerPhone(null);

				customerModel.setCustomerGender(null);
			} else {
				model.addAttribute("msg", "Already exist Customer");
				customerModel.setCustomerLocation(null);
				customerModel.setCustomerName(null);
				customerModel.setCustomerPhone(null);
				customerModel.setCustomerGender(null);
			}

		} else {

			switch (validateService.inputCheck(customerModel)) {
			case "2":
				model.addAttribute("loc", "Invalid Location");

				break;
			case "3":
				model.addAttribute("num", "Invalid Phone Number");

				break;
			case "4":
				model.addAttribute("nam", "Invalid Name");

				break;
			case "5":
				model.addAttribute("gender", "select gender");

				break;

			default:
				break;
			}
		}
		return "firstpage";
	}

	@RequestMapping("/login")
	public String loginPage(@RequestParam("customerName") String custName,
			@RequestParam("customerPhone") String custPhone, HttpSession session, Model model) throws ParseException {

		log.info("Im in the retrival.....");
		CustomerModel cm = customerService.retrivalCustomerService(custName, custPhone);
		if (ObjectUtils.isEmpty(cm)) {
			model.addAttribute("msg", "Register");
			model.addAttribute("name", "Not a exist Customer ....Please click ");
			return "redirect";
		} else {
			session.setAttribute("select", "Select");
			session.setAttribute("name", custName);
			custModel = new CustomerModel(cm.getCustomerName(), cm.getCustomerLocation(), cm.getCustomerPhone(),
					cm.getCustomerGender());
		}

		return "secondpage";
	}

	@RequestMapping("/profile")
	public String profile(Model model, HttpSession session) {
		model.addAttribute("name", custModel.getCustomerName());
		model.addAttribute("location", custModel.getCustomerLocation());
		model.addAttribute("phoneNumber", custModel.getCustomerPhone());
		model.addAttribute("gender", custModel.getCustomerGender());
		return "profile";
	}

	@RequestMapping("/delete")
	public String delete(Model model) throws ParseException {
		customerService.deleteCustomerService(custModel);
		return "redirect:/";
	}

	@RequestMapping("/edit")
	public String edit(@RequestParam("editLocation") String loc, Model model, HttpSession session)
			throws ParseException {
		log.info("loc " + loc + session.getAttribute("custName") + session.getAttribute("custPhone"));
		if (customerService.updateCustomerService(new CustomerModel(custModel.getCustomerName(), loc,
				custModel.getCustomerPhone(), custModel.getCustomerGender()))) {
			custModel.setCustomerLocation(loc);
			session.setAttribute("edit", "Successefully edited");
		} else {
			session.setAttribute("edit", "Try again");
		}
		return "redirect:/profile";
	}

	@RequestMapping("/redierctfirst")
	public String redirectFirstpage(@ModelAttribute("customerModel") CustomerModel customerModel,
			BindingResult result) {
		return "redirect:/";
	}

	@RequestMapping("/menu")
	public ModelAndView menu(@RequestParam("techSkill") String skill, @RequestParam("techRate") int rate,
			HttpSession session) throws ParseException {

		List<TechnicianModel> list = technicianService.searchTechnicianService(custModel.getCustomerLocation(), skill,
				rate);
		skills = skill;
		rates = rate;
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		if (ObjectUtils.isEmpty(list)) {
			mav.addObject("alert", "No record available");
		} else {
			mav.addObject("alert", "List of Available Technicians");
			mav.addObject("select", "Select");
			session.setAttribute("select", "Select");
		}
		mav.setViewName("searchresults");
		return mav;
	}

	@RequestMapping("/menu/sort")
	public ModelAndView sortByRate() throws ParseException {
		List<TechnicianModel> list = technicianService.sortTechnicianService(custModel.getCustomerLocation(), skills,
				rates);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		if (ObjectUtils.isEmpty(list)) {
			mav.addObject("alert", "No record available");
		} else {
			mav.addObject("alert", "List of Available Technicians");
			mav.addObject("select", "Select");
		}
		mav.setViewName("searchresults");
		return mav;
	}

	@RequestMapping("/back")
	public String back() {
		return "secondpage";
	}

	@RequestMapping("/logout")
	public String logout() {
		custModel = new CustomerModel(null, null, null, null);
		skills = null;
		rates = 0;
		return "redirect:/";
	}

	@RequestMapping(value = "/request")
	public String request(@RequestParam("technicianName") String techName, Model model, HttpSession session) {
		log.info("In request........." + techName);
		List<TechnicianModel> list = technicianService.selectTechnicianService(techName);
		log.info("In request method : list  = {}", ObjectUtils.isEmpty(list));
		String str = "Select successful.. " + (techName.substring(0, 1).toUpperCase() + techName.substring(1))
				+ " will contact you soon";
		model.addAttribute("list", list);
		model.addAttribute("alert", str);
		session.setAttribute("select", "Selected");
		return "searchresults";
	}

}
