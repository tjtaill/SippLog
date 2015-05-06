package com.broadsoft.sipp.parser;

import org.antlr.v4.runtime.misc.NotNull;

/**
 * Created by troy on 2015-05-05.
 */
public class SippMessagePrinter extends SippLogBaseListener {
    @Override
    public void exitSipResponse(@NotNull SippLogParser.SipResponseContext ctx) {
        System.out.println(ctx.responseLine().RESPONSE_LINE().getText());
    }

    @Override
    public void exitSipRequest(@NotNull SippLogParser.SipRequestContext ctx) {
        System.out.println(ctx.requestLine().REQUEST_LINE().getText());
    }
}
