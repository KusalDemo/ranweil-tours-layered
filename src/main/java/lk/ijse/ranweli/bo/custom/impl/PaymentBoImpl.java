package lk.ijse.ranweli.bo.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.ranweli.bo.custom.PaymentBo;
import lk.ijse.ranweli.dao.DAOFactory;
import lk.ijse.ranweli.dao.custom.EmployeeDAO;
import lk.ijse.ranweli.dao.custom.HotelDAO;
import lk.ijse.ranweli.dao.custom.PaymentDAO;
import lk.ijse.ranweli.dao.custom.VehicleDAO;
import lk.ijse.ranweli.db.DbConnection;
import lk.ijse.ranweli.dto.PaymentDto;
import lk.ijse.ranweli.entity.Payment;

import java.sql.*;
import java.util.ArrayList;

public class PaymentBoImpl implements PaymentBo {
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENT);
    VehicleDAO vehicleDAOImpl = (VehicleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.VEHICLE);
    HotelDAO hotelDAOImpl = (HotelDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.HOTEL);
    EmployeeDAO employeeDAOImpl = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public boolean savePayment(PaymentDto payment) throws SQLException, ClassNotFoundException {
        /*return SQLUtil.execute("INSERT INTO payment VALUES(?,?,?,?,?,?)",payment.getPayId(),payment.getAmount(),payment.getStatus(),Date.valueOf(payment.getDate()),payment.getMethod(),payment.getReceipt());*/
        return paymentDAO.save(new Payment(payment.getPayId(),payment.getAmount(),payment.getStatus(), Date.valueOf(payment.getDate()).toLocalDate(),payment.getMethod(),payment.getReceipt()));

    }
    @Override
    public boolean update(String vehicleId,String hotelId,String guideId,String driverId) throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();
        try{
            connection.setAutoCommit(false);
            boolean isVehicleUpdated = vehicleDAOImpl.updateStatus(vehicleId);
            boolean isHotelUpdated =hotelDAOImpl.updateStatus(hotelId);
            boolean isGuideUpdated =employeeDAOImpl.updateStatus(guideId);
            boolean isDriverUpdated =employeeDAOImpl.updateStatus(driverId);

            if((isVehicleUpdated) &&(isHotelUpdated) &&(isGuideUpdated) &&(isDriverUpdated)){
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
    @Override
    public boolean resetAvailability() throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();
        try{
            connection.setAutoCommit(false);
            boolean isVehicleUpdated = vehicleDAOImpl.resetYes();
            boolean isHotelUpdated = hotelDAOImpl.resetYes();
            boolean isEmployeeUpdated =employeeDAOImpl.resetYes();

            if((isVehicleUpdated) &&(isHotelUpdated) &&(isEmployeeUpdated)){
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
    @Override
    public boolean resetAvailability(String vehicleId,String hotelId,String guideId,String driverId) throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();
        try{
            connection.setAutoCommit(false);
            boolean isVehicleUpdated =vehicleDAOImpl.resetYes(vehicleId);
            boolean isHotelUpdated =hotelDAOImpl.resetYes(hotelId);
            boolean isGuideUpdated =employeeDAOImpl.resetYes(guideId);
            boolean isDriverUpdated =employeeDAOImpl.resetYes(driverId);

            if((isVehicleUpdated) &&(isHotelUpdated) &&(isGuideUpdated) &&(isDriverUpdated)){
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
    @Override
    public ArrayList<PaymentDto> getAllPayments() throws SQLException, ClassNotFoundException {
        /*ResultSet resultSet = SQLUtil.execute("SELECT * FROM payment");*/
        ArrayList<Payment> resultSet = paymentDAO.getAll();
        ArrayList<PaymentDto> payments = new ArrayList<>();
        for (Payment payment : resultSet) {
            payments.add(new PaymentDto(payment.getPayId(),payment.getAmount(),payment.getStatus(),payment.getDate(),payment.getMethod(),payment.getReceipt()));
        }
        return payments;
    }
    @Override
    public Image getReceipt(String payId) throws SQLException, ClassNotFoundException {
        Image image = paymentDAO.getReceipt(payId);
        if (image != null) {
            return image;
        } else {
            return null;
        }
    }

}
