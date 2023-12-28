package lk.ijse.ranweli.bo.custom;

import lk.ijse.ranweli.bo.SuperBO;
import lk.ijse.ranweli.dto.TouristDto;

import java.sql.SQLException;

public interface TouristBo extends SuperBO {
    boolean saveTourist(TouristDto tourist) throws SQLException, ClassNotFoundException;

    TouristDto searchTourist(String id) throws SQLException, ClassNotFoundException;

    /*boolean saveTourist(TouristDto dto) throws SQLException, ClassNotFoundException;
            TouristDto getTourist(String id) throws SQLException, ClassNotFoundException;*/
    String getTouristEmailFromId(String id) throws SQLException, ClassNotFoundException;
    boolean changePassword(String id, String password) throws SQLException, ClassNotFoundException;

}
