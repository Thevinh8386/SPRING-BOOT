package com.example.btvnbuoi2.controller;

import com.example.btvnbuoi2.model.Employee;
import com.example.btvnbuoi2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/employees")
  public String employees(Model model) {
    model.addAttribute("employee", new Employee());
    model.addAttribute("index", employeeService.getAllEmployees());
    return "index";
  }

  //ADD new Employee
  @PostMapping("/add")
  public String add(Employee employee) {
    employeeService.saveEmployee(employee);
    return "redirect:/employees";
  }

  // UPDATE Employee
//  @PostMapping("/edit")
//  public String edit(Employee employee) {
//    employeeService.updateEmployee(employee);
//    return "redirect:/employees";
//  }

  //DELETE Employee
  @PostMapping("/delete")
  public String delete(@RequestParam("id")long id) {
    employeeService.deleteEmployeeById(id);
    return "redirect:/employees";
  }

  //DELETE Employees
  @PostMapping("/deleteAll")
  public String deleteAll(@RequestParam("ids") List<Long> ids) {
    ids.forEach(employeeService::deleteEmployeeById);
    return "redirect:/employees";
  }
}









//import com.example.btvnbuoi2.model.Employee;
//import com.example.btvnbuoi2.repository.EmployeeRepository;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping("/employees")
//public class EmployeeController {
//  @Autowired
//  private EmployeeRepository employeesRepository;
//  @GetMapping("/select")
//  public String select(HttpServletRequest request){
//    ArrayList<Employee> employees = (ArrayList<Employee>) employeesRepository.findAll();
//    request.setAttribute("employees" , employees);
////        System.out.println(employees.size());
//    return "index.html" ;
//  }
//  @GetMapping("/")
//  public String home(HttpServletRequest request){
//    return "redirect:select" ;
//  }
//  @GetMapping("/insert")
//  public String insert(@ModelAttribute Employee employee , HttpServletRequest request , HttpServletResponse response) {
//    employeesRepository.save(employee)  ;
//    System.out.println(employee.toString());
//    return "redirect:/employees/select" ;
//  }
//
//  @GetMapping(value="/delete")
//  public String delete(@RequestParam String id){
//    Employee employee = new Employee() ;
//    employee.setId(Integer.parseInt(id));
//    employeesRepository.delete(employee);
//    return "redirect:/employees/select" ;
//  }
//  @GetMapping(value= "/edit")
//  public String edit(@RequestParam String id , RedirectAttributes attributes){
//    Employee employee = new Employee() ;
//    employee.setId(Integer.parseInt(id));
//    Employee employeesById = employeesRepository.findById(Integer.parseInt(id)).get();
//    attributes.addFlashAttribute("employeesByID" , employeesById) ;
//    return "redirect:/employees/select" ;
//  }
//  @GetMapping(value = "/update")
//  public String update(@ModelAttribute Employee employee){
//    employeesRepository.save(employee)  ;
//    return "redirect:/employees/select" ;
//  }
//  @PostMapping(value = "/deleteAll")
//  public String deleteAll(@RequestParam( required = false) ArrayList<Integer> ids){
//    if(ids != null) {
//      for(int i =  0 ; i < ids.size() ; i++){
//        Employee employee = new Employee() ;
//        employee.setId(ids.get(i));
//        employeesRepository.delete(employee);
//      }
//    }
//
//    return "redirect:/employees/select" ;
//  }
//}