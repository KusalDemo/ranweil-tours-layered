package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dto.AdminDto;

import java.sql.SQLException;

public interface AdminDAO {
    AdminDto searchAdmin(String email) throws SQLException;
    boolean saveAdmin(AdminDto dto) throws SQLException;
}
