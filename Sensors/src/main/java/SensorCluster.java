import java.util.ArrayList;

class SensorCluster{
    ArrayList<Sensor> sensors = new ArrayList<>();

    public Sensor addSensor(String id, SensorType type){
        for (Sensor s: sensors) {
            if(s.id == id){
                return null;
            }
        }
        Sensor s = new Sensor(id,type);
        sensors.add(s);
        return s;
    }

    public boolean writeSensorReading(String id, double value, long dateTime){
        boolean b = false;
        for(Sensor s: sensors){
            if(s.id.equals(id)){
                s.addSensorReading(new SensorReading(value,dateTime));
                b = true;
            }
        }
        return b;
    }

    public Sensor getSensorById(String id){
        System.out.println("\nDisplay by value:");
        sensors.stream().filter(s -> s.id==id).findFirst().get().getSensorReadingSortedByValue();
        for (SensorReading sensor : sensors.stream().filter(s -> s.id==id).findFirst().get().readings) {
            System.out.print(sensor.value+" ");
        }
        System.out.println("\nDisplay by date and time:");
        sensors.stream().filter(s -> s.id==id).findFirst().get().getSensorReadingSortedByDateAndTime();
        for (SensorReading sensor : sensors.stream().filter(s -> s.id==id).findFirst().get().readings) {
            System.out.print(sensor.dateAndTime+" ");
        }
        return sensors.stream().filter(s -> s.id==id).findFirst().get();
    }

}