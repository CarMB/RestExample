package org.iesfm.restexample.controller;

import org.iesfm.restexample.Employee;
import org.iesfm.restexample.dao.DepartmentDAO;
import org.iesfm.restexample.dao.EmployeeDAO;
import org.iesfm.restexample.dao.inmemory.InMemoryEmployeeDAO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Method;
import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    //    Pedir todos los empleados GET http://{host}:{puerto}/employee
    @RequestMapping(method = RequestMethod.GET, path = "/employee")
    public List<Employee> list() {
        return employeeDAO.list();
    }

    //    ii. Pedir un empleado GET http://{host}:{puerto}/employees/{nif}
    //        1. Si el empleado no existe, error 404
    @RequestMapping(method = RequestMethod.GET, path = ("/employees/{nif}"))
    public Employee getEmployee(@PathVariable("nif") String nif) {
        Employee employee = employeeDAO.get(nif);
        if (nif == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "empleado no existe");
        } else {
            return employee ;
        }
    }


    //    iii. Crear un empleado POST http://{host}:{puerto}/employees
//            1. JSON en el body
//            2. Si el empleado ya exite, error 409 (conflicto)
    @RequestMapping(method = RequestMethod.POST, path = ("/employees"))
    public void createEmployee(@RequestBody Employee employee) {
        employeeDAO.insert(employee);
    }

    //    iv. Eliminar un empleado DELETE http://{host}:{puerto}/empoyees/{nif}
//            1. Si el empleado no exite, error 404
    public void deleteEmployee(String nif) {
        employeeDAO.delete(nif);
    }
//    v. Mostrar los empleados de un departamento GET http://{host}:{puerto}/departments/{departmentName}/employees
//            1. Si el departamento no existe, error 404

//    public List<Employee> showEmployeeByDepartment(EmployeeDAO employeeDAO, DepartmentDAO departmentDAO) {
//
//    }


}
