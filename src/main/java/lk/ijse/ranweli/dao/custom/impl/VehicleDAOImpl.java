package lk.ijse.ranweli.dao.custom.impl;

import lk.ijse.ranweli.dao.SQLUtil;
import lk.ijse.ranweli.dao.custom.VehicleDAO;
import lk.ijse.ranweli.dto.VehicleDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDAOImpl implements VehicleDAO {
    @Override
    public boolean save(VehicleDto dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO vehicle VALUES(?,?,?,?)",dto.getVehicleId(),dto.getStatus(),dto.getNumberOfSeats(),dto.getEmpId());
    }
    @Override
    public boolean delete(String vehicleId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM vehicle WHERE vehicleId = ?",vehicleId);
    }

    @Override
    public boolean update(VehicleDto dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE vehicle SET status = ?, numberOfSeats = ?, empId = ? WHERE vehicleId = ?",dto.getStatus(),dto.getNumberOfSeats(),dto.getEmpId(),dto.getVehicleId());
    }

    @Override
    public ArrayList<VehicleDto> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle");
        ArrayList<VehicleDto> list = new ArrayList<>();
        while(rst.next()){
            list.add(new VehicleDto(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4)));
        }
        return list;
    }
    @Override
    public VehicleDto search(String vehicleId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle WHERE vehicleId = ?",vehicleId);
        if(rst.next()){
            return new VehicleDto(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4));
        }else{
            return null;
        }
    }
}
