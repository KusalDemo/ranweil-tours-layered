package lk.ijse.ranweli.bo.custom;

import lk.ijse.ranweli.bo.SuperBO;
import lk.ijse.ranweli.dto.AdminDto;

import java.sql.SQLException;

public interface AdminBo extends SuperBO {
    AdminDto searchAdmin(String email) throws SQLException, ClassNotFoundException;
    boolean saveAdmin(AdminDto dto) throws SQLException, ClassNotFoundException;

    /*AdminDto searchAdmin(String email) throws SQLException, ClassNotFoundException;
    boolean saveAdmin(AdminDto dto) throws SQLException, ClassNotFoundException;*/

}
