package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dto.HotelDto;

import java.sql.SQLException;
import java.util.List;

public interface HotelDAO {
    boolean saveHotel(HotelDto dto) throws SQLException;
    boolean deleteHotel(String hotelId) throws SQLException;
    boolean updateHotel(HotelDto dto) throws SQLException;
    List<HotelDto> getAllHotels() throws SQLException;
}
