package lk.ijse.ranweli.bo;

import lk.ijse.ranweli.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}

    public static BOFactory getBoFactory(){
        return boFactory ==null ? boFactory = new BOFactory(): boFactory;
    }
    public enum BOType{
        EMPLOYEE, HOTEL, VEHICLE, PAYMENT, ADMIN, PACKAGE ,TOURIST,REPORT
    }
    public SuperBO getBO(BOType boType){
        switch (boType){
            case EMPLOYEE:
                return new EmployeeBoImpl();
            case HOTEL:
                return new HotelBoImpl();
            case VEHICLE:
                return new VehicleBoImpl();
            case PAYMENT:
                return new PaymentBoImpl();
            case ADMIN:
                return new AdminBoImpl();
            case PACKAGE:
                return new PackageBoImpl();
            case TOURIST:
                return new TouristBoImpl();
            case REPORT:
                return new ReportBOImpl();
            default:
                return null;
        }
    }

}
