package problem2;
/**
 * Trip is a simple object that has a start location, end location, start time, end time and ability to calculate
 * duration of this trip.
 */
public class Trip {
    private String startLocation;
    private String endLocation;
    private Time startTime;
    private Time endTime;
    /**
     * Constructor that creates a new Trip object with start location, end location, start time, end time.
     * @param startLocation - start location of this trip.
     * @param endLocation - end location of this trip.
     * @param startTime - start time of this trip.
     * @param endTime - end time of this trip.
     */
    public Trip(String startLocation, String endLocation, Time startTime, Time endTime) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    /**
     * return start location of this trip object
     * @return start location.
     * */
    public String getStartLocation() {
        return startLocation;
    }
    /**
     * change start location of this trip object.
     * @param startLocation was modified in this method.
     * */
    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }
    /**
     * return end location of this trip object
     * @return end location.
     * */
    public String getEndLocation() {
        return endLocation;
    }
    /**
     * change end location of this trip object.
     * @param endLocation was modified in this method.
     * */
    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }
    /**
     * return start time of this trip object.
     * @return a new Time object that represent start time.
     * */
    public Time getStartTime() throws Exception {
        Time copy = new Time(startTime.getHour(), startTime.getMinutes(), startTime.getSeconds());
        return copy;
    }
    /**
     * change start time of this trip object.
     * @param //startTime was changed in this method
     * */
    public void setStartTime(int hour, int minutes, int seconds) throws Exception {
        this.startTime = new Time(hour, minutes, seconds);
    }
    /**
     * return end time of this trip object
     * @return end time.
     * */
    public Time getEndTime() {
        return endTime;
    }
    /**
     * change end time of this trip object.
     * @param //endTime was changed in this method
     * */
    public void setEndTime(int hour, int minutes, int second) throws Exception {
        this.endTime = new Time(hour, minutes, second);
    }
    /**
     * return the duration of this trip object
     * @return duration in a new Time object.
     * */
    public Time getDuration() throws Exception {
        if (endTime.getHour() < startTime.getHour()) {
            throw new Exception("End time is earlier than start Time!");
        }
        int hour = endTime.getHour() - startTime.getHour();
        int minutes = endTime.getMinutes() - startTime.getMinutes();
        if (minutes < 0) {
            hour--;
            minutes += 60;
        }
        int seconds = endTime.getSeconds() - startTime.getSeconds();
        if (seconds < 0) {
            minutes--;
            seconds += 60;
        }
        Time res = new Time(hour, minutes, seconds);
        return  res;
    }
}
