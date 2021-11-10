package org.iesfm.restexample.dao.jdbc;

import org.iesfm.restexample.Department;
import org.iesfm.restexample.dao.DepartmentDAO;

import java.util.List;

public class JDBCDepartmentDAO implements DepartmentDAO {
    @Override
    public List<Department> list() {
        return null;
    }

    @Override
    public void insert(Department department) {

    }

    @Override
    public Department get(String departmentName) {
        return null;
    }

    @Override
    public void delete(String departmentName) {

    }
}
