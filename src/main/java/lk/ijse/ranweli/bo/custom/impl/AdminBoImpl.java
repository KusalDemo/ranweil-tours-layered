package lk.ijse.ranweli.bo.custom.impl;

import lk.ijse.ranweli.bo.custom.AdminBo;
import lk.ijse.ranweli.dao.DAOFactory;
import lk.ijse.ranweli.dao.custom.AdminDAO;
import lk.ijse.ranweli.dto.AdminDto;
import lk.ijse.ranweli.entity.Admin;

import java.sql.SQLException;

public class AdminBoImpl implements AdminBo {

    AdminDAO adminDAO= (AdminDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ADMIN);
    @Override
    public AdminDto searchAdmin(String email) throws SQLException, ClassNotFoundException {
        Admin admin   = adminDAO.search(email);
        if(admin != null){
            return new AdminDto(admin.getEmail(),admin.getUserName(),admin.getPassword(),"Admin");
        }return null;
    }
    @Override
    public  boolean saveAdmin(AdminDto admin) throws SQLException, ClassNotFoundException {
        return adminDAO.save(new Admin(admin.getEmail(),admin.getUserName(),admin.getPassword(),"Admin"));

    }
}
