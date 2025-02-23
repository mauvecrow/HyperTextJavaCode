package dev.quangson.bradley.htjc;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Component {

    private final List<HyperNode> nodes;

    private Component(List<HyperNode> nodes) {
        this.nodes = nodes;
    }

    public static class Builder {

        private final List<HyperNode> builderNodes;

        public Builder() {
            this.builderNodes = new ArrayList<>();
        }

        public Builder(Component component){
            this.builderNodes = copyList(component.getNodes());
        }

        public Builder add(Builder builderComp, int parentLevel) {
            var newList = copyList(builderComp.builderNodes, parentLevel);
            builderNodes.addAll(newList);
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

        private  List<HyperNode> copyList(List<HyperNode> nodeList){
            return copyList(nodeList, 0);
        }

        public Builder attributes(Map<String, String> attributesMap){
            builderNodes.getLast().setAttributes(attributesMap);
            return this;
        }

        public Builder attributes(String...attributesStream){
            Function<String, String> keyFunction = k -> k.substring(0, k.indexOf('='));
            Function<String, String> valuFunction = v -> v.substring(v.indexOf('=')+1);
            var map = Arrays.stream(attributesStream)
                    .collect(Collectors.toMap(keyFunction, valuFunction));
            return attributes(map);
        }

        public Builder text(String text){
            builderNodes.getLast().setText(text);
            return this;
        }

        public Component build(){
            var immutableList = List.copyOf(this.builderNodes);
            return new Component(immutableList);
        }

        // Node tag methods

        public Builder html(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.HTML);
            builderNodes.addLast(node);
            return this;
        }

        public Builder head(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.HEAD);
            builderNodes.addLast(node);
            return this;
        }

        public Builder body(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.BODY);
            builderNodes.addLast(node);
            return this;
        }

        public Builder title(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.TITLE);
            builderNodes.addLast(node);
            return this;
        }

        public Builder h1(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.H1);
            builderNodes.addLast(node);
            return this;
        }

        public Builder h2(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.H2);
            builderNodes.addLast(node);
            return this;
        }

        public Builder h3(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.H3);
            builderNodes.addLast(node);
            return this;
        }

        public Builder h4(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.H4);
            builderNodes.addLast(node);
            return this;
        }

        public Builder h5(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.H5);
            builderNodes.addLast(node);
            return this;
        }

        public Builder h6(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.H6);
            builderNodes.addLast(node);
            return this;
        }

        public Builder p(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.P);
            builderNodes.addLast(node);
            return this;
        }

        public Builder div(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.DIV);
            builderNodes.addLast(node);
            return this;
        }

        public Builder span(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.SPAN);
            builderNodes.addLast(node);
            return this;
        }

        public Builder ul(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.UL);
            builderNodes.addLast(node);
            return this;
        }

        public Builder ol(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.OL);
            builderNodes.addLast(node);
            return this;
        }

        public Builder li(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.LI);
            builderNodes.addLast(node);
            return this;
        }

        public Builder table(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.TABLE);
            builderNodes.addLast(node);
            return this;
        }

        public Builder tr(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.TR);
            builderNodes.addLast(node);
            return this;
        }

        public Builder th(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.TH);
            builderNodes.addLast(node);
            return this;
        }

        public Builder td(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.TD);
            builderNodes.addLast(node);
            return this;
        }

        public Builder thead(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.THEAD);
            builderNodes.addLast(node);
            return this;
        }

        public Builder tfoot(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.TFOOT);
            builderNodes.addLast(node);
            return this;
        }

        public Builder caption(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.CAPTION);
            builderNodes.addLast(node);
            return this;
        }

        public Builder img(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.IMG);
            builderNodes.addLast(node);
            return this;
        }

        public Builder a(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.A);
            builderNodes.addLast(node);
            return this;
        }

        public Builder link(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.LINK);
            builderNodes.addLast(node);
            return this;
        }

        public Builder form(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.FORM);
            builderNodes.addLast(node);
            return this;
        }

        public Builder input(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.INPUT);
            builderNodes.addLast(node);
            return this;
        }

        public Builder label(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.LABEL);
            builderNodes.addLast(node);
            return this;
        }

        public Builder button(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.BUTTON);
            builderNodes.addLast(node);
            return this;
        }

        public Builder textarea(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.TEXTAREA);
            builderNodes.addLast(node);
            return this;
        }

        public Builder i(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.I);
            builderNodes.addLast(node);
            return this;
        }

        public Builder u(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.U);
            builderNodes.addLast(node);
            return this;
        }

        public Builder em(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.EM);
            builderNodes.addLast(node);
            return this;
        }

        public Builder strong(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.STRONG);
            builderNodes.addLast(node);
            return this;
        }

        public Builder br(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.BR);
            builderNodes.addLast(node);
            return this;
        }

        public Builder empty(int level){
            HyperNode node = new HyperNode(level, HtmlTag.empty);
            builderNodes.addLast(node);
            return this;
        }


    }

    List<HyperNode> getNodes(){
        return this.nodes;
    }

    public String render() {
        List<HyperNode> openedTags = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int currentLevel = 1;

        for (var node : this.nodes) {
            var level = node.getLevel();

            // print inner end tag
            if (level < currentLevel) {
                while (level < currentLevel) {
                    var prev = openedTags.removeLast();
                    sb.append(prev.getTag().endTag());
//					System.out.println(new String(sb));
                    currentLevel--;
                }

            }

            // print start tag
            sb.append(node.getTag().openStartTag());
//			System.out.println(new String(sb));
            openedTags.addLast(node);

            // print attributes if any
            if(node.getAttributes() != null){
                sb.append(node.getAttributesString());
                sb.append(node.getTag().closeStartTag());
            }
            else
                sb.append(node.getTag().closeStartTag());

            // print text if any
            if(node.getText() != null)
                sb.append(node.getText());

            // increment level
            currentLevel++;
        }

        // print remaining outer end tags
        while(!openedTags.isEmpty()) {
            var last = openedTags.removeLast().getTag().endTag();
            sb.append(last);
        }

        return sb.toString();
    }

}

