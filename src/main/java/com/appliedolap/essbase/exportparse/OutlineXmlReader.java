package com.appliedolap.essbase.exportparse;

import com.appliedolap.essbase.exportparse.model.Application;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Objects;

/**
 * Reads Essbase outline XML into the library's outline model.
 */
public class OutlineXmlReader {

    /**
     * Reads an outline XML file. Streams opened by this method are closed before it returns.
     *
     * @param file the outline file
     * @return a new application object
     * @throws OutlineXmlException if the file cannot be opened or parsed
     */
    public Application read(File file) throws OutlineXmlException {
        Objects.requireNonNull(file, "file");
        try (InputStream inputStream = Files.newInputStream(file.toPath())) {
            return read(inputStream);
        } catch (IOException e) {
            throw new OutlineXmlException("Unable to read outline XML file " + file, e);
        }
    }

    /**
     * Reads outline XML from a stream. This method does not close the supplied stream.
     *
     * @param inputStream the input stream to read
     * @return a new application object
     * @throws OutlineXmlException if the XML cannot be parsed
     */
    public Application read(InputStream inputStream) throws OutlineXmlException {
        Objects.requireNonNull(inputStream, "inputStream");
        XMLStreamReader streamReader = null;
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newFactory();
            inputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
            inputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
            streamReader = inputFactory.createXMLStreamReader(inputStream);

            Unmarshaller unmarshaller = OutlineXmlBinding.context().createUnmarshaller();
            return (Application) unmarshaller.unmarshal(streamReader);
        } catch (JAXBException | XMLStreamException e) {
            throw new OutlineXmlException("Unable to parse outline XML", e);
        } finally {
            if (streamReader != null) {
                try {
                    streamReader.close();
                } catch (XMLStreamException ignored) {
                    // Parsing has completed and the caller owns the underlying stream.
                }
            }
        }
    }

}
