package com.example.login.and.signup.Service.impl;

import com.example.login.and.signup.Dto.EmployeeDTO;
import com.example.login.and.signup.Dto.LoginDTO;
import com.example.login.and.signup.Entity.Employee;
import com.example.login.and.signup.Repo.EmployeeRepo;
import com.example.login.and.signup.Service.EmployeeService;
import com.example.login.and.signup.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class EmployeeIMPL implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(

            employeeDTO.getEmployeeid(),
            employeeDTO.getEmployeename(),
            employeeDTO.getEmail(),
            this.passwordEncoder.encode(employeeDTO.getPassword())
        );

        employeeRepo.save(employee);
        return employee.getEmployeename();
    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO){
        String msg = "";
        Employee employee1=employeeRepo.findByEmail(loginDTO.getEmail());
        if(employee1 !=null){
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password,encodedPassword);
            if(isPwdRight){
                Optional<Employee> employee=employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if(employee.isPresent()){
                    return new LoginResponse("Login Success",true);
                }else{
                    return new LoginResponse("Login failed",true);
                }
            }else{
                return new LoginResponse("password not match",false);
            }
        } else{
            return new LoginResponse("Email not exists",false);
        }
    }
}
