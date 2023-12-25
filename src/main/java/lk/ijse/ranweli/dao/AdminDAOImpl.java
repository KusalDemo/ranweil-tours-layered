package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dto.AdminDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public  AdminDto searchAdmin(String email) throws SQLException, ClassNotFoundException {
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
    public  boolean saveAdmin(AdminDto dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO admin VALUES(?,?,?,?)",dto.getEmail(),dto.getUserName(),dto.getPassword(),dto.getType());

    }
}
