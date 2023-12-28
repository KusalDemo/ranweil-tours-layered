package lk.ijse.ranweli.bo.custom.impl;

import lk.ijse.ranweli.bo.custom.PackageBo;
import lk.ijse.ranweli.dao.DAOFactory;
import lk.ijse.ranweli.dao.custom.PackageDAO;
import lk.ijse.ranweli.dto.PackageDto;
import lk.ijse.ranweli.entity.Package;

import java.sql.SQLException;
import java.util.ArrayList;

public class PackageBoImpl implements PackageBo {
    PackageDAO packageDAO = (PackageDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PACKAGE);
    @Override
    public boolean savePackage(PackageDto dto) throws SQLException, ClassNotFoundException {
        /*return SQLUtil.execute("INSERT INTO package VALUES(?,?,?,?)",dto.getPackageId(),dto.getPackageName(),dto.getDescription(),dto.getPrice());*/
        return packageDAO.save(new Package(dto.getPackageId(), dto.getPackageName(), dto.getDescription(),dto.getPrice()));
    }
    @Override
    public boolean deletePackage(String packageId) throws SQLException, ClassNotFoundException {
       /* return SQLUtil.execute("DELETE FROM package WHERE packageId = ?",packageId);*/
        return packageDAO.delete(packageId);
    }
    @Override
    public boolean updatePackage(PackageDto dto) throws SQLException, ClassNotFoundException {
        /*return SQLUtil.execute("UPDATE package SET name = ?, description = ?, price = ? WHERE packageId = ?",dto.getPackageName(),dto.getDescription(),dto.getPrice(),dto.getPackageId());*/
        return packageDAO.update(new Package(dto.getPackageId(),dto.getPackageName(),dto.getDescription(),dto.getPrice()));
    }
    @Override
    public ArrayList<PackageDto> getAllPackages() throws SQLException, ClassNotFoundException {
        /*ResultSet rst = SQLUtil.execute("SELECT * FROM package");*/
        ArrayList<Package> rst = packageDAO.getAll();
        ArrayList<PackageDto> list = new ArrayList<>();
        for (Package package1 : rst) {
            list.add(new PackageDto(package1.getPackageId(),package1.getPackageName(),package1.getDescription(),package1.getPrice()));
        }
        return list;
    }
    @Override
    public PackageDto searchPackage(String packageId) throws SQLException, ClassNotFoundException {
       /* ResultSet rst = SQLUtil.execute("SELECT * FROM package WHERE packageId = ?",packageId);*/
        Package rst = packageDAO.search(packageId);
        if(rst != null){
            return new PackageDto(rst.getPackageId(),rst.getPackageName(),rst.getDescription(),rst.getPrice());
        }
        return null;
    }
}
