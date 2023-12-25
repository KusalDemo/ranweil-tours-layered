package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dto.TouristDto;

import java.sql.SQLException;

public interface TouristDAO extends CrudDAO<TouristDto> {
    /*boolean saveTourist(TouristDto dto) throws SQLException, ClassNotFoundException;
    TouristDto getTourist(String id) throws SQLException, ClassNotFoundException;*/
    String getTouristEmailFromId(String id) throws SQLException, ClassNotFoundException;
    boolean changePassword(String id, String password) throws SQLException, ClassNotFoundException;

}
