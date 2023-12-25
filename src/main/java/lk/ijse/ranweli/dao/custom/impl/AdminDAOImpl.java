package lk.ijse.ranweli.dao.custom.impl;

import lk.ijse.ranweli.dao.SQLUtil;
import lk.ijse.ranweli.dao.custom.AdminDAO;
import lk.ijse.ranweli.dto.AdminDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public  AdminDto search(String email) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM admin WHERE email = ?", email);
        AdminDto dto=null;

        if(resultSet.next()){
            dto = new AdminDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );
        }
        return dto;

    }

    @Override
    public ArrayList<AdminDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public  boolean save(AdminDto dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO admin VALUES(?,?,?,?)",dto.getEmail(),dto.getUserName(),dto.getPassword(),dto.getType());

    }

    @Override
    public boolean update(AdminDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
