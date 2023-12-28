package lk.ijse.ranweli.dao.custom;

import lk.ijse.ranweli.dao.CrudDAO;
import lk.ijse.ranweli.entity.Vehicle;

import java.sql.SQLException;

public interface VehicleDAO extends CrudDAO<Vehicle> {
    boolean updateStatus(String vehicleId) throws SQLException, ClassNotFoundException;
    boolean resetYes() throws SQLException, ClassNotFoundException;

    boolean resetYes(String vehicleId) throws SQLException, ClassNotFoundException;
    /*boolean saveVehicle(VehicleDto dto) throws SQLException, ClassNotFoundException;
    boolean deleteVehicle(String vehicleId) throws SQLException, ClassNotFoundException;
    boolean updateVehicle(VehicleDto dto) throws SQLException, ClassNotFoundException;
    List<VehicleDto> getAllVehicles() throws SQLException, ClassNotFoundException;*/

}
