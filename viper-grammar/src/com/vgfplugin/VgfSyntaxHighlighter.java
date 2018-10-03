package com.vgfplugin;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.vgfplugin.psi.VgfTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class VgfSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey RULE_NAME = createTextAttributesKey("VGF_RULE_NAME", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey PRODUCTION_NAME = createTextAttributesKey("VGF_PRODUCTION_NAME", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey PROPERTY_NAME = createTextAttributesKey("VGF_PROPERTY_NAME", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
    public static final TextAttributesKey SPECIAL_TOKEN = createTextAttributesKey("VGF_SPECIAL_TOKEN", DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("VGF_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey LITERAL = createTextAttributesKey("VGF_LITERAL", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("VGF_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] RULE_NAME_KEYS = new TextAttributesKey[]{RULE_NAME};
    private static final TextAttributesKey[] PRODUCTION_NAME_KEYS = new TextAttributesKey[]{PRODUCTION_NAME};
    private static final TextAttributesKey[] PROPERTY_NAME_KEYS = new TextAttributesKey[]{PROPERTY_NAME};
    private static final TextAttributesKey[] SPECIAL_TOKEN_KEYS = new TextAttributesKey[]{SPECIAL_TOKEN};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] LITERAL_KEYS = new TextAttributesKey[]{LITERAL};
    private static final TextAttributesKey[] BAD_CHARACTER_KEYS = new TextAttributesKey[]{BAD_CHARACTER};

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new VgfLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(VgfTypes.RULE_NAME)) {
            return RULE_NAME_KEYS;
        } else if (tokenType.equals(VgfTypes.PRODUCTION_NAME)) {
            return PRODUCTION_NAME_KEYS;
        } else if (tokenType.equals(VgfTypes.PROPERTY_NAME)) {
            return PROPERTY_NAME_KEYS;
        } else if (tokenType.equals(VgfTypes.SPECIAL_TOKEN)) {
            return SPECIAL_TOKEN_KEYS;
        } else if (tokenType.equals(VgfTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(VgfTypes.LITERAL)) {
            return LITERAL_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHARACTER_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
