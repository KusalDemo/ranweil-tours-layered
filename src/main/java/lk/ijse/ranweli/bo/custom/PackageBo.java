package lk.ijse.ranweli.bo.custom;

import lk.ijse.ranweli.bo.SuperBO;
import lk.ijse.ranweli.dto.PackageDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PackageBo extends SuperBO {

    boolean savePackage(PackageDto dto) throws SQLException, ClassNotFoundException;

    boolean deletePackage(String packageId) throws SQLException, ClassNotFoundException;

    boolean updatePackage(PackageDto dto) throws SQLException, ClassNotFoundException;

    ArrayList<PackageDto> getAllPackages() throws SQLException, ClassNotFoundException;

    PackageDto searchPackage(String packageId) throws SQLException, ClassNotFoundException;
}
