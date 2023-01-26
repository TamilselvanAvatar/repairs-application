package com.repairs.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.repairs.model.CustomerModel;

import java.util.regex.Matcher;

@Service
public class ValidateService {
	public String inputCheck(CustomerModel custModel) {
		Pattern pattern1 = Pattern.compile("[a-zA-Z]+[\s]{0,1}[a-zA-Z]*");
		Pattern pattern = Pattern.compile("[6-9]{1}[0-9]{9}");

		String name = custModel.getCustomerName();
		String number = custModel.getCustomerPhone();
		String location = custModel.getCustomerLocation();
		Matcher match = pattern.matcher(number);
		if (name.length() >= 3 && name.length() < 15 && name != "" && pattern1.matcher(name).find()) {
			if (match.find()) {
				if (location.length() >= 3 && pattern1.matcher(location).find()) {
					if (!custModel.getCustomerGender().equals("notselected")) {
						return "1";
					} else {
						return "5";
					}
				} else {
					return ("2");
				}
			} else {
				return ("3");
			}
		} else {
			return ("4");
		}
	}

}
