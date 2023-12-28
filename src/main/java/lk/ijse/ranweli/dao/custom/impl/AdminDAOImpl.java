package lk.ijse.ranweli.dao.custom.impl;

import lk.ijse.ranweli.dao.SQLUtil;
import lk.ijse.ranweli.dao.custom.AdminDAO;
import lk.ijse.ranweli.entity.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public Admin search(String email) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM admin WHERE email = ?", email);
        Admin admin=null;

        if(resultSet.next()){
            admin = new Admin(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );
        }
        return admin;

    }

    @Override
    public ArrayList<Admin> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public  boolean save(Admin admin) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO admin VALUES(?,?,?,?)",admin.getEmail(),admin.getUserName(),admin.getPassword(),admin.getType());

    }

    @Override
    public boolean update(Admin admin) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
