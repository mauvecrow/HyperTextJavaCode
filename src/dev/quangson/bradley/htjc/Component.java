package dev.quangson.bradley.htjc;

import java.util.ArrayDeque;
import java.util.Deque;

public class Component {

    private Deque<NodePair> stack;

    private class NodePair {

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
            sb.append(node.getTag().startTag());
//			System.out.println(new String(sb));
            openedTags.addLast(node);

            // print attributes if any

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
        Integer depth = 0;
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

    //	public ComponentBuilder h1() {
//		JNode tag = new JNode().h1();
//		return this;
//	}
//
//	public ComponentBuilder h2() {
//		JNode tag = new JNode().h2();
//		return this;
//	}
//
//	public ComponentBuilder h3() {
//		JNode tag = new JNode().h3();
//		return this;
//	}
//
//	public ComponentBuilder h4() {
//		JNode tag = new JNode().h4();
//		return this;
//	}
//
//	public ComponentBuilder h5() {
//		JNode tag = new JNode().h5();
//		return this;
//	}
//
//	public ComponentBuilder h6() {
//		JNode tag = new JNode().h6();
//		return this;
//	}
//
//	public ComponentBuilder p() {
//		JNode tag = new JNode().p();
//		return this;
//	}
//
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

    public Component a(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.A);
        stack.addLast(new NodePair(level, node));
        return this;
    }

    public Component input(Integer level) {
        HyperNode node = new HyperNode(HtmlTag.INPUT);
        stack.addLast(new NodePair(level, node));
        return this;
    }

}
