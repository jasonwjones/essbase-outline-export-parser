package com.appliedolap.essbase.exportparse.model;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Arrays;
import java.util.List;

public class YesNoBooleanAdapter extends XmlAdapter<String, Boolean> {

    private static final String OUTLINE_XML_TRUE = "Y";

    private static final String OUTLINE_XML_FALSE = "N";

    private static final List<String> POSSIBLE_TRUE_VALUES = Arrays.asList(OUTLINE_XML_TRUE, "true", "1");

    @Override
    public Boolean unmarshal(String v) throws Exception {
        for (String value : POSSIBLE_TRUE_VALUES) {
            if (value.equalsIgnoreCase(v)) return true;
        }
        return false;
    }

    @Override
    public String marshal(Boolean v) throws Exception {
        // to avoid an NPE
        return Boolean.TRUE == v ? OUTLINE_XML_TRUE : OUTLINE_XML_FALSE;
    }

}