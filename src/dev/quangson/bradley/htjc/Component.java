package dev.quangson.bradley.htjc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Component {

    private final Deque<NodePair> stack;

    static class NodePair {

        int level;
        HyperNode node;

        NodePair(int level, HyperNode node){
            this.level = level;
            this.node = node;
        }

    }

    public Component() {
        this.stack = new ArrayDeque<>();
    }

    public Component(Component component){
        Deque<NodePair> newStack = new ArrayDeque<>();
        component.getStack().forEach( np -> {
            var node = np.node;
            var hyperNode = new HyperNode(node.getText(), node.getAttributes(), node.getTag());
            newStack.addLast(new NodePair(np.level, hyperNode));
        });
        this.stack = newStack;
    }

    Deque<NodePair> getStack(){
        return this.stack;
    }

    public String render() {
//        stack.forEach(np -> System.out.println(np.level + ": " + np.node.getTag()));
        Deque<HyperNode> openedTags = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int currentLevel = 1;

        for (var nodePair : stack) {
            var level = nodePair.level;
            var node = nodePair.node;

            // print end tag
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

        while(!openedTags.isEmpty()) {
            var last = openedTags.removeLast().getTag().endTag();
            sb.append(last);
        }

        return sb.toString();
    }

    public static String prettify(String html) {
        Deque<int[]> breaks = new ArrayDeque<>(); // size 2 array where first = pos, second = depth
        int depth = 0;
        final int spacing = 4;
        StringBuilder sb = new StringBuilder(html);
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == '<') {
                if (html.charAt(i + 1) != '/')
                    breaks.add(new int[] { i, depth++ });
                else
                    breaks.add(new int[] { i, --depth });
            }
            // self closing tag case
            else if(html.charAt(i) == '/'){
                if(html.charAt(i+1) == '>')
                    --depth;
            }
            // check for text
            else if(i > 0  && html.charAt(i-1) == '>'
                    && i < html.length()-1 && html.charAt(i+1) != '<')
                breaks.add(new int[]{ i, depth });
            else
                continue;
        }

        while (!breaks.isEmpty()) {
            int[] last = breaks.removeLast();
            int position = last[0];
            int depths = last[1];
            StringBuilder newLine = new StringBuilder();
            newLine.append("\n");
            for (int i = 0; i < depths; i++) {
                newLine.append(" ".repeat(spacing));
            }
            sb.insert(position, newLine);

        }

        return sb.toString();
    }


    public Component add(Component comp, int level) {
        comp.stack.forEach( np -> np.level+= level);
        stack.addAll(comp.stack);
        return this;
    }

    public Component attributes(Map<String, String> attributesMap){
        stack.getLast().node.setAttributes(attributesMap);
        return this;
    }

    public Component attributes(String...attributesStream){
        Function<String, String> keyFunction = k -> k.substring(0, k.indexOf('='));
        Function<String, String> valuFunction = v -> v.substring(v.indexOf('=')+1);
        var map = Arrays.stream(attributesStream)
                .collect(Collectors.toMap(keyFunction, valuFunction));
        return attributes(map);
    }

    public Component text(String text){
        stack.getLast().node.setText(text);
        return this;
    }

    // Node tag methods

    public Component html(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.HTML);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component head(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.HEAD);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component body(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.BODY);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component title(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.TITLE);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component h1(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.H1);
        stack.addLast(new NodePair(level, node));
		return this;
	}

	public Component h2(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.H2);
        stack.addLast(new NodePair(level, node));
        return this;
	}

	public Component h3(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.H3);
        stack.addLast(new NodePair(level, node));
        return this;
	}

	public Component h4(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.H4);
        stack.addLast(new NodePair(level, node));
        return this;
	}

	public Component h5(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.H5);
        stack.addLast(new NodePair(level, node));
        return this;
	}

	public Component h6(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.H6);
        stack.addLast(new NodePair(level, node));
        return this;
	}

	public Component p(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.P);
        stack.addLast(new NodePair(level, node));
        return this;
	}

    public Component div(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.DIV);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component span(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.SPAN);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component ul(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.UL);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component ol(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.OL);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component li(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.LI);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component table(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.TABLE);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component tr(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.TR);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component th(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.TH);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component td(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.TD);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component thead(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.THEAD);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component tfoot(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.TFOOT);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component caption(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.CAPTION);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component img(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.IMG);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component a(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.A);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component link(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.LINK);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component form(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.FORM);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component input(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.INPUT);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component label(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.LABEL);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component button(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.BUTTON);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component textarea(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.TEXTAREA);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component i(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.I);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component u(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.U);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component em(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.EM);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component strong(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.STRONG);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component br(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.BR);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component empty(Integer level){
        HyperNode node = new HyperNode(HtmlTag.empty);
        stack.addLast(new NodePair(level, node));
        return this;
    }
}
