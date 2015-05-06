package com.broadsoft.sipp.parser;


import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileInputStream;

public class SippLogMessagePrinter  {
    public static void main(String[] args) throws Exception {
        // ignore standard error
        System.err.close();

        ANTLRInputStream input = new ANTLRInputStream( new FileInputStream( new File( args[0] ) ) );

        SippLogLexer lexer = new SippLogLexer( input );

        CommonTokenStream tokens = new CommonTokenStream( lexer );

        SippLogParser parser = new SippLogParser( tokens );

        ParseTree tree = parser.sippLog();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new SippMessagePrinter(), tree);
    }
}
