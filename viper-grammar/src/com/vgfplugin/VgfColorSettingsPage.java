package com.vgfplugin;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.*;
import org.jetbrains.annotations.*;

import javax.swing.*;
import java.util.Map;

public class VgfColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Rule Name", VgfSyntaxHighlighter.RULE_NAME),
            new AttributesDescriptor("Production Name", VgfSyntaxHighlighter.PRODUCTION_NAME),
            new AttributesDescriptor("Property Name", VgfSyntaxHighlighter.PROPERTY_NAME),
            new AttributesDescriptor("Special Token", VgfSyntaxHighlighter.SPECIAL_TOKEN),
            new AttributesDescriptor("Comment", VgfSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Literal", VgfSyntaxHighlighter.LITERAL),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return VgfIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new VgfSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "# You are reading a Viper Grammar File.\n" +
               "<rule_name>     ::= Newline NEWLINE\n" +
               "                  | ProductionName prop:<rule_name>? 'rule'";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "VGF";
    }
}
