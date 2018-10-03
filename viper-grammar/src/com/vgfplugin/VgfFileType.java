package com.vgfplugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;

import javax.swing.*;

public class VgfFileType extends LanguageFileType {
    public static final VgfFileType INSTANCE = new VgfFileType();

    private VgfFileType() {
        super(VgfLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Viper grammar file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Viper grammar file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "vgf";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return VgfIcons.FILE;
    }
}
