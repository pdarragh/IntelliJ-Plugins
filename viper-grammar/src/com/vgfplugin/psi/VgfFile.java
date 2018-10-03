package com.vgfplugin.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.vgfplugin.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class VgfFile extends PsiFileBase {
    public VgfFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, VgfLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return VgfFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "VGF File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
