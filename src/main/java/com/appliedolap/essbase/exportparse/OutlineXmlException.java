package com.appliedolap.essbase.exportparse;

/**
 * Indicates that Essbase outline XML could not be read or written.
 */
public class OutlineXmlException extends Exception {

    private static final long serialVersionUID = 1L;

    public OutlineXmlException(String message, Throwable cause) {
        super(message, cause);
    }

}
