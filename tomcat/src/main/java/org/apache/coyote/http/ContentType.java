package org.apache.coyote.http;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum ContentType {
    TEXT_PLAIN("text/plain"),
    TEXT_HTML("text/html"),
    TEXT_JSON("text/json"),
    TEXT_JAVASCRIPT("text/javascript"),
    TEXT_CSS("text/css"),
    IMAGE_SVG("image/svg+xml"),
    CHARSET_UTF_8("charset=utf-8");

    public static final String CONTENT_TYPE_SEPARATOR = ";";
    private final String type;

    ContentType(final String type) {
        this.type = type;
    }

    public String type() {
        return this.type;
    }

    public static String toContentTypeValues(final ContentType... contentTypes) {
        return Arrays.stream(contentTypes).map(ContentType::type).collect(Collectors.joining(CONTENT_TYPE_SEPARATOR));
    }

    public static ContentType from(final String mimeType) {
        return Arrays.stream(values()).filter(contentType -> contentType.type.contains(mimeType)).findFirst().orElse(null);
    }
}