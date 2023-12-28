package lk.ijse.ranweli.dao.custom;

import lk.ijse.ranweli.dao.CrudDAO;
import lk.ijse.ranweli.entity.Employee;

import java.sql.SQLException;

public interface EmployeeDAO extends CrudDAO<Employee> {
    boolean updateStatus(String employeeId) throws SQLException, ClassNotFoundException;
    boolean resetYes() throws SQLException, ClassNotFoundException;
    boolean resetYes(String employeeId) throws SQLException, ClassNotFoundException;

    /*boolean saveEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException;
    boolean deleteEmployee(String employeeId) throws SQLException, ClassNotFoundException;
    boolean updateEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException;
    List<EmployeeDto> getAllEmployees() throws SQLException, ClassNotFoundException;*/
}
