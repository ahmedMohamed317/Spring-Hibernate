package springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springdemo.dao.CustomerDAO;
import springdemo.entity.Customer;
import springdemo.service.CustomerService;

@Controller
@RequestMapping("/test")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@RequestMapping("/controller")
	public String getCustomers(Model model) {
	
		List<Customer> customers =customerService.getCustomer();
		model.addAttribute("customers",customers);
		return "list-customers";
	}
	
	@RequestMapping("/showFormForAdd")
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		
		return "customer-form";
	}
	
	@RequestMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer,Model model ) {
		Customer theCustomer = (Customer) model.getAttribute("customer");
		System.out.println("save"+theCustomer);
		customerService.saveCustomer(customer);
		return "redirect:/test/controller";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerID") int id,Model model ) {
		Customer theCustomer = customerService.getCustomerById(id);
		System.out.println("update"+theCustomer);
		model.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@RequestMapping("/showFormForDelete")
	public String deleteCustomer(@RequestParam("customerID") int id,Model model ) {
		customerService.deleteCustomer(id);
		return "redirect:/test/controller";
	}

}
