package lk.ijse.ranweli.dao.custom;

import javafx.scene.image.Image;
import lk.ijse.ranweli.dao.CrudDAO;
import lk.ijse.ranweli.dto.PaymentDto;

import java.sql.SQLException;

public interface PaymentDAO extends CrudDAO<PaymentDto> {
    /*boolean savePayment(PaymentDto paymentDto) throws SQLException, ClassNotFoundException;
    ArrayList<PaymentDto> getAllPayments() throws SQLException, ClassNotFoundException;*/
    Image getReceipt(String payId) throws SQLException, ClassNotFoundException;
    boolean update(String vehicleId,String hotelId,String guideId,String driverId) throws SQLException;
    boolean resetAvailability() throws SQLException;
    boolean resetAvailability(String vehicleId,String hotelId,String guideId,String driverId) throws SQLException;

}
