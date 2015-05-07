package com.broadsoft.sipp.parser;


public class SipMessage implements Comparable<SipMessage> {
    @Override
    public int compareTo(SipMessage other) {
        return this.timeStamp.compareTo(other.timeStamp);
    }

    public enum Direction {
        FROM_ORIG,
        TO_TERM,
        FROM_TERM,
        TO_ORIG
    }


    private final TimeStamp timeStamp;
    private final String message;
    private final Direction direction;

    public SipMessage(TimeStamp timeStamp, String message, Direction direction) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return message;
    }
}
