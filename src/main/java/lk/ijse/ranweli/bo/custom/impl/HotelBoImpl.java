package lk.ijse.ranweli.bo.custom.impl;

import lk.ijse.ranweli.bo.custom.HotelBo;
import lk.ijse.ranweli.dao.DAOFactory;
import lk.ijse.ranweli.dao.custom.HotelDAO;
import lk.ijse.ranweli.dto.HotelDto;
import lk.ijse.ranweli.entity.Hotel;

import java.sql.SQLException;
import java.util.ArrayList;

public class HotelBoImpl implements HotelBo {
    HotelDAO hotelDAO = (HotelDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.HOTEL);
    @Override
    public boolean saveHotel(HotelDto hotel) throws SQLException, ClassNotFoundException {
        /*return SQLUtil.execute("INSERT INTO hotel VALUES(?,?,?,?)",hotel.getHotelId(),hotel.getHotelName(),hotel.getHotelType(),hotel.getStatus());*/
        return hotelDAO.save(new Hotel(hotel.getHotelId(),hotel.getHotelName(),hotel.getHotelType(),hotel.getStatus()));
    }
    @Override
    public boolean deleteHotel(String hotelId) throws SQLException, ClassNotFoundException {
        /*return SQLUtil.execute("DELETE FROM hotel WHERE hotelId = ?",hotelId);*/
        return hotelDAO.delete(hotelId);
    }

    @Override
    public boolean updateHotel(HotelDto hotel) throws SQLException, ClassNotFoundException {
        /*return SQLUtil.execute("UPDATE hotel SET name = ?, type = ?, status = ? WHERE hotelId = ?",hotel.getHotelName(),hotel.getHotelType(),hotel.getStatus(),hotel.getHotelId());*/
        return hotelDAO.update(new Hotel(hotel.getHotelId(),hotel.getHotelName(),hotel.getHotelType(),hotel.getStatus()));
    }

    @Override
    public ArrayList<HotelDto> getAllHotels() throws SQLException, ClassNotFoundException {
        /*ResultSet rst = SQLUtil.execute("SELECT * FROM hotel");*/
        ArrayList<Hotel> rst = hotelDAO.getAll();
        ArrayList<HotelDto> list = new ArrayList<>();
        for (Hotel hotel : rst) {
            list.add(new HotelDto(hotel.getHotelId(),hotel.getHotelName(),hotel.getHotelType(),hotel.getStatus()));
        }
        return list;
    }
}
