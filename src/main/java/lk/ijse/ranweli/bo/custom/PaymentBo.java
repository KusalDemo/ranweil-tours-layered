package lk.ijse.ranweli.bo.custom;

import javafx.scene.image.Image;
import lk.ijse.ranweli.bo.SuperBO;
import lk.ijse.ranweli.dto.PaymentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentBo extends SuperBO {
    ArrayList<PaymentDto> getAllPayments() throws SQLException, ClassNotFoundException;

    Image getReceipt(String payId) throws SQLException, ClassNotFoundException;

    boolean savePayment(PaymentDto payment) throws SQLException, ClassNotFoundException;

    boolean update(String vehicleId, String hotelId, String guideId, String driverId) throws SQLException;
    boolean resetAvailability() throws SQLException;
    boolean resetAvailability(String vehicleId,String hotelId,String guideId,String driverId) throws SQLException;

}
