package dev.quangson.bradley.htjc;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ComponentTest {

    @Test
    void renderHtmlDoc() {
        var doc = new ComponentBuilder()
                .html(1)
                .head(2)
                .body(2)
                .h1(3).text("My Header")
                .p(3).text("Text here")
                .build()
                .render();

        final String expected = "<html><head></head><body><h1>My Header</h1><p>Text here</p></body></html>";
        assertEquals(expected, doc);
    }

    @Test
    void prettifyHtmlDoc() {
        var doc = new ComponentBuilder()
                .html(1)
                .head(2)
                .body(2)
                .h1(3).text("My Header")
                .p(3).text("Text here")
                .build()
                .render();

        final String expected = "<html>".concat("\n").concat(" ".repeat(4)) +
                "<head>".concat("\n").concat(" ".repeat(4)) +
                "</head>".concat("\n").concat(" ".repeat(4)) +
                "<body>".concat("\n").concat(" ".repeat(8)) +
                "<h1>".concat("\n").concat(" ".repeat(12)) +
                "My Header".concat("\n").concat(" ".repeat(8)) +
                "</h1>".concat("\n").concat(" ".repeat(8)) +
                "<p>".concat("\n").concat(" ".repeat(12)) +
                "Text here".concat("\n").concat(" ".repeat(8)) +
                "</p>".concat("\n").concat(" ".repeat(4)) +
                "</body>".concat("\n") +
                "</html>";
        String actual = Components.prettify(doc);
        assertEquals(expected, actual);

    }

}