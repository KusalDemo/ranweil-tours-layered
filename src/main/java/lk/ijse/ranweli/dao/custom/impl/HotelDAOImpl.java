package lk.ijse.ranweli.dao.custom.impl;

import lk.ijse.ranweli.dao.SQLUtil;
import lk.ijse.ranweli.dao.custom.HotelDAO;
import lk.ijse.ranweli.entity.Hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HotelDAOImpl implements HotelDAO {
    @Override
    public boolean save(Hotel hotel) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO hotel VALUES(?,?,?,?)",hotel.getHotelId(),hotel.getHotelName(),hotel.getHotelType(),hotel.getStatus());
    }
    @Override
    public boolean delete(String hotelId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM hotel WHERE hotelId = ?",hotelId);
    }

    @Override
    public Hotel search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Hotel hotel) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE hotel SET name = ?, type = ?, status = ? WHERE hotelId = ?",hotel.getHotelName(),hotel.getHotelType(),hotel.getStatus(),hotel.getHotelId());
    }

    @Override
    public ArrayList<Hotel> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM hotel");
        ArrayList<Hotel> list = new ArrayList<>();
        while (rst.next()) {
            list.add(new Hotel(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)));
        }
        return list;
    }

    @Override
    public boolean updateStatus(String hotelId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE hotel SET status = 'NO' WHERE hotelId = ?",hotelId);
    }

    @Override
    public boolean resetYes() throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE hotel SET status = 'YES' WHERE status = 'NO'");
    }

    @Override
    public boolean resetYes(String hotelId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE hotel SET status = 'YES' WHERE hotelId = ?",hotelId);
    }
}
