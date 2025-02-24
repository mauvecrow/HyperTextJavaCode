package dev.quangson.bradley.htjc;

import java.util.Map;
import java.util.stream.Collectors;

public class HyperNode {

    private final HtmlTag tag;
    private Map<String, String> attributes;
    private String text;
    private int level;

    public HyperNode(HtmlTag tag, Map<String, String> attributes, String text, int level) {
        this.tag = tag;
        this.attributes = attributes;
        this.text = text;
        this.level = level;
    }

    public HyperNode(int level, HtmlTag tag) {
        this(tag, null, null, level);
    }

    public HtmlTag getTag() {
        return tag;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // helpful methods

    public String getAttributesString(){
        return " " + attributes.entrySet().stream()
                .map( entry -> entry.getKey() + "=\"" + entry.getValue() + "\" ")
                .collect(Collectors.joining());
    }
}
