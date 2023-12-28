package lk.ijse.ranweli.dao.custom.impl;

import lk.ijse.ranweli.dao.SQLUtil;
import lk.ijse.ranweli.dao.custom.PackageDAO;
import lk.ijse.ranweli.entity.Package;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PackageDAOImpl implements PackageDAO {
    public boolean save(Package packageEntity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO package VALUES(?,?,?,?)",packageEntity.getPackageId(),packageEntity.getPackageName(),packageEntity.getDescription(),packageEntity.getPrice());
    }

    public boolean delete(String packageId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM package WHERE packageId = ?",packageId);
    }

    public boolean update(Package packageEntity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE package SET name = ?, description = ?, price = ? WHERE packageId = ?",packageEntity.getPackageName(),packageEntity.getDescription(),packageEntity.getPrice(),packageEntity.getPackageId());
    }

    public ArrayList<Package> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM package");
        ArrayList<Package> list = new ArrayList<>();
        while(rst.next()){
            Package dto = new Package();
            dto.setPackageId(rst.getString("packageId"));
            dto.setPackageName(rst.getString("name"));
            dto.setDescription(rst.getString("description"));
            dto.setPrice(rst.getDouble("price"));
            list.add(dto);
        }
        return list;
    }
    public Package search(String packageId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM package WHERE packageId = ?",packageId);
        if(rst.next()){
            Package packageEntity = new Package();
            packageEntity.setPackageId(rst.getString("packageId"));
            packageEntity.setPackageName(rst.getString("name"));
            packageEntity.setDescription(rst.getString("description"));
            packageEntity.setPrice(Double.parseDouble(rst.getString("price")));
            return packageEntity;
        }
        return null;
    }
}
