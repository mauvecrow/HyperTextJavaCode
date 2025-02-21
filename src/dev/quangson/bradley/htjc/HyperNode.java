package dev.quangson.bradley.htjc;

import java.util.Map;
import java.util.stream.Collectors;

public class HyperNode {

    private String text;
    private Map<String, String> attributes;
    private final HtmlTag tag;

    public HyperNode(HtmlTag tag) {
        this.tag = tag;
        this.text = null;
        this.attributes = null;
    }

    // getters and setters

    public String getText() {
        return text;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public HtmlTag getTag() {
        return tag;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAttributes(Map<String, String> attributes) {
        if(tag == HtmlTag.empty)
            return; // consider throwing exception
        this.attributes = attributes;
    }

    // helpful methods

    public String getAttributesString(){
        return attributes.entrySet().stream()
                .map( entry -> " " + entry.getKey() + "=\"" + entry.getValue() + "\" ")
                .collect(Collectors.joining());
    }
}
