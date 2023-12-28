package lk.ijse.ranweli.dao.custom;

import lk.ijse.ranweli.dao.CrudDAO;
import lk.ijse.ranweli.entity.Hotel;

import java.sql.SQLException;

public interface HotelDAO extends CrudDAO<Hotel> {
    boolean updateStatus(String hotelId) throws SQLException, ClassNotFoundException;
    boolean resetYes() throws SQLException, ClassNotFoundException;
    boolean resetYes(String hotelId) throws SQLException, ClassNotFoundException;
    /*boolean saveHotel(HotelDto dto) throws SQLException, ClassNotFoundException;
    boolean deleteHotel(String hotelId) throws SQLException, ClassNotFoundException;
    boolean updateHotel(HotelDto dto) throws SQLException, ClassNotFoundException;
    List<HotelDto> getAllHotels() throws SQLException, ClassNotFoundException;*/
}
