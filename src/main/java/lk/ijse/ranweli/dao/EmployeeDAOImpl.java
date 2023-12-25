package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dto.EmployeeDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean save(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO employee VALUES(?,?,?,?,?,?,?)",dto.getEmpId(),dto.getEmpName(),dto.getEmpAddress(),dto.getEmpType(),dto.getEmpAvailability(),dto.getEmpSalary(),"kusalgunasekara2002@gmail.com");
    }
    @Override
    public boolean delete(String employeeId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM employee WHERE empId = ?",employeeId);
    }

    @Override
    public EmployeeDto search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET name = ?, address = ?, type = ?, availability = ?, salary = ? WHERE empId = ?",dto.getEmpName(),dto.getEmpAddress(),dto.getEmpType(),dto.getEmpAvailability(),dto.getEmpSalary(),dto.getEmpId());
    }

    @Override
    public ArrayList<EmployeeDto> getAll() throws SQLException, ClassNotFoundException {
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
