package lk.ijse.ranweli.dao.custom.impl;

import lk.ijse.ranweli.dao.SQLUtil;
import lk.ijse.ranweli.dao.custom.VehicleDAO;
import lk.ijse.ranweli.entity.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDAOImpl implements VehicleDAO {
    @Override
    public boolean save(Vehicle entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO vehicle VALUES(?,?,?,?)",entity.getVehicleId(),entity.getStatus(),entity.getNumberOfSeats(),entity.getEmpId());
    }
    @Override
    public boolean delete(String vehicleId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM vehicle WHERE vehicleId = ?",vehicleId);
    }

    @Override
    public boolean update(Vehicle entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE vehicle SET status = ?, numberOfSeats = ?, empId = ? WHERE vehicleId = ?",entity.getStatus(),entity.getNumberOfSeats(),entity.getEmpId(),entity.getVehicleId());
    }

    @Override
    public ArrayList<Vehicle> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle");
        ArrayList<Vehicle> list = new ArrayList<>();
        while(rst.next()){
            list.add(new Vehicle(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4)));
        }
        return list;
    }
    @Override
    public Vehicle search(String vehicleId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle WHERE vehicleId = ?",vehicleId);
        if(rst.next()){
            return new Vehicle(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4));
        }else{
            return null;
        }
    }

    @Override
    public boolean updateStatus(String vehicleId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE vehicle SET status = 'NO' WHERE vehicleId = ?",vehicleId);
    }

    @Override
    public boolean resetYes() throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET status = 'YES' WHERE status = 'NO'");
    }

    @Override
    public boolean resetYes(String vehicleId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE vehicle SET status = 'YES' WHERE vehicleId = ?",vehicleId);
    }
}
