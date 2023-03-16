package isp.lab8.carparkaccess;

import isp.lab8.carparkaccess.file.ParkingAccessFileControl;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CarParkingAccessApp {
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        ParkingAccessControl parkingAccessControl = new ParkingAccessControl();

        Car car1 = new Car("CJ-10-CIP", System.currentTimeMillis());
        Car car2 = new Car("CJ-02-CEV", System.currentTimeMillis());
        Car car3 = new Car("CJ-12-CCC", System.currentTimeMillis());
        Car car4 = new Car("CJ-10-CIP", System.currentTimeMillis());
        parkingAccessControl.carEntry(car1);
        parkingAccessControl.carEntry(car4);
        parkingAccessControl.carEntry(car2);
        parkingAccessControl.carEntry(car3);
        Car car10 = new Car("CJ-01-AAA", System.currentTimeMillis());
        parkingAccessControl.carExit("CJ-02-CCC");
        parkingAccessControl.carEntry(car10);

        Car car5 = new Car("CJ-02-DDD", System.currentTimeMillis());
        Car car6 = new Car("CJ-02-EEE", System.currentTimeMillis());
        parkingAccessControl.carEntry(car5);
        parkingAccessControl.carEntry(car6);
        Car car7 = new Car("CJ-02-FFF", System.currentTimeMillis());

        TimeUnit.SECONDS.sleep(3);
        parkingAccessControl.carEntry(car7);
        TimeUnit.SECONDS.sleep(4);
        parkingAccessControl.viewCurrentCars();
        parkingAccessControl.carExit("CJ-10-CIP");
        TimeUnit.SECONDS.sleep(3);
        parkingAccessControl.carExit("CJ-02-CEV");
        
        TimeUnit.SECONDS.sleep(3);
        parkingAccessControl.carEntry(car1);
        TimeUnit.SECONDS.sleep(5);
        parkingAccessControl.carExit("CJ-10-CIP");
        //parkingAccessControl.viewPastEntriesForCar("CJ-10-CIP");
        
        TimeUnit.SECONDS.sleep(3);
        parkingAccessControl.carEntry(car1);
        parkingAccessControl.carExit("CJ-02-CEV");
        
        TimeUnit.SECONDS.sleep(3);
        parkingAccessControl.carEntry(car1);
        TimeUnit.SECONDS.sleep(1);
        parkingAccessControl.carExit("CJ-10-CIP");

        parkingAccessControl.carEntry(car1);
        TimeUnit.SECONDS.sleep(3);
        parkingAccessControl.viewPastEntriesForCar("CJ-10-CIP");
        TimeUnit.SECONDS.sleep(3);
        parkingAccessControl.carEntry(car2);
        parkingAccessControl.viewPastEntriesForCar("CJ-02-CEV");
        parkingAccessControl.carExit("CJ-10-CIP");
        parkingAccessControl.carExit("CJ-02-CEV");
        TimeUnit.SECONDS.sleep(5);
        parkingAccessControl.carExit("CJ-02-CEP");
        parkingAccessControl.carExit("CJ-12-CCC");
        
        
        parkingAccessControl.carEntry(car6);
        TimeUnit.SECONDS.sleep(7);
        parkingAccessControl.carEntry(car7);
        TimeUnit.SECONDS.sleep(3);
        parkingAccessControl.carExit("CJ-02-FFF");
        TimeUnit.SECONDS.sleep(3);
        parkingAccessControl.carEntry(car7);
        TimeUnit.SECONDS.sleep(3);
        
        
        parkingAccessControl.carEntry(car10);
        TimeUnit.SECONDS.sleep(4);
        parkingAccessControl.viewPastEntriesForCar("CJ-02-FFF");
        parkingAccessControl.viewCurrentCars();

        parkingAccessControl.viewPastUniqueEntries();
    }
}
