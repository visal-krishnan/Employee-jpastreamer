package com.ust.Employee_jpastreamer.service;

import com.speedment.jpastreamer.application.JPAStreamer;
import com.ust.Employee_jpastreamer.model.Employee;
import com.ust.Employee_jpastreamer.repository.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    Employeerepo employeerepo;


    private final JPAStreamer jpaStreamer;

    @Autowired
    public EmployeeService(final JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }


    public Map<String, List<Employee>> groupEmployeeByCity() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getCity));
    }

    public List<Employee> groupbyEmployeeByPaymentTier() {
        return employeerepo.findAll() ;
    }

    public List<Employee> saveEmployee(List<Employee> employee) {
        return employeerepo.saveAll(employee);
    }

    public List<Employee> getEmployeeByAgeRange(int minAge, int maxAge) {
        return jpaStreamer.stream(Employee.class)
                .filter(employee -> employee.getAge() >= minAge && employee.getAge() <= maxAge)
                .collect(Collectors.toList());
    }
    public int countByGender(String gender) {
        return (int) jpaStreamer.stream(Employee.class)
                .filter(employee -> employee.getGender().equalsIgnoreCase(gender))
                .count();
    }

    public List<Employee> getEmployeesByYear(int year) {
        List<Employee> employees =  jpaStreamer.stream(Employee.class)
                .filter(employee -> employee.getJoiningYear() == year)
                        .collect(Collectors.toList());

        return employees;


    }

    public Map<String,Long> getCountOfGenderByYear(int year){
        return jpaStreamer.stream(Employee.class).filter(employee ->employee.getJoiningYear()==year)
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));

    }

    public Map<String,List<Employee>> groupbyEducation() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getEducation));
    }

    public List<Employee> filterByDetails(String gender , String education,int joiningYear, int experienceInCurrentDomain){
        return jpaStreamer.stream(Employee.class)
                .filter(employee -> employee.getGender().equalsIgnoreCase(gender) && employee.getEducation().equalsIgnoreCase(education) && employee.getJoiningYear() == joiningYear && employee.getExperienceInCurrentDomain() == experienceInCurrentDomain)
                .collect(Collectors.toList());
    }


}
