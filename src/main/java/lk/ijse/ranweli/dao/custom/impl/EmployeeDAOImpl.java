package lk.ijse.ranweli.dao.custom.impl;

import lk.ijse.ranweli.dao.SQLUtil;
import lk.ijse.ranweli.dao.custom.EmployeeDAO;
import lk.ijse.ranweli.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean save(Employee employee) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO employee VALUES(?,?,?,?,?,?,?)",employee.getEmpId(),employee.getEmpName(),employee.getEmpAddress(),employee.getEmpType(),employee.getEmpAvailability(),employee.getEmpSalary(),"kusalgunasekara2002@gmail.com");
    }
    @Override
    public boolean delete(String employeeId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM employee WHERE empId = ?",employeeId);
    }

    @Override
    public Employee search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET name = ?, address = ?, type = ?, availability = ?, salary = ? WHERE empId = ?",employee.getEmpName(),employee.getEmpAddress(),employee.getEmpType(),employee.getEmpAvailability(),employee.getEmpSalary(),employee.getEmpId());
    }

    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee");
        ArrayList<Employee> employeeList= new ArrayList<>();
        while(resultSet.next()){
            employeeList.add(new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6)
            ));
        }
        return employeeList;
    }

    @Override
    public boolean updateStatus(String employeeId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET availability = 'NO' WHERE empId = ?",employeeId);
    }

    @Override
    public boolean resetYes() throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET availability = 'YES' WHERE availability = 'NO'");
    }

    @Override
    public boolean resetYes(String employeeId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET availability = 'YES' WHERE empId = ?",employeeId);
    }
}
