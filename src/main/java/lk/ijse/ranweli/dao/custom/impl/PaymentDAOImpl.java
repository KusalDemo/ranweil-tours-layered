package lk.ijse.ranweli.dao.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.ranweli.dao.SQLUtil;
import lk.ijse.ranweli.dao.custom.PaymentDAO;
import lk.ijse.ranweli.entity.Payment;

import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean save(Payment payment) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO payment VALUES(?,?,?,?,?,?)",payment.getPayId(),payment.getAmount(),payment.getStatus(),Date.valueOf(payment.getDate()),payment.getMethod(),payment.getReceipt());
    }

    @Override
    public boolean update(Payment entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Payment search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
    /*@Override
    public boolean update(String vehicleId,String hotelId,String guideId,String driverId) throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();
        try{
            int isVehicleUpdated = SQLUtil.execute("UPDATE vehicle SET status = 'NO' WHERE vehicleId = ?",vehicleId);

            int isHotelUpdated =SQLUtil.execute("UPDATE hotel SET status = 'NO' WHERE hotelId = ?",hotelId);

            int isGuideUpdated =SQLUtil.execute("UPDATE employee SET availability = 'NO' WHERE empId = ?",guideId);

            int isDriverUpdated =SQLUtil.execute("UPDATE employee SET availability = 'NO' WHERE empId = ?",driverId);

            if((isVehicleUpdated>0) &&(isHotelUpdated>0) &&(isGuideUpdated>0) &&(isDriverUpdated>0)){
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
    }*/
    /*@Override
    public boolean resetAvailability() throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();
        try{
            int isVehicleUpdated =SQLUtil.execute("UPDATE employee SET status = 'YES' WHERE status = 'NO'");

            int isHotelUpdated =SQLUtil.execute("UPDATE hotel SET status = 'YES' WHERE status = 'NO'");

            int isEmployeeUpdated =SQLUtil.execute("UPDATE employee SET availability = 'YES' WHERE availability = 'NO'");

            if((isVehicleUpdated>0) &&(isHotelUpdated>0) &&(isEmployeeUpdated>0)){
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
    }*/
    /*@Override
    public boolean resetAvailability(String vehicleId,String hotelId,String guideId,String driverId) throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();
        try{
            int isVehicleUpdated =SQLUtil.execute("UPDATE vehicle SET status = 'YES' WHERE vehicleId = ?",vehicleId);

            int isHotelUpdated =SQLUtil.execute("UPDATE hotel SET status = 'YES' WHERE hotelId = ?",hotelId);

            int isGuideUpdated =SQLUtil.execute("UPDATE employee SET availability = 'YES' WHERE empId = ?",guideId);

            int isDriverUpdated =SQLUtil.execute("UPDATE employee SET availability = 'YES' WHERE empId = ?",driverId);

            if((isVehicleUpdated>0) &&(isHotelUpdated>0) &&(isGuideUpdated>0) &&(isDriverUpdated>0)){
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
    }*/
    @Override
    public ArrayList<Payment> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM payment");
        ArrayList<Payment> payments = new ArrayList<>();

        while(resultSet.next()){
            payments.add(new Payment(
                    resultSet.getString(1),
                    resultSet.getDouble(2),
                    resultSet.getString(3),
                    resultSet.getDate(4).toLocalDate(),
                    resultSet.getString(5),
                    resultSet.getBytes(6)
            ));
        }return payments;
    }
    @Override
    public Image getReceipt(String payId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT receipt FROM payment WHERE payId = ?", payId);
        if (resultSet.next()) {
            Blob blob = resultSet.getBlob("receipt");
            return new Image(blob.getBinaryStream());
        }else{
            return null;
        }
    }

}
