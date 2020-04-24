package eu.ensup.springbootjpaweb.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

	@GetMapping("getForm")
	public String getForm() {
		return "employeeForm";
	}

	@PostMapping("/saveDetails")
	public String saveDetails(@RequestParam("employeeName") String employeeName,
			@RequestParam("employeeEmail") String employeeEmail, ModelMap modelMap) {

		
		modelMap.put("employeeName", employeeName);
		modelMap.put("employeeEmail", employeeEmail);
		return "viewDetails"; 
	}
	
	@GetMapping("getFormAjoutEtudiant")
	public String getFormAjoutEtudiant() {
		return "liste";
	}
}