package lk.ijse.ranweli.dao;

import lk.ijse.ranweli.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        return daoFactory==null ? daoFactory=new DAOFactory():daoFactory;
    }
    public enum DAOTypes{
        ADMIN,EMPLOYEE,VEHICLE,HOTEL,TOURIST,PACKAGE,PAYMENT
    }
    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case ADMIN:
                return new AdminDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case VEHICLE:
                return new VehicleDAOImpl();
            case HOTEL:
                return new HotelDAOImpl();
            case TOURIST:
                return new TouristDAOImpl();
            case PACKAGE:
                return new PackageDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            default:
                return null;
        }
    }
}
