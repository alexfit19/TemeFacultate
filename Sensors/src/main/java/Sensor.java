import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Sensor implements Comparator<SensorReading> {
    ArrayList<SensorReading> readings = new ArrayList<>();
    String id;
    SensorType type;

    @Override
    public String toString() {
        return "Sensor{" +
                "readings=" + readings +
                ", id='" + id + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public int compare(SensorReading o1, SensorReading o2) {
        return (int) (o1.value - o2.value);
    }

    public Sensor(String id, SensorType type) {
        this.id = id;
        this.type = type;
    }

    public boolean addSensorReading(SensorReading reading){
        readings.add(reading);
        return true;
    }

    List<SensorReading> getSensorReadingSortedByValue(){
        double auxValue;
        for (SensorReading s : readings) {
            for (SensorReading s2 : readings) {
                if (compare(s,s2) < 0){
                    auxValue = s.value;
                    s.value = s2.value;
                    s2.value = auxValue;
                }
            }
        }
        return readings;
    }
    List<SensorReading> getSensorReadingSortedByDateAndTime(){
        long auxDT;
        for (SensorReading s : readings) {
            for (SensorReading s2 : readings) {
                if (s.compareTo(s2) < 0){
                    auxDT = s.dateAndTime;
                    s.dateAndTime = s2.dateAndTime;
                    s2.dateAndTime = auxDT;
                }
            }
        }
        return readings;
    }
}