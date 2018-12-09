package com.itheima.core.web.controller;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.Page;
import com.itheima.core.po.BaseDict;
import com.itheima.core.po.Customer;
import com.itheima.core.po.User;
import com.itheima.core.service.BaseDictService;
import com.itheima.core.service.CustomerService;
/**
 * 瀹㈡埛绠＄悊鎺у埗鍣ㄧ被
 */
@Controller
public class CustomerController {
	// 渚濊禆娉ㄥ叆
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BaseDictService baseDictService;
	// 瀹㈡埛鏉ユ簮
	@Value("${customer.from.type}")
	private String FROM_TYPE;
	// 瀹㈡埛鎵�灞炶涓�
	@Value("${customer.industry.type}")
	private String INDUSTRY_TYPE;
	// 瀹㈡埛绾у埆
	@Value("${customer.level.type}")
	private String LEVEL_TYPE;
	/**
	 *  瀹㈡埛鍒楄〃
	 */
	@RequestMapping(value = "/customer/list.action")
	public String list(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="10")Integer rows, 
			String custName, String custSource, String custIndustry,
			String custLevel, Model model) {
		// 鏉′欢鏌ヨ鎵�鏈夊鎴�
		Page<Customer> customers = customerService
				.selectCustomerList(page, rows, custName, 
                                        custSource, custIndustry,custLevel);
		model.addAttribute("page", customers);
		// 瀹㈡埛鏉ユ簮
		List<BaseDict> fromType = baseDictService
				.selectBaseDictList(FROM_TYPE);
		// 瀹㈡埛鎵�灞炶涓�
		List<BaseDict> industryType = baseDictService
				.selectBaseDictList(INDUSTRY_TYPE);
		// 瀹㈡埛绾у埆
		List<BaseDict> levelType = baseDictService
				.selectBaseDictList(LEVEL_TYPE);
		// 娣诲姞鍙傛暟
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		model.addAttribute("custName", custName);
		model.addAttribute("custSource", custSource);
		model.addAttribute("custIndustry", custIndustry);
		model.addAttribute("custLevel", custLevel);
		return "customer";
	}
	

}
