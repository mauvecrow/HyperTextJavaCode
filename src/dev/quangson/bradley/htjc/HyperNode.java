package dev.quangson.bradley.htjc;

import java.util.Map;

public class HyperNode {

    private String id;
    private String classNames;
    private String innerHtml;
    private Map<String, String> attributes;
    private final HtmlTag tag;

    public HyperNode(HtmlTag tag) {
        this.tag = tag;
        this.id = null;
        this.classNames = null;
        this.innerHtml = null;
        this.attributes = null;
    }

    public HyperNode id(String id) {
        this.id = id;
        return this;
    }

    public HyperNode classNames(String classes) {
        classNames = classes;
        return this;
    }

    public HyperNode innerHtml(String text) {
        innerHtml = text;
        return this;
    }

    public HyperNode attributes(Map<String, String> map) {
        attributes = map;
        return this;
    }

    // getters

    public String getId() {
        return id;
    }

    public String getClassNames() {
        return classNames;
    }

    public String getInnerHtml() {
        return innerHtml;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public HtmlTag getTag() {
        return tag;
    }

}
