package lk.ijse.ranweli.bo.custom;

import lk.ijse.ranweli.bo.SuperBO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import java.sql.SQLException;
import java.util.HashMap;

public interface ReportBO extends SuperBO {
    JasperPrint employeeReport() throws JRException, SQLException;
    JasperPrint hotelReport() throws JRException, SQLException;
    JasperPrint vehicleReport() throws JRException, SQLException;
    JasperPrint paymentReceipt(HashMap hashMap) throws JRException, SQLException;
    JasperPrint paymentReport() throws JRException, SQLException;

}
