package com.mylesoft.crm.controller.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;

import com.mylesoft.crm.pojo.CustomerDO;
import com.mylesoft.crm.service.CustomerService;  
  
/** 
 * Created by zhouhaishui on 2017/5/2. 
 */  
@Controller  
public class PageController {  
  
	@Autowired
	private CustomerService customerService;
	
	/** 
     * 跳转页面 传数据方法 
     * @param model 
     * @return 
     */  
    @RequestMapping("/")  
    public String index(Model model) {  
    	List<CustomerDO> customerList = customerService.list();
    	CustomerDO customer = customerList.get(0);
    	System.out.println("customer=" +customer);
    	System.out.println("customerList=" +customerList);
        model.addAttribute("customer",customer);  
        model.addAttribute("customerList",customerList); 
        // 返回 index.html页面  
        return "index";  
    }  
    
   
    @RequestMapping("/topnav")  
    public String topnav(){  
        return "top-nav";  
    }
  
    /** 
     * 跳转 
     * @return 
     */  
    @RequestMapping("/redirect")  
    public String page2(){  
        return "redirect/redirect";  
    }  
  
  
    /** 
     *视图 
     * @param model 
     * @return 
     */  
    @RequestMapping("/model")  
    public String page3(Model model){  
        model.addAttribute("name","seawater");  
        return "hello";  
    }  
} 