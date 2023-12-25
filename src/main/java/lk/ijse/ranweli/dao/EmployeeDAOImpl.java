package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dto.EmployeeDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean saveEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO employee VALUES(?,?,?,?,?,?,?)",dto.getEmpId(),dto.getEmpName(),dto.getEmpAddress(),dto.getEmpType(),dto.getEmpAvailability(),dto.getEmpSalary(),"kusalgunasekara2002@gmail.com");
    }
    @Override
    public boolean deleteEmployee(String employeeId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM employee WHERE empId = ?",employeeId);
    }
    @Override
    public boolean updateEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET name = ?, address = ?, type = ?, availability = ?, salary = ? WHERE empId = ?",dto.getEmpName(),dto.getEmpAddress(),dto.getEmpType(),dto.getEmpAvailability(),dto.getEmpSalary(),dto.getEmpId());
    }
    @Override
    public List<EmployeeDto> getAllEmployees() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee");
        ArrayList<EmployeeDto> dtoList= new ArrayList<>();
        while(resultSet.next()){
            dtoList.add(new EmployeeDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6)
            ));
        }
        return dtoList;
    }
}
