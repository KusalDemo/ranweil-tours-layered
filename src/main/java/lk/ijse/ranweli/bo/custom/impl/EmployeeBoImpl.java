package lk.ijse.ranweli.bo.custom.impl;

import lk.ijse.ranweli.bo.custom.EmployeeBo;
import lk.ijse.ranweli.dao.DAOFactory;
import lk.ijse.ranweli.dao.custom.EmployeeDAO;
import lk.ijse.ranweli.dto.EmployeeDto;
import lk.ijse.ranweli.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBoImpl implements EmployeeBo {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    @Override
    public boolean saveEmployee(EmployeeDto employee) throws SQLException, ClassNotFoundException {
        /*return SQLUtil.execute("INSERT INTO employee VALUES(?,?,?,?,?,?,?)",employee.getEmpId(),employee.getEmpName(),employee.getEmpAddress(),employee.getEmpType(),employee.getEmpAvailability(),employee.getEmpSalary(),"kusalgunasekara2002@gmail.com");*/
        return employeeDAO.save(new Employee(employee.getEmpId(),employee.getEmpName(),employee.getEmpAddress(),employee.getEmpType(),employee.getEmpAvailability(),employee.getEmpSalary()));
    }
    @Override
    public boolean deleteEmployee(String employeeId) throws SQLException, ClassNotFoundException {
        /*return SQLUtil.execute("DELETE FROM employee WHERE empId = ?",employeeId);*/
        return employeeDAO.delete(employeeId);
    }


    @Override
    public boolean updateEmployee(EmployeeDto employee) throws SQLException, ClassNotFoundException {
       /* return SQLUtil.execute("UPDATE employee SET name = ?, address = ?, type = ?, availability = ?, salary = ? WHERE empId = ?",employee.getEmpName(),employee.getEmpAddress(),employee.getEmpType(),employee.getEmpAvailability(),employee.getEmpSalary(),employee.getEmpId());*/
        return employeeDAO.update(new Employee(employee.getEmpId(),employee.getEmpName(),employee.getEmpAddress(),employee.getEmpType(),employee.getEmpAvailability(),employee.getEmpSalary()));
    }

    @Override
    public ArrayList<EmployeeDto> getAllEmployees() throws SQLException, ClassNotFoundException {
       /* ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee");*/
        ArrayList<Employee> resultSet = employeeDAO.getAll();
        ArrayList<EmployeeDto> employeeList= new ArrayList<>();
        for (Employee employee : resultSet) {
            employeeList.add(new EmployeeDto(employee.getEmpId(),employee.getEmpName(),employee.getEmpAddress(),employee.getEmpType(),employee.getEmpAvailability(),employee.getEmpSalary()));
        }
        return employeeList;
    }
}
