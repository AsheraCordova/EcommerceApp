package com.ashera.constraintlayout;

import java.util.List;
import java.util.Map;

import com.ashera.converter.IConverter;
import com.ashera.core.IFragment;
import com.ashera.widget.IdGenerator;

public class ConstraintReferencedIdsConverter implements IConverter<int[], String> {
    @Override
    public int[] convertFrom(String value,  Map<String, Object> dependentAttributesMap, IFragment fragment) {
        String[] ids = value.split(",");
        int[] idRefs = new int[ids.length];

        for (int i = 0; i < ids.length; i++) {
            idRefs[i] = IdGenerator.getId("@+id/" + ids[i].trim());

        }
        return idRefs;
    }


    @Override
    public String convertTo(int[] values, IFragment fragment) {
        List<String> idRefs = new java.util.ArrayList<>();

        for (int value : values) {
        	idRefs.add(IdGenerator.getName(value).replace("@+id/", ""));
        }
        return com.ashera.utils.StringUtils.join(",", idRefs);
    }
    
   


    @Override
    public List<String> getDependentAttributes() {
        return null;
    }

}