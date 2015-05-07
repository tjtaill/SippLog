package com.broadsoft.sipp.parser;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.PriorityQueue;

public class SippLogMscPrinter {
    public static void main(String[] args) throws IOException {
        // ignore standard error
        System.err.close();

        PriorityQueue<SipMessage> messages = new PriorityQueue<>();

        parseSippLog(args[0], SippLogMscListener.ListenerType.ORIG, messages);
        parseSippLog(args[1], SippLogMscListener.ListenerType.TERM, messages);

        System.out.println("@startuml");
        System.out.println("participant ORIG");
        System.out.println("participant XS");
        System.out.println("participant TERM");
        for ( SipMessage msg : messages ) {
            MscMessage msc = MscMessage.from(msg);
            System.out.println( msc );
        }
        System.out.println("@enduml");
    }

    private static void parseSippLog(String filePath, SippLogMscListener.ListenerType type,
                                     PriorityQueue<SipMessage> messages) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream( new FileInputStream( new File(filePath) ) );

        SippLogLexer lexer = new SippLogLexer( input );

        CommonTokenStream tokens = new CommonTokenStream( lexer );

        SippLogParser parser = new SippLogParser( tokens );

        ParseTree tree = parser.sippLog();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new SippLogMscListener(messages,  type), tree);
    }
}
