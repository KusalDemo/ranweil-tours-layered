package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dto.PackageDto;

import java.sql.SQLException;
import java.util.List;

public interface PackageDAO {
    boolean savePackage(PackageDto dto) throws SQLException, ClassNotFoundException;
    boolean deletePackage(String packageId) throws SQLException, ClassNotFoundException;
    boolean updatePackage(PackageDto dto) throws SQLException, ClassNotFoundException;
    List<PackageDto> getAllPackages() throws SQLException, ClassNotFoundException;

}
