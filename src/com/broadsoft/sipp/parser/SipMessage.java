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


    final TimeStamp timeStamp;
    final String message;
    final Direction direction;

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
