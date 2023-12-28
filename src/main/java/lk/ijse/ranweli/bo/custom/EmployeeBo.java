package lk.ijse.ranweli.bo.custom;

import lk.ijse.ranweli.bo.SuperBO;
import lk.ijse.ranweli.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBo extends SuperBO {
    boolean saveEmployee(EmployeeDto employee) throws SQLException, ClassNotFoundException;

    boolean deleteEmployee(String employeeId) throws SQLException, ClassNotFoundException;

    boolean updateEmployee(EmployeeDto employee) throws SQLException, ClassNotFoundException;

    ArrayList<EmployeeDto> getAllEmployees() throws SQLException, ClassNotFoundException;
}
