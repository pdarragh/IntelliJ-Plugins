package com.vgfplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.vgfplugin.psi.VgfTypes;
import com.intellij.psi.TokenType;

%%

%class VgfLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{   return;
%eof}

LINE_TERMINATOR = \R
WHITE_SPACE     = [\ \n\t\f]
CAPITAL_CHAR    = [A-Z]
LOWER_CHAR      = [a-z]
WORD_CHAR       = [a-zA-Z0-9_]
COMMENT         = "#" [^\r\n]* {LINE_TERMINATOR}?
START_RULE      = "<"
END_RULE        = ">"
DEF_SEP         = "::="
ALT_SEP         = "|"
PROP_SEP        = ":"

RuleName        = {START_RULE} {WORD_CHAR}+ {END_RULE}
ProductionName  = {CAPITAL_CHAR} {WORD_CHAR}*
PropertyName    = {LOWER_CHAR} ( {LOWER_CHAR} | "_" )*

SeparatorLiteral    = "{" [^}]+ "}"

QuotedPortion   = [\'] [^\']+ [\'] | [\"] [^\"]+ [\"]

%%

<YYINITIAL> {
    // Literal matches
    {COMMENT}           { return VgfTypes.COMMENT; }
    {LINE_TERMINATOR}   { return VgfTypes.LINE_TERMINATOR; }
    {WHITE_SPACE}       { return TokenType.WHITE_SPACE; }
    {DEF_SEP}           { return VgfTypes.DEF_SEP; }
    {ALT_SEP}           { return VgfTypes.ALT_SEP; }
    {PROP_SEP}          { return VgfTypes.PROP_SEP; }

    // Special tokens
    "INDENT"            { return VgfTypes.INDENT; }
    "DEDENT"            { return VgfTypes.DEDENT; }
    "ENDMARKER"         { return VgfTypes.ENDMARKER; }
    "NEWLINE"           { return VgfTypes.NEWLINE; }
    "PERIOD"            { return VgfTypes.PERIOD; }
    "'.'"               { return VgfTypes.PERIOD; }
    "EQUALS"            { return VgfTypes.EQUALS; }
    "="                 { return VgfTypes.EQUALS; }
    "COMMA"             { return VgfTypes.COMMA; }
    "','"               { return VgfTypes.COMMA; }
    "OPEN_PAREN"        { return VgfTypes.OPEN_PAREN; }
    "')'"               { return VgfTypes.OPEN_PAREN; }
    "CLOSE_PAREN"       { return VgfTypes.CLOSE_PAREN; }
    "')'"               { return VgfTypes.CLOSE_PAREN; }
    "COLON"             { return VgfTypes.COLON; }
    "':'"               { return VgfTypes.COLON; }
    "L_ARROW"           { return VgfTypes.L_ARROW; }
    "'<-'"              { return VgfTypes.L_ARROW; }
    "R_ARROW"           { return VgfTypes.R_ARROW; }
    "'->'"              { return VgfTypes.R_ARROW; }
    "ELLIPSIS"          { return VgfTypes.ELLIPSIS; }
    "'...'"             { return VgfTypes.ELLIPSIS; }
    "INT"               { return VgfTypes.INT; }
    "FLOAT"             { return VgfTypes.FLOAT; }
    "STRING"            { return VgfTypes.STRING; }
    "NAME"              { return VgfTypes.NAME; }
    "UNDERSCORE"        { return VgfTypes.UNDERSCORE; }
    "'_'"               { return VgfTypes.UNDERSCORE; }
    "CLASS"             { return VgfTypes.CLASS; }
    "OPERATOR"          { return VgfTypes.OPERATOR; }

    // Modifiers
    "?"                 { return VgfTypes.OPTIONAL; }
    "*"                 { return VgfTypes.REPEAT; }
    "+"                 { return VgfTypes.MIN_REPEAT; }
    "&*"                { return VgfTypes.SEP_REPEAT; }
    "&+"                { return VgfTypes.MIN_SEP_REPEAT; }

    {RuleName}          { return VgfTypes.RULE_NAME; }
    {ProductionName}    { return VgfTypes.PRODUCTION_NAME; }
    {PropertyName}      { return VgfTypes.PROPERTY_NAME; }

    {SeparatorLiteral}  { return VgfTypes.SEP_LIT; }

    {QuotedPortion}     { return VgfTypes.LITERAL; }
}
