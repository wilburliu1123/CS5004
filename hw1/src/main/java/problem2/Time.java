package problem2;
/**
 * Time is a simple object that has hour, minutes, and seconds.
 */
public class Time {
    private int hour;
    private int minutes;
    private int seconds;
    private static final int HOUR_MAX = 23;
    private static final int MIN = 0;
    private static final int MINUTES_MAX = 59;
    /**
     * Constructor that creates a new Time object with hour, minutes, and seconds.
     * hour will be between 0 and 23, minutes will be between 0 and 59, seconds will be between 0 and 59
     * Otherwise it will throw an Exception.
     * @param hour - current hour of this Time object.
     * @param minutes - current minutes of this Time object.
     * @param seconds - current seconds of this Time object.
     */
    public Time(int hour, int minutes, int seconds) throws Exception {
        if (hour < MIN || hour > HOUR_MAX) {
            throw new Exception("Wrong hour input, hour needs to between 0 and 23");
        } else if (minutes < MIN || minutes > MINUTES_MAX) {
            throw new Exception("Wrong minutes input, minutes needs to between 0 and 59");
        } else if (seconds < MIN || seconds > MINUTES_MAX) {
            throw new Exception("Wrong seconds input, seconds needs to between 0 and 59");
        }
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * return hour of this Time object
     * @return hour.
     * */

    public int getHour() {
        return hour;
    }
    /**
     * Change hour of this Time object. It will throw an Exception if the time's hour is out of 0-23 range.
     * */
    public void setHour(int hour) throws Exception {
        if (hour < MIN || hour > HOUR_MAX) {
            throw new Exception("Wrong hour input, hour needs to between 0 and 23");
        }
        this.hour = hour;
    }
    /**
     * return minutes of this Time object
     * @return minutes.
     * */
    public int getMinutes() {
        return minutes;
    }
    /**
     * Change minutes of this Time object. It will throw an Exception if the time's minutes is out of 0-59 range.
     * */
    public void setMinutes(int minutes) throws Exception {
        if (minutes < MIN || minutes > MINUTES_MAX) {
            throw new Exception("Wrong minutes input, minutes needs to between 0 and 59");
        }
        this.minutes = minutes;
    }
    /**
     * return seconds of this Time object
     * @return seconds.
     * */
    public int getSeconds() {
        return seconds;
    }
    /**
     * Change seconds of this Time object. It will throw an Exception if the time's seconds is out of 0-59 range.
     * */
    public void setSeconds(int seconds) throws Exception {
        if (seconds < MIN || seconds > MINUTES_MAX) {
            throw new Exception("Wrong seconds input, seconds needs to between 0 and 59");
        }
        this.seconds = seconds;
    }
    /**
     * Override the equals method inherited from Object class inorder to make comparison between two Time object
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hour == time.hour && minutes == time.minutes && seconds == time.seconds;
    }

}
