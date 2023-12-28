package lk.ijse.ranweli.bo.custom.impl;

import lk.ijse.ranweli.bo.custom.ReportBO;
import lk.ijse.ranweli.db.DbConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportBOImpl implements ReportBO {
    @Override
    public JasperPrint employeeReport() throws JRException, SQLException {
        InputStream resourceAsStream = getClass().getResourceAsStream("/report/employeeReport.jrxml");
        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport,
                null,
                DbConnection.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint, false);
        return jasperPrint;
    }
    @Override
    public JasperPrint hotelReport() throws JRException, SQLException {
        InputStream resourceAsStream = getClass().getResourceAsStream("/report/hotelReport.jrxml");
        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport,
                null,
                DbConnection.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint, false);
        return jasperPrint;
    }
    @Override
    public JasperPrint vehicleReport() throws JRException, SQLException {
        InputStream resourceAsStream = getClass().getResourceAsStream("/report/vehicleReport.jrxml");
        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport,
                null,
                DbConnection.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint, false);
        return jasperPrint;
    }
    @Override
    public JasperPrint paymentReceipt(HashMap hashMap) throws JRException, SQLException {
        InputStream resourceAsStream = getClass().getResourceAsStream("/report/paymentReceipt.jrxml");
        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport,
                hashMap,
                new JREmptyDataSource()
        );
        JasperViewer.viewReport(jasperPrint, false);
        return jasperPrint;
    }
    @Override
    public JasperPrint paymentReport() throws JRException, SQLException {
        InputStream resourceAsStream = getClass().getResourceAsStream("/report/paymentReport.jrxml");
        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport,
                null,
                DbConnection.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint, false);
        return jasperPrint;
    }
}
