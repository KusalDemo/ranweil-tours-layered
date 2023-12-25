package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dto.HotelDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDAOImpl implements HotelDAO{
    @Override
    public boolean saveHotel(HotelDto dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO hotel VALUES(?,?,?,?)",dto.getHotelId(),dto.getHotelName(),dto.getHotelType(),dto.getStatus());
    }
    @Override
    public boolean deleteHotel(String hotelId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM hotel WHERE hotelId = ?",hotelId);
    }
    @Override
    public boolean updateHotel(HotelDto dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE hotel SET name = ?, type = ?, status = ? WHERE hotelId = ?",dto.getHotelName(),dto.getHotelType(),dto.getStatus(),dto.getHotelId());
    }
    @Override
    public List<HotelDto> getAllHotels() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM hotel");
        List<HotelDto> list = new ArrayList<>();
        while (rst.next()){
            list.add(new HotelDto(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)));
        }
        return list;
    }
}
