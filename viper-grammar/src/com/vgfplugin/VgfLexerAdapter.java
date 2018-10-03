package com.vgfplugin;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class VgfLexerAdapter extends FlexAdapter {
    public VgfLexerAdapter() {
        super(new VgfLexer((Reader) null));
    }
}
