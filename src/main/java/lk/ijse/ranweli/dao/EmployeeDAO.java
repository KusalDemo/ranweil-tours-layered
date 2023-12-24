package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    boolean saveEmployee(EmployeeDto dto) throws SQLException;
    boolean deleteEmployee(String employeeId) throws SQLException;
    boolean updateEmployee(EmployeeDto dto) throws SQLException;
    List<EmployeeDto> getAllEmployees() throws  SQLException;

}
