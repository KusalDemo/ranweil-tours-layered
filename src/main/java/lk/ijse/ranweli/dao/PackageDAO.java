package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dto.PackageDto;

import java.sql.SQLException;
import java.util.List;

public interface PackageDAO {
    boolean savePackage(PackageDto dto) throws SQLException;
    boolean deletePackage(String packageId) throws SQLException;
    boolean updatePackage(PackageDto dto) throws SQLException;
    List<PackageDto> getAllPackages() throws SQLException;

}
