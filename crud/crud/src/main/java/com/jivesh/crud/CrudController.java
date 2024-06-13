package com.jivesh.crud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("employees")
public class CrudController {

    private List<Employee> employees = new ArrayList<>();

    public CrudController() {
        
        Employee emp1 = new Employee("Jivesh", "1234567890", "jivesh@example.com");
        Employee emp2 = new Employee("Jane Doe", "0987654321", "jane.doe@example.com");

        employees.add(emp1);
        employees.add(emp2);
    }

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/addEmployeePage")
    public String showAddEmployeePage() {
        return "addEmployee";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(@RequestParam String name, @RequestParam String phone, @RequestParam String email ) {
        Employee newEmployee = new Employee(name, phone, email);
        employees.add(newEmployee);
              return "viewEmployees";
    }

   
}
