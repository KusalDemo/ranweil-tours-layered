package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dto.HotelDto;

import java.sql.SQLException;
import java.util.List;

public interface HotelDAO {
    boolean saveHotel(HotelDto dto) throws SQLException, ClassNotFoundException;
    boolean deleteHotel(String hotelId) throws SQLException, ClassNotFoundException;
    boolean updateHotel(HotelDto dto) throws SQLException, ClassNotFoundException;
    List<HotelDto> getAllHotels() throws SQLException, ClassNotFoundException;
}
