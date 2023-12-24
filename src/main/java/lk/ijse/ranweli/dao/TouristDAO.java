package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dto.TouristDto;

import java.sql.SQLException;

public interface TouristDAO {
    boolean saveTourist(TouristDto dto) throws SQLException;
    TouristDto getTourist(String id) throws SQLException;
    String getTouristEmailFromId(String id) throws SQLException;
    boolean changePassword(String id, String password) throws SQLException;

}
