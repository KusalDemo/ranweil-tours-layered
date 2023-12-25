package lk.ijse.ranweli.dao.custom.impl;

import lk.ijse.ranweli.dao.SQLUtil;
import lk.ijse.ranweli.dao.custom.BookingDAO;
import lk.ijse.ranweli.db.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class BookingDAOImpl implements BookingDAO {
    @Override
    public boolean save(String hotelId, String PackageId, String vehicleId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        try{
            connection.setAutoCommit(false);

            int isHotelPackageDetailsSaved = SQLUtil.execute("INSERT INTO hotel_package_details VALUES(?,?,?)",hotelId,PackageId,java.sql.Date.valueOf(LocalDate.now()));

            int isVehiclePackageDetailsSaved = SQLUtil.execute("INSERT INTO vehicle_package_details VALUES(?,?)",vehicleId,PackageId);

            if((isHotelPackageDetailsSaved>0) &&( isVehiclePackageDetailsSaved>0)){
                connection.commit();
                return true;
            }else{
                connection.rollback();
                return false;
            }
        }catch (Exception e){
           e.printStackTrace();
           return  false;
        }finally {
            connection.setAutoCommit(true);
        }
    }
}
