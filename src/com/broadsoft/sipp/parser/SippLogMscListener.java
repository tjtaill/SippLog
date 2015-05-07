package com.broadsoft.sipp.parser;


import org.antlr.v4.runtime.misc.NotNull;

import java.util.PriorityQueue;

public class SippLogMscListener extends SippLogBaseListener {
    public enum ListenerType {
        ORIG,
        TERM
    }

    public enum Direction {
        SENT,
        RECEIVED
    }

    private final PriorityQueue<SipMessage> messages;
    private final ListenerType type;
    private String currentMessage;
    private TimeStamp currentTime;
    private Direction currentDirection;


    public SippLogMscListener(PriorityQueue<SipMessage> messages, ListenerType type) {
        this.messages = messages;
        this.type = type;
    }


    @Override
    public void enterTimeStamp(@NotNull SippLogParser.TimeStampContext ctx) {
        String time = ctx.TIME_STAMP().getText().split(" ")[2];
        String[] units = time.split(":");
        String[] fractions = units[3].split("\\.");
        currentTime = new TimeStamp(
                Integer.valueOf(units[1]), // minutes
                Integer.valueOf(units[2]), // seconds
                Integer.valueOf(fractions[0]), // millis
                Integer.valueOf(fractions[1].substring(0, fractions[1].length()-1)) // nanos strip trailing newline ?
                );
    }

    @Override
    public void enterDirectionLine(@NotNull SippLogParser.DirectionLineContext ctx) {
        currentDirection = ctx.DIRECTION_LINE().getText().contains("sent") ? Direction.SENT : Direction.RECEIVED;
    }

    @Override
    public void enterSipResponse(@NotNull SippLogParser.SipResponseContext ctx) {
        String response = ctx.responseLine().RESPONSE_LINE().getText().split(" ", 3)[1];
        enqueSipMessage( response );
    }

    private void enqueSipMessage(String msg) {
        SipMessage.Direction dir = computeDirection();

        SipMessage sipMessage = new SipMessage(currentTime, msg, dir);
        messages.add(sipMessage);
    }

    private SipMessage.Direction computeDirection() {
        SipMessage.Direction dir = null;
        switch(type) {
            case ORIG:
                switch(currentDirection) {
                    case SENT:
                        dir = SipMessage.Direction.FROM_ORIG;
                        break;
                    case RECEIVED:
                        dir = SipMessage.Direction.TO_ORIG;
                        break;
                }
                break;
            case TERM:
                switch(currentDirection) {
                    case SENT:
                        dir = SipMessage.Direction.FROM_TERM;
                        break;
                    case RECEIVED:
                        dir = SipMessage.Direction.TO_TERM;
                        break;
                }
                break;
        }
        return dir;
    }

    @Override
    public void enterSipRequest(@NotNull SippLogParser.SipRequestContext ctx) {
        String request = ctx.requestLine().REQUEST_LINE().getText().split(" ", 2)[0];
        enqueSipMessage( request );
    }
}
