package com.broadsoft.sipp.parser;

public class MscMessage {
    public enum Location {
        ORIG,
        XS,
        TERM
    }

    public enum Color {
        GREEN,
        RED
    }

    private final Location from;
    private final Location to;
    private final String message;
    private final Color color;


    private MscMessage(Location from, Location to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.color = Color.GREEN;
    }

    private MscMessage(Location from, Location to, String message, Color color) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder msc = new StringBuilder();
        msc.append(from.name());
        msc.append(" -[#");
        msc.append(color.name().toLowerCase());
        msc.append("]> ");
        msc.append(to.name());
        msc.append(" : ");
        msc.append(message);
        return msc.toString();
    }

    public static MscMessage from(SipMessage sipMessage) {
        Location to = null;
        Location from = null;
        switch(sipMessage.direction) {
            case FROM_ORIG:
                from = Location.ORIG;
                to = Location.XS;
                break;
            case TO_ORIG:
                from = Location.XS;
                to = Location.ORIG;
                break;
            case FROM_TERM:
                from = Location.TERM;
                to = Location.XS;
                break;
            case TO_TERM:
                from = Location.XS;
                to = Location.TERM;
                break;
        }
        // TODO : add color red for responses greater then 400
        return new MscMessage(from, to, sipMessage.toString());
    }
}
