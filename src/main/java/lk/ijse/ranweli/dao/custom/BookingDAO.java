package lk.ijse.ranweli.dao.custom;

import java.sql.SQLException;

public interface BookingDAO {
    boolean save(String hotelId, String PackageId, String vehicleId) throws SQLException;

}
