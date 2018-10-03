package com.vgfplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.vgfplugin.VgfLanguage;
import org.jetbrains.annotations.*;

public class VgfTokenType extends IElementType {
    public VgfTokenType(@NotNull @NonNls String debugName) {
        super(debugName, VgfLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "VgfTokenType." + super.toString();
    }
}
