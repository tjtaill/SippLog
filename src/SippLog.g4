grammar SippLog;

sippLog : sippItem+;
            
sippItem : timeStamp | directionLine | sipMessage;

directionLine : DIRECTION_LINE;

DIRECTION : 'sent'
          | 'received'
          ;

BYTES : '(' DIGIT+ ' bytes' ')'
      | '[' DIGIT+ ']' ' bytes '
      ;

DIRECTION_LINE : 'UDP message ' DIRECTION ' ' BYTES ':' NEWLINE;

timeStamp : TIME_STAMP;

YEAR : DIGIT DIGIT DIGIT DIGIT;
MONTH : DIGIT DIGIT;
DAY : DIGIT DIGIT;
HOUR : DIGIT DIGIT;
MINUTE : DIGIT DIGIT;
SECOND : DIGIT DIGIT;
MILLIS : DIGIT DIGIT DIGIT?;
NANOS : DIGIT DIGIT DIGIT;



DATE : YEAR '-' MONTH '-' DAY;
TIME : HOUR ':' MINUTE ':' SECOND ':' MILLIS '.' NANOS;
TIME_STAMP : '-'+ ' ' DATE ' ' TIME NEWLINE;

sipMessage : sipResponse | sipRequest;

sipResponse : responseLine sipHeader+ sdp?;
        
responseLine : RESPONSE_LINE;

RESPONSE_LINE : 'SIP/2.0' .*? RESPONSE_CODE .*? '\n';

DIGIT : [0-9];
                 
RESPONSE_CODE : DIGIT DIGIT DIGIT;

METHOD : 'INVITE' | 
         'ACK' |
         'BYE' |
         'CANCEL' |
         'OPTIONS' |
         'REGISTER' |
         'PRACK' |
         'SUBSCRIBE' |
         'NOTIFY'|
         'PUBLISH' |
         'INFO' |
         'REFER' |
         'MESSAGE' |
         'UPDATE' ;

sipRequest : requestLine sipHeader+ sdp?;

requestLine : REQUEST_LINE;

REQUEST_LINE : METHOD ' '+ SIP_URL ' '+ SIP_VERSION NEWLINE; 

NEWLINE : '\r'? '\n';
SIP_VERSION : 'SIP/2.0';
NOT_SPACE : ~' ';
SIP_URL : 'sip:' NOT_SPACE+;
sipHeader : SIP_HEADER;

SIP_HEADER : HEADER ':' .*? NEWLINE;

HEADER : 'Via' 
       | 'To'
       | 'From'
       | 'CSeq'
       | 'Call-ID'
       | 'Allow'
       | 'Contact'
       | 'Max-Forwards'
       | 'Subject'
       | 'Route' 
       | 'Supported'
       | 'Content-Type'
       | 'Content-Length'
       | 'Require'
       | 'RSeq'
       | 'RAck' 
       | 'Session'
       | 'Privacy'
       | 'P-Asserted-Identity'
       | 'Call-Info'
       | 'Accept'
       | 'Record-Route'
       | 'P-Charging-Vector'
       ;

sdp : sdpLine+;
sdpLine : SDP_LINE;
SDP_LINE : [a-z] '=' .*? NEWLINE;

WS : [ \t\r\n] -> skip;