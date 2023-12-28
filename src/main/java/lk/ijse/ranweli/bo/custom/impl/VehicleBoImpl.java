package lk.ijse.ranweli.bo.custom.impl;

import lk.ijse.ranweli.bo.custom.VehicleBo;
import lk.ijse.ranweli.dao.DAOFactory;
import lk.ijse.ranweli.dao.custom.VehicleDAO;
import lk.ijse.ranweli.dto.VehicleDto;
import lk.ijse.ranweli.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleBoImpl implements VehicleBo {
    VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.VEHICLE);
    @Override
    public boolean saveVehicle(VehicleDto dto) throws SQLException, ClassNotFoundException {
        /*return SQLUtil.execute("INSERT INTO vehicle VALUES(?,?,?,?)",dto.getVehicleId(),dto.getStatus(),dto.getNumberOfSeats(),dto.getEmpId());*/
        return vehicleDAO.save(new Vehicle(dto.getVehicleId(),dto.getStatus(),dto.getNumberOfSeats(),dto.getEmpId()));
    }
    @Override
    public boolean deleteVehicle(String vehicleId) throws SQLException, ClassNotFoundException {
        /*return SQLUtil.execute("DELETE FROM vehicle WHERE vehicleId = ?",vehicleId);*/
        return vehicleDAO.delete(vehicleId);
    }

    @Override
    public boolean updateVehicle(VehicleDto dto) throws SQLException, ClassNotFoundException {
        /*return SQLUtil.execute("UPDATE vehicle SET status = ?, numberOfSeats = ?, empId = ? WHERE vehicleId = ?",dto.getStatus(),dto.getNumberOfSeats(),dto.getEmpId(),dto.getVehicleId());*/
        return vehicleDAO.update(new Vehicle(dto.getVehicleId(),dto.getStatus(),dto.getNumberOfSeats(),dto.getEmpId()));
    }

    @Override
    public ArrayList<VehicleDto> getAllVehicles() throws SQLException, ClassNotFoundException {
        /*ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle");*/
        ArrayList<Vehicle> rst = vehicleDAO.getAll();
        ArrayList<VehicleDto> list = new ArrayList<>();
        for (Vehicle vehicle : rst) {
            list.add(new VehicleDto(vehicle.getVehicleId(),vehicle.getStatus(),vehicle.getNumberOfSeats(),vehicle.getEmpId()));
        }
        return list;
    }
    @Override
    public VehicleDto searchVehicle(String vehicleId) throws SQLException, ClassNotFoundException {
        /*ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle WHERE vehicleId = ?",vehicleId);*/
        Vehicle rst = vehicleDAO.search(vehicleId);
        if(rst != null){
            return new VehicleDto(rst.getVehicleId(),rst.getStatus(),rst.getNumberOfSeats(),rst.getEmpId());
        }
        return null;
    }
}
