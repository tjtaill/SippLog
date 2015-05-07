package com.broadsoft.sipp.parser;

import org.antlr.v4.runtime.misc.NotNull;

public class SippMessagePrintListener extends SippLogBaseListener {
    @Override
    public void exitSipResponse(@NotNull SippLogParser.SipResponseContext ctx) {
        String response = ctx.responseLine().RESPONSE_LINE().getText().split(" ", 3)[1];
        System.out.println(response);
    }

    @Override
    public void exitSipRequest(@NotNull SippLogParser.SipRequestContext ctx) {
        String request = ctx.requestLine().REQUEST_LINE().getText().split(" ", 2)[0];
        System.out.println(request);
    }
}
