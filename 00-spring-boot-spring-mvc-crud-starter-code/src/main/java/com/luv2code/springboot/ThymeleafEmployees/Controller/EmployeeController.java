package com.luv2code.springboot.ThymeleafEmployees.Controller;

import com.luv2code.springboot.ThymeleafEmployees.entity.Employee;
import com.luv2code.springboot.ThymeleafEmployees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// @RestController will not make a link to html in return statement
// RestAPI does not work with Thymeleaf
// so @Controller make it work with Thymeleaf
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String getEmployeesList(Model model){
        List<Employee> employeeList=employeeService.findAll();
        model.addAttribute("employees",employeeList);
        return "employees/list-employees";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "employees/employeeForm";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
//        return "employees/list-employees";
        return "redirect:/employees/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id,Model model){
        Employee employee=employeeService.findById(id);
        model.addAttribute("employee",employee);
        return "employees/employeeForm";

    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }

}














