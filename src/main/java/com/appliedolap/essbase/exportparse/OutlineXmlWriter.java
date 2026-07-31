package com.appliedolap.essbase.exportparse;

import com.appliedolap.essbase.exportparse.model.Application;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Writes the library's outline model as Essbase outline XML.
 */
public class OutlineXmlWriter {

    public static String writeToString(Application application) throws OutlineXmlException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        write(application, outputStream);
        return outputStream.toString(StandardCharsets.UTF_8);
    }

    public static void write(Application application, File file) throws OutlineXmlException {
        Objects.requireNonNull(file, "file");
        try {
            marshaller().marshal(requireApplication(application), file);
        } catch (JAXBException e) {
            throw new OutlineXmlException("Unable to write outline XML file " + file, e);
        }
    }

    public static void write(Application application, OutputStream outputStream) throws OutlineXmlException {
        Objects.requireNonNull(outputStream, "outputStream");
        try {
            marshaller().marshal(requireApplication(application), outputStream);
        } catch (JAXBException e) {
            throw new OutlineXmlException("Unable to write outline XML", e);
        }
    }

    private static Application requireApplication(Application application) {
        return Objects.requireNonNull(application, "application");
    }

    private static Marshaller marshaller() throws JAXBException {
        Marshaller marshaller = OutlineXmlBinding.context().createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        return marshaller;
    }

}
