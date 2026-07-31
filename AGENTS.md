# Essbase Outline Export Parser Development Guidelines

## Project and toolchain

- This is a Java 17 Maven library for reading, writing, and walking Essbase outline XML.
- Use the repository Maven Wrapper: `../../../mvnw` on Unix or `..\..\..\mvnw.cmd` on Windows.
- Run `../../../mvnw clean verify` for normal validation. Do not activate the `release` profile unless publication was explicitly requested.
- Keep the public model and XML shape compatible within a major version. Treat XML element names and capitalization as part of the external contract.

## JAXB and XML behavior

- Use Jakarta XML Binding (`jakarta.xml.bind`) exclusively. Do not add Javax JAXB dependencies.
- Keep the JAXB API as a compile dependency and the GlassFish implementation as a runtime dependency.
- Expose `OutlineXmlException` from the public reader/writer API rather than leaking JAXB implementation exceptions.
- Preserve secure parsing: DTD and external-entity processing must remain disabled.
- `OutlineXmlReader.read(InputStream)` does not own or close the caller's stream; file-based methods must close streams they open.

## Tests and changes

- Add assertions for every newly modeled XML attribute or element and for changes to traversal behavior.
- Use the representative outline fixture for compatibility tests and small inline models for focused writer tests.
- Verify both parsing and writing when changing JAXB annotations, defaults, adapters, or element ordering.
- Avoid logging or printing parsed outline contents in tests.
- Do not commit generated Maven output, signatures, or publication bundles.
