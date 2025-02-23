package dev.quangson.bradley.htjc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Component {

    private final Deque<HyperNode> stack;

    private Component(Deque<HyperNode> stack) {
        this.stack = stack;
    }

    public static class Builder {

        private final Deque<HyperNode> builderStack;

        public Builder() {
            this.builderStack = new ArrayDeque<>();
        }

        public Builder(Component component){
            this.builderStack = copyStack(component.getStack(), 0);
        }

        public Builder add(Builder builderComp, int parentLevel) {
            var newStack = copyStack(builderComp.builderStack, parentLevel);
            builderStack.addAll(newStack);
            return this;
        }

        private Deque<HyperNode> copyStack(Deque<HyperNode> stack, int levelOffset){
            Deque<HyperNode> newStack = new ArrayDeque<>();

            stack.forEach(node -> {
                var newNode = new HyperNode(node.getTag(), node.getAttributes(), node.getText(), node.getLevel() + levelOffset);
                newStack.addLast(newNode);
            });

            return newStack;
        }

        public Builder attributes(Map<String, String> attributesMap){
            builderStack.getLast().setAttributes(attributesMap);
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
            builderStack.getLast().setText(text);
            return this;
        }

        public Component build(){
            return new Component(builderStack);
        }

        // Node tag methods

        public Builder html(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.HTML);
            builderStack.addLast(node);
            return this;
        }

        public Builder head(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.HEAD);
            builderStack.addLast(node);
            return this;
        }

        public Builder body(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.BODY);
            builderStack.addLast(node);
            return this;
        }

        public Builder title(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.TITLE);
            builderStack.addLast(node);
            return this;
        }

        public Builder h1(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.H1);
            builderStack.addLast(node);
            return this;
        }

        public Builder h2(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.H2);
            builderStack.addLast(node);
            return this;
        }

        public Builder h3(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.H3);
            builderStack.addLast(node);
            return this;
        }

        public Builder h4(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.H4);
            builderStack.addLast(node);
            return this;
        }

        public Builder h5(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.H5);
            builderStack.addLast(node);
            return this;
        }

        public Builder h6(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.H6);
            builderStack.addLast(node);
            return this;
        }

        public Builder p(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.P);
            builderStack.addLast(node);
            return this;
        }

        public Builder div(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.DIV);
            builderStack.addLast(node);
            return this;
        }

        public Builder span(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.SPAN);
            builderStack.addLast(node);
            return this;
        }

        public Builder ul(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.UL);
            builderStack.addLast(node);
            return this;
        }

        public Builder ol(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.OL);
            builderStack.addLast(node);
            return this;
        }

        public Builder li(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.LI);
            builderStack.addLast(node);
            return this;
        }

        public Builder table(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.TABLE);
            builderStack.addLast(node);
            return this;
        }

        public Builder tr(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.TR);
            builderStack.addLast(node);
            return this;
        }

        public Builder th(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.TH);
            builderStack.addLast(node);
            return this;
        }

        public Builder td(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.TD);
            builderStack.addLast(node);
            return this;
        }

        public Builder thead(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.THEAD);
            builderStack.addLast(node);
            return this;
        }

        public Builder tfoot(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.TFOOT);
            builderStack.addLast(node);
            return this;
        }

        public Builder caption(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.CAPTION);
            builderStack.addLast(node);
            return this;
        }

        public Builder img(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.IMG);
            builderStack.addLast(node);
            return this;
        }

        public Builder a(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.A);
            builderStack.addLast(node);
            return this;
        }

        public Builder link(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.LINK);
            builderStack.addLast(node);
            return this;
        }

        public Builder form(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.FORM);
            builderStack.addLast(node);
            return this;
        }

        public Builder input(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.INPUT);
            builderStack.addLast(node);
            return this;
        }

        public Builder label(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.LABEL);
            builderStack.addLast(node);
            return this;
        }

        public Builder button(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.BUTTON);
            builderStack.addLast(node);
            return this;
        }

        public Builder textarea(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.TEXTAREA);
            builderStack.addLast(node);
            return this;
        }

        public Builder i(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.I);
            builderStack.addLast(node);
            return this;
        }

        public Builder u(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.U);
            builderStack.addLast(node);
            return this;
        }

        public Builder em(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.EM);
            builderStack.addLast(node);
            return this;
        }

        public Builder strong(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.STRONG);
            builderStack.addLast(node);
            return this;
        }

        public Builder br(int level) {
            HyperNode node = new HyperNode(level, HtmlTag.BR);
            builderStack.addLast(node);
            return this;
        }

        public Builder empty(int level){
            HyperNode node = new HyperNode(level, HtmlTag.empty);
            builderStack.addLast(node);
            return this;
        }


    }

    Deque<HyperNode> getStack(){
        return this.stack;
    }

    public String render() {
        Deque<HyperNode> openedTags = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int currentLevel = 1;

        for (var node : this.stack) {
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

