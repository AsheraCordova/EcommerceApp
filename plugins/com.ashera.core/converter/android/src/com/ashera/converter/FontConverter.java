package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;

public class FontConverter implements IConverter<Typeface, String> {
    @Override
    public Typeface convertFrom(String value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
        if (value.startsWith("@font/")) {
            String key1 = value.replaceFirst("@font/", "");
            Context context = (Context) fragment.getRootActivity();
            int identifier = context.getResources().getIdentifier(key1, "font", context.getPackageName());
            return ResourcesCompat.getFont(context, identifier);
        }

        switch (value) {
        case "normal":
            return Typeface.DEFAULT;
        case "sans":
            return Typeface.SERIF;
        case "serif":
            return Typeface.SANS_SERIF;
        case "mono":
            return Typeface.MONOSPACE;
        default:
            return null;
        }
    }


    @Override
    public String convertTo(Typeface value, IFragment fragment) {
        return "";
    }

    @Override
    public java.util.List<String> getDependentAttributes() {
        return null;
    }
}