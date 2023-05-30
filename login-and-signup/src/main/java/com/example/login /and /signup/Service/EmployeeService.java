package com.example.login.and.signup.Service;

import com.example.login.and.signup.Dto.EmployeeDTO;
import com.example.login.and.signup.Dto.LoginDTO;
import com.example.login.and.signup.response.LoginResponse;

public interface EmployeeService {


    String addEmployee(EmployeeDTO employeeDTO);

    LoginResponse loginEmployee(LoginDTO loginDTO);
}
