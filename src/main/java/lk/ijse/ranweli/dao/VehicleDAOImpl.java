package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dto.VehicleDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl implements VehicleDAO {
    @Override
    public boolean saveVehicle(VehicleDto dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO vehicle VALUES(?,?,?,?)",dto.getVehicleId(),dto.getStatus(),dto.getNumberOfSeats(),dto.getEmpId());
    }
    @Override
    public boolean deleteVehicle(String vehicleId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM vehicle WHERE vehicleId = ?",vehicleId);
    }
    @Override
    public boolean updateVehicle(VehicleDto dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE vehicle SET status = ?, numberOfSeats = ?, empId = ? WHERE vehicleId = ?",dto.getStatus(),dto.getNumberOfSeats(),dto.getEmpId(),dto.getVehicleId());
    }
    @Override
    public List<VehicleDto> getAllVehicles() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle");
        List<VehicleDto> list = new ArrayList<>();
        while(rst.next()){
            list.add(new VehicleDto(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4)));
        }
        return list;
    }

    public static VehicleDto getVehicle(String vehicleId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle WHERE vehicleId = ?",vehicleId);
        if(rst.next()){
            return new VehicleDto(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4));
        }else{
            return null;
        }
    }
}
