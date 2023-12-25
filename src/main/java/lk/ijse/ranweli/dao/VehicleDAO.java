package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dto.VehicleDto;

import java.sql.SQLException;
import java.util.List;

public interface VehicleDAO {
    boolean saveVehicle(VehicleDto dto) throws SQLException, ClassNotFoundException;
    boolean deleteVehicle(String vehicleId) throws SQLException, ClassNotFoundException;
    boolean updateVehicle(VehicleDto dto) throws SQLException, ClassNotFoundException;
    List<VehicleDto> getAllVehicles() throws SQLException, ClassNotFoundException;

}
