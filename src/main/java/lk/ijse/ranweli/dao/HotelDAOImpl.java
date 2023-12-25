package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dto.HotelDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HotelDAOImpl implements HotelDAO{
    @Override
    public boolean save(HotelDto dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO hotel VALUES(?,?,?,?)",dto.getHotelId(),dto.getHotelName(),dto.getHotelType(),dto.getStatus());
    }
    @Override
    public boolean delete(String hotelId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM hotel WHERE hotelId = ?",hotelId);
    }

    @Override
    public HotelDto search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(HotelDto dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE hotel SET name = ?, type = ?, status = ? WHERE hotelId = ?",dto.getHotelName(),dto.getHotelType(),dto.getStatus(),dto.getHotelId());
    }

    @Override
    public ArrayList<HotelDto> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM hotel");
        ArrayList<HotelDto> list = new ArrayList<>();
        while (rst.next()) {
            list.add(new HotelDto(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)));
        }
        return list;
    }
}
