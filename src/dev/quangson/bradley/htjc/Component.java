package dev.quangson.bradley.htjc;

import java.util.ArrayList;
import java.util.List;

public class Component {

    private final List<HyperNode> nodes;

    public Component(List<HyperNode> nodes) {
        this.nodes = List.copyOf(nodes);
    }

    public List<HyperNode> getNodes(){
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

