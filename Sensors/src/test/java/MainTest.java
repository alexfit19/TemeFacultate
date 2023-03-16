import org.junit.Assert;

import static org.junit.Assert.*;

class MainTest {
    @org.junit.jupiter.api.Test
    void main() {
        SensorCluster c = new SensorCluster();
        c.addSensor("1",SensorType.TEMP);
        c.addSensor("2",SensorType.PRES);
        c.addSensor("3",SensorType.HUM);

        assertEquals(null, c.addSensor("1", SensorType.TEMP));
        assertEquals(false,c.writeSensorReading("4",12,100));
        assertEquals(-90,new SensorReading(10,10).compareTo(new SensorReading(12,100)));

    }
}