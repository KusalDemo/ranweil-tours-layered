package lk.ijse.ranweli.dao;

import javafx.scene.image.Image;
import lk.ijse.ranweli.dto.PaymentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentDAO {
    boolean savePayment(PaymentDto paymentDto) throws SQLException, ClassNotFoundException;
    ArrayList<PaymentDto> getAllPayments() throws SQLException, ClassNotFoundException;
    Image getReceipt(String payId) throws SQLException, ClassNotFoundException;

}
