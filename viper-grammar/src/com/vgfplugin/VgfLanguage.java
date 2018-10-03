package com.vgfplugin;

import com.intellij.lang.Language;

public class VgfLanguage extends Language {
    public static final VgfLanguage INSTANCE = new VgfLanguage();

    private VgfLanguage() {
        super("VGF");
    }
}
