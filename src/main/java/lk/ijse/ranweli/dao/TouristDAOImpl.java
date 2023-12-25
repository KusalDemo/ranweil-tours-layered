package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dto.TouristDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TouristDAOImpl implements TouristDAO {
    @Override
    public boolean saveTourist(TouristDto dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO tourist VALUES (?,?, AES_ENCRYPT(?, '43ad-8c7a-603b'),?)",dto.getIdentityDetails(),dto.getName(),dto.getPassword(),dto.getEmail());
    }
    @Override
    public TouristDto getTourist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT identityDetails,name, CONVERT(AES_DECRYPT(password,'43ad-8c7a-603b') USING utf8)AS decrypted_password FROM tourist WHERE identityDetails=?",id);
        TouristDto dto = new TouristDto();
            if(rs.next()){
                dto.setIdentityDetails(rs.getString("identityDetails"));
                dto.setName(rs.getString("name"));
                dto.setPassword(rs.getString("decrypted_password"));
                return dto;
            } else {
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
