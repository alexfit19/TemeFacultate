import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum SensorType{
    TEMP, PRES, HUM;
}

public class Main{

    public static void main(String[] args) {
        SensorCluster c = new SensorCluster();
        c.addSensor("1",SensorType.TEMP);
        c.addSensor("2",SensorType.PRES);
        c.addSensor("3",SensorType.HUM);

        c.writeSensorReading("1",8,9);
        c.writeSensorReading("1",1,91);
        c.writeSensorReading("1",7,92);
        c.writeSensorReading("1",5,93);
        c.writeSensorReading("1",2,19);
        c.writeSensorReading("2", 10,100);
        c.writeSensorReading("2",7,90);
        c.writeSensorReading("2", 5,80);
        c.writeSensorReading("3", 10,100);
        c.writeSensorReading("3",7,90);
        c.writeSensorReading("3", 5,80);

//        Sensor s1 = c.getSensorById("1");
//        List<SensorReading> rez = s1.getSensorReadingSortedByValue();
//        rez.stream().forEach(s -> System.out.println(s.value));
//        //////////
//        List<SensorReading> rez2 = s1.getSensorReadingSortedByDateAndTime();
//        rez2.stream().forEach(s -> System.out.println(s.dateAndTime));

//        Sensor s2 = c.getSensorById("2");
//        List<SensorReading> rez3 = s2.getSensorReadingSortedByValue();
//        rez3.stream().forEach(s -> System.out.println(s.value));
//        //////////
//        List<SensorReading> rez4 = s2.getSensorReadingSortedByDateAndTime();
//        rez4.stream().forEach(s -> System.out.println(s.dateAndTime));
//
//        Sensor s3 = c.getSensorById("3");
//        List<SensorReading> rez5 = s3.getSensorReadingSortedByValue();
//        rez5.stream().forEach(s -> System.out.println(s.value));
//        //////////
//        List<SensorReading> rez6 = s3.getSensorReadingSortedByDateAndTime();
//        rez6.stream().forEach(s -> System.out.println(s.dateAndTime));

    }
}