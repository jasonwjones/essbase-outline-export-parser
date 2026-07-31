package com.appliedolap.essbase.exportparse;

import com.appliedolap.essbase.exportparse.model.Application;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

final class OutlineXmlBinding {

    private static final JAXBContext CONTEXT = createContext();

    private OutlineXmlBinding() {
    }

    static JAXBContext context() {
        return CONTEXT;
    }

    private static JAXBContext createContext() {
        try {
            return JAXBContext.newInstance(Application.class);
        } catch (JAXBException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

}
