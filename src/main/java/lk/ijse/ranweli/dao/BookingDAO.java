package lk.ijse.ranweli.dao;

import java.sql.SQLException;

public interface BookingDAO {
    boolean saveBooking(String hotelId, String PackageId, String vehicleId) throws SQLException;

}
