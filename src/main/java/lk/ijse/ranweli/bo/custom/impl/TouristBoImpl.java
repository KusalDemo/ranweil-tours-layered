package lk.ijse.ranweli.bo.custom.impl;

import lk.ijse.ranweli.bo.custom.TouristBo;
import lk.ijse.ranweli.dao.DAOFactory;
import lk.ijse.ranweli.dao.custom.TouristDAO;
import lk.ijse.ranweli.dto.TouristDto;
import lk.ijse.ranweli.entity.Tourist;

import java.sql.SQLException;

public class TouristBoImpl implements TouristBo {
    TouristDAO touristDAO = (TouristDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TOURIST);

    @Override
    public boolean saveTourist(TouristDto tourist) throws SQLException, ClassNotFoundException {
        /*return SQLUtil.execute("INSERT INTO tourist VALUES (?,?, AES_ENCRYPT(?, '43ad-8c7a-603b'),?)",tourist.getIdentityDetails(),tourist.getName(),tourist.getPassword(),tourist.getEmail());*/
        return touristDAO.save(new Tourist(tourist.getIdentityDetails(),tourist.getName(),tourist.getPassword(),tourist.getEmail()));
    }

    @Override
    public TouristDto searchTourist(String id) throws SQLException, ClassNotFoundException {
        /*ResultSet rs = SQLUtil.execute("SELECT identityDetails,name, CONVERT(AES_DECRYPT(password,'43ad-8c7a-603b') USING utf8)AS decrypted_password FROM tourist WHERE identityDetails=?",id);*/
        Tourist rs = touristDAO.search(id);
        if (rs != null) {
            return new TouristDto(rs.getIdentityDetails(), rs.getName(), rs.getPassword(), rs.getEmail());
        }
        return null;
    }
    @Override
    public String getTouristEmailFromId(String id) throws SQLException, ClassNotFoundException {
        /*ResultSet rs = SQLUtil.execute("SELECT email FROM tourist WHERE identityDetails=?",id);*/
        Tourist rs = touristDAO.search(id);
        return rs.getEmail();
    }
    @Override
    public boolean changePassword(String id, String password) throws SQLException, ClassNotFoundException {
        /*return SQLUtil.execute("UPDATE tourist SET password=AES_ENCRYPT(?, '43ad-8c7a-603b') WHERE identityDetails=?",password,id);*/
        return touristDAO.changePassword(id,password);
    }

}
