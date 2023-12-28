package lk.ijse.ranweli.bo.custom;

import lk.ijse.ranweli.bo.SuperBO;
import lk.ijse.ranweli.dto.HotelDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface HotelBo extends SuperBO {

    boolean saveHotel(HotelDto hotel) throws SQLException, ClassNotFoundException;

    boolean deleteHotel(String hotelId) throws SQLException, ClassNotFoundException;

    boolean updateHotel(HotelDto hotel) throws SQLException, ClassNotFoundException;

    ArrayList<HotelDto> getAllHotels() throws SQLException, ClassNotFoundException;
}
