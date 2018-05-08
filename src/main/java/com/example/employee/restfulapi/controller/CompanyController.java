package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/page/{page}/pageSize/{pageSize}")
    public List<Company> getCompaniesByPage(@PathVariable int page, @PathVariable int pageSize) {
        return companyRepository.findAll(new PageRequest(page - 1, pageSize)).getContent();
    }

    @PostMapping
    public Company addCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }

}
