package com.ust.Employee_jpastreamer.controller;

import com.ust.Employee_jpastreamer.model.Employee;
import com.ust.Employee_jpastreamer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeContorller {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/save")
    public List<Employee> saveEmployee(@RequestBody List<Employee> employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/groupByCity")
    public Map<String, List<Employee>> groupbyEmployeeByCity(){
        return employeeService.groupEmployeeByCity();
    }
    @GetMapping("/findall")
    public List<Employee> groupbyEmployeeByPaymentTier(){
        return employeeService.groupbyEmployeeByPaymentTier();
    }

    @GetMapping("/agerange")
    public List<Employee> getEmployeeByAgeRange(@RequestParam int minAge, @RequestParam int maxAge){
        return employeeService.getEmployeeByAgeRange(minAge, maxAge);
    }

    @GetMapping("/countByGender")
    public int countByGender(@RequestParam String gender){
        return employeeService.countByGender(gender);
    }

    @GetMapping("/joiningyear")
    public List<Employee> getEmployeeByYear(int year)
    {
        return employeeService.getEmployeesByYear(year);
    }

    @GetMapping("/getCountOfGenderByYear")
    public Map<String,Long> getCountOfGenderByYear(int year){
        return employeeService.getCountOfGenderByYear(year);
    }

    @GetMapping("/groupByEducation")
    public Map<String, List<Employee>> groupbyEducation(){
        return employeeService.groupbyEducation();
    }

    @GetMapping("/filterByDetails")
    public List<Employee> filterByDetails(@RequestParam String gender , @RequestParam String education, @RequestParam int joiningYear, @RequestParam int experienceInCurrentDomain) {
        return employeeService.filterByDetails(gender , education,joiningYear, experienceInCurrentDomain);
    }}
