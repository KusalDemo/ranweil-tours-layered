package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dto.PackageDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PackageDAOImpl implements PackageDAO {
    public boolean savePackage(PackageDto dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO package VALUES(?,?,?,?)",dto.getPackageId(),dto.getPackageName(),dto.getDescription(),dto.getPrice());
    }

    public boolean deletePackage(String packageId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM package WHERE packageId = ?",packageId);
    }
    public boolean updatePackage(PackageDto dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE package SET name = ?, description = ?, price = ? WHERE packageId = ?",dto.getPackageName(),dto.getDescription(),dto.getPrice(),dto.getPackageId());
    }
    public List<PackageDto> getAllPackages() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM package");
        List<PackageDto> list = new ArrayList<>();
        while(rst.next()){
            PackageDto dto = new PackageDto();
            dto.setPackageId(rst.getString("packageId"));
            dto.setPackageName(rst.getString("name"));
            dto.setDescription(rst.getString("description"));
            dto.setPrice(rst.getDouble("price"));
            list.add(dto);
        }
        return list;
    }
    public PackageDto searchPackage(String packageId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM package WHERE packageId = ?",packageId);
        if(rst.next()){
            PackageDto dto = new PackageDto();
            dto.setPackageId(rst.getString("packageId"));
            dto.setPackageName(rst.getString("name"));
            dto.setDescription(rst.getString("description"));
            dto.setPrice(Double.parseDouble(rst.getString("price")));
            return dto;
        }
        return null;
    }
}
