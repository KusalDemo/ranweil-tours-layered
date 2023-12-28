package lk.ijse.ranweli.bo.custom;

import lk.ijse.ranweli.bo.SuperBO;
import lk.ijse.ranweli.dto.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleBo extends SuperBO {


    boolean saveVehicle(VehicleDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteVehicle(String vehicleId) throws SQLException, ClassNotFoundException;

    boolean updateVehicle(VehicleDto dto) throws SQLException, ClassNotFoundException;

    ArrayList<VehicleDto> getAllVehicles() throws SQLException, ClassNotFoundException;

    VehicleDto searchVehicle(String vehicleId) throws SQLException, ClassNotFoundException;
}
