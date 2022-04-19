package com.hotel_management.controller;

import com.hotel_management.model.Employee;
import com.hotel_management.model.JobPosting;
import com.hotel_management.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //Display list of all employees
    @GetMapping("/admin/authenticate/all_emp")
    public String viewallemp(Model model){
        model.addAttribute("listemp",employeeService.getAllEmployees());
        return "all_emp";
    }

    // Create model attribute to bind the form data
    @GetMapping("/admin/authenticate/createNewEmployee")
    public  String creatnewemp(Model model){
        Employee employee = new Employee();
        model.addAttribute("emp",employee);
        return "new_emp";
    }

    // to save a employee
    @PostMapping("/saveEmp")
    public String saveEmp(@ModelAttribute("emp") Employee employee){
        System.out.println(employee.getEmployeename());
        employeeService.saveEmployee(employee);
        return "redirect:/admin/authenticate/all_emp";
    }

    // controller to handle update of job posting
    @GetMapping("/admin/authenticate/updateEmp/{eid}")
    public  String updateEmp(@PathVariable(value = "eid") long eid, Model model){
        Employee employee = employeeService.getEmployeeId(eid);

        model.addAttribute("emp",employee);
        return "update_emp";
    }
}
