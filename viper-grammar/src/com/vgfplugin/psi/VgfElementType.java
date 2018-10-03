package com.vgfplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.vgfplugin.VgfLanguage;
import org.jetbrains.annotations.*;

public class VgfElementType extends IElementType {
    public VgfElementType(@NotNull @NonNls String debugName) {
        super(debugName, VgfLanguage.INSTANCE);
    }
}
