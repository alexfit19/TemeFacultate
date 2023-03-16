class SensorReading implements Comparable<SensorReading>{
    double value;
    long dateAndTime;

    public SensorReading(double value, long dateAndTime) {
        this.value = value;
        this.dateAndTime = dateAndTime;
    }

    @Override
    public int compareTo(SensorReading o) {
        return (int)(dateAndTime - o.dateAndTime);
    }
}