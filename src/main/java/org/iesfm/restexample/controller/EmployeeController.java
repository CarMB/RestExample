package org.iesfm.restexample.controller;

import org.iesfm.restexample.Employee;
import org.iesfm.restexample.dao.EmployeeDAO;

import java.util.List;

public class EmployeeController {

    private EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    
}
