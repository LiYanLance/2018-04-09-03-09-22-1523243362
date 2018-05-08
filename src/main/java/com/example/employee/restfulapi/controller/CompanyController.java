package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable long id) {
        return companyRepository.findOne(id);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesInCompany(@PathVariable long id) {
        return companyRepository.findOne(id).getEmployees();
    }

}
