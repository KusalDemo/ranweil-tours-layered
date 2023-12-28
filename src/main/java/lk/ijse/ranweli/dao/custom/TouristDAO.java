package lk.ijse.ranweli.dao.custom;

import lk.ijse.ranweli.dao.CrudDAO;
import lk.ijse.ranweli.entity.Tourist;

import java.sql.SQLException;

public interface TouristDAO extends CrudDAO<Tourist> {
    /*boolean saveTourist(TouristDto dto) throws SQLException, ClassNotFoundException;
    TouristDto getTourist(String id) throws SQLException, ClassNotFoundException;*/
    String getTouristEmailFromId(String id) throws SQLException, ClassNotFoundException;
    boolean changePassword(String id, String password) throws SQLException, ClassNotFoundException;

}
