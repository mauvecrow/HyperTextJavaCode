package dev.quangson.bradley.htjc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ComponentBuilder {

    private List<HyperNode> nodes;

    public ComponentBuilder() {
        this.nodes = new ArrayList<>();
    }

    public ComponentBuilder(Component component){
        this.nodes = copyList(component.getNodes());
    }

    // getter and setter

    public List<HyperNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<HyperNode> nodes) {
        this.nodes = nodes;
    }

    // build methods

    public ComponentBuilder add(ComponentBuilder builderComp, int parentLevel) {
        var newList = copyList(builderComp.nodes, parentLevel);
        nodes.addAll(newList);
        return this;
    }

    private List<HyperNode> copyList(List<HyperNode> nodeList, int levelOffset){
        List<HyperNode> newList = new ArrayList<>();

        nodeList.forEach(node -> {
            var newNode = new HyperNode(node.getTag(), node.getAttributes(), node.getText(), node.getLevel() + levelOffset);
            newList.add(newNode);
        });

        return newList;
    }

    private List<HyperNode> copyList(List<HyperNode> nodeList){
        return copyList(nodeList, 0);
    }

    public ComponentBuilder attributes(Map<String, String> attributesMap){
        nodes.getLast().setAttributes(attributesMap);
        return this;
    }

    public ComponentBuilder attributes(String...attributesStream){
        Function<String, String> keyFunction = k -> k.substring(0, k.indexOf('='));
        Function<String, String> valuFunction = v -> v.substring(v.indexOf('=')+1);
        var map = Arrays.stream(attributesStream)
                .collect(Collectors.toMap(keyFunction, valuFunction));
        return attributes(map);
    }

    public ComponentBuilder text(String text){
        nodes.getLast().setText(text);
        return this;
    }

    public Component build(){
        return new Component(nodes);
    }

    // Node tag methods

    public ComponentBuilder html(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.HTML);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder head(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.HEAD);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder body(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.BODY);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder title(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.TITLE);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder h1(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.H1);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder h2(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.H2);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder h3(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.H3);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder h4(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.H4);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder h5(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.H5);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder h6(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.H6);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder p(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.P);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder div(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.DIV);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder span(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.SPAN);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder ul(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.UL);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder ol(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.OL);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder li(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.LI);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder table(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.TABLE);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder tr(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.TR);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder th(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.TH);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder td(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.TD);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder thead(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.THEAD);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder tfoot(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.TFOOT);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder caption(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.CAPTION);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder img(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.IMG);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder a(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.A);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder link(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.LINK);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder form(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.FORM);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder input(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.INPUT);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder label(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.LABEL);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder button(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.BUTTON);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder textarea(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.TEXTAREA);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder i(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.I);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder u(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.U);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder em(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.EM);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder strong(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.STRONG);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder br(int level) {
        HyperNode node = new HyperNode(level, HtmlTag.BR);
        nodes.addLast(node);
        return this;
    }

    public ComponentBuilder empty(int level){
        HyperNode node = new HyperNode(level, HtmlTag.empty);
        nodes.addLast(node);
        return this;
    }

}
