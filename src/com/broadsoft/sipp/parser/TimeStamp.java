package com.broadsoft.sipp.parser;

public class TimeStamp implements Comparable<TimeStamp> {
    private final int minutes;
    private final int seconds;
    private final int millis;
    private final int nanos;

    public TimeStamp(int minutes, int seconds, int millis, int nanos) {
        this.minutes = minutes;
        this.seconds = seconds;
        this.millis = millis;
        this.nanos = nanos;
    }

    @Override
    public int compareTo(TimeStamp other) {
        int compareMinutes = Integer.signum( this.minutes - other.minutes );

        if ( compareMinutes != 0 ) return compareMinutes;

        int compareSeconds = Integer.signum( this.seconds - other.seconds );
        if ( compareSeconds != 0 ) return compareSeconds;

        int compareMillis = Integer.signum( this.millis - other.millis );
        if ( compareMillis != 0 ) return compareMillis;

        int compareNanos = Integer.signum( this.nanos - other.nanos );
        return compareNanos;
    }

}
