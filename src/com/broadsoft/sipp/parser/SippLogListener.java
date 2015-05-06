// Generated from C:/Users/troy/IdeaProjects/SippLog/src\SippLog.g4 by ANTLR 4.5
package com.broadsoft.sipp.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SippLogParser}.
 */
public interface SippLogListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SippLogParser#sippLog}.
	 * @param ctx the parse tree
	 */
	void enterSippLog(@NotNull SippLogParser.SippLogContext ctx);
	/**
	 * Exit a parse tree produced by {@link SippLogParser#sippLog}.
	 * @param ctx the parse tree
	 */
	void exitSippLog(@NotNull SippLogParser.SippLogContext ctx);
	/**
	 * Enter a parse tree produced by {@link SippLogParser#sippItem}.
	 * @param ctx the parse tree
	 */
	void enterSippItem(@NotNull SippLogParser.SippItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SippLogParser#sippItem}.
	 * @param ctx the parse tree
	 */
	void exitSippItem(@NotNull SippLogParser.SippItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SippLogParser#directionLine}.
	 * @param ctx the parse tree
	 */
	void enterDirectionLine(@NotNull SippLogParser.DirectionLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link SippLogParser#directionLine}.
	 * @param ctx the parse tree
	 */
	void exitDirectionLine(@NotNull SippLogParser.DirectionLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link SippLogParser#timeStamp}.
	 * @param ctx the parse tree
	 */
	void enterTimeStamp(@NotNull SippLogParser.TimeStampContext ctx);
	/**
	 * Exit a parse tree produced by {@link SippLogParser#timeStamp}.
	 * @param ctx the parse tree
	 */
	void exitTimeStamp(@NotNull SippLogParser.TimeStampContext ctx);
	/**
	 * Enter a parse tree produced by {@link SippLogParser#sipMessage}.
	 * @param ctx the parse tree
	 */
	void enterSipMessage(@NotNull SippLogParser.SipMessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link SippLogParser#sipMessage}.
	 * @param ctx the parse tree
	 */
	void exitSipMessage(@NotNull SippLogParser.SipMessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link SippLogParser#sipResponse}.
	 * @param ctx the parse tree
	 */
	void enterSipResponse(@NotNull SippLogParser.SipResponseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SippLogParser#sipResponse}.
	 * @param ctx the parse tree
	 */
	void exitSipResponse(@NotNull SippLogParser.SipResponseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SippLogParser#responseLine}.
	 * @param ctx the parse tree
	 */
	void enterResponseLine(@NotNull SippLogParser.ResponseLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link SippLogParser#responseLine}.
	 * @param ctx the parse tree
	 */
	void exitResponseLine(@NotNull SippLogParser.ResponseLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link SippLogParser#sipRequest}.
	 * @param ctx the parse tree
	 */
	void enterSipRequest(@NotNull SippLogParser.SipRequestContext ctx);
	/**
	 * Exit a parse tree produced by {@link SippLogParser#sipRequest}.
	 * @param ctx the parse tree
	 */
	void exitSipRequest(@NotNull SippLogParser.SipRequestContext ctx);
	/**
	 * Enter a parse tree produced by {@link SippLogParser#requestLine}.
	 * @param ctx the parse tree
	 */
	void enterRequestLine(@NotNull SippLogParser.RequestLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link SippLogParser#requestLine}.
	 * @param ctx the parse tree
	 */
	void exitRequestLine(@NotNull SippLogParser.RequestLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link SippLogParser#sipHeader}.
	 * @param ctx the parse tree
	 */
	void enterSipHeader(@NotNull SippLogParser.SipHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link SippLogParser#sipHeader}.
	 * @param ctx the parse tree
	 */
	void exitSipHeader(@NotNull SippLogParser.SipHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link SippLogParser#sdp}.
	 * @param ctx the parse tree
	 */
	void enterSdp(@NotNull SippLogParser.SdpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SippLogParser#sdp}.
	 * @param ctx the parse tree
	 */
	void exitSdp(@NotNull SippLogParser.SdpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SippLogParser#sdpLine}.
	 * @param ctx the parse tree
	 */
	void enterSdpLine(@NotNull SippLogParser.SdpLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link SippLogParser#sdpLine}.
	 * @param ctx the parse tree
	 */
	void exitSdpLine(@NotNull SippLogParser.SdpLineContext ctx);
}