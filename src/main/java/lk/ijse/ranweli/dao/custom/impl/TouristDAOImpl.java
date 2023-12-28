package lk.ijse.ranweli.dao.custom.impl;

import lk.ijse.ranweli.dao.SQLUtil;
import lk.ijse.ranweli.dao.custom.TouristDAO;
import lk.ijse.ranweli.entity.Tourist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TouristDAOImpl implements TouristDAO {
    @Override
    public ArrayList<Tourist> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Tourist tourist) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO tourist VALUES (?,?, AES_ENCRYPT(?, '43ad-8c7a-603b'),?)",tourist.getIdentityDetails(),tourist.getName(),tourist.getPassword(),tourist.getEmail());
    }

    @Override
    public boolean update(Tourist tourist) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Tourist search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT identityDetails,name, CONVERT(AES_DECRYPT(password,'43ad-8c7a-603b') USING utf8)AS decrypted_password,email FROM tourist WHERE identityDetails=?",id);
        if(rs.next()){
            return new Tourist(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
        }else{
            return null;
        }
    }
    @Override
    public String getTouristEmailFromId(String id) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT email FROM tourist WHERE identityDetails=?",id);
        if(rs.next()){
            return rs.getString("email");
        }else{
            return null;
        }
    }
    @Override
    public boolean changePassword(String id, String password) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE tourist SET password=AES_ENCRYPT(?, '43ad-8c7a-603b') WHERE identityDetails=?",password,id);
    }

}
