package dev.quangson.bradley.htjc;

import java.util.ArrayDeque;
import java.util.Deque;

public class Components {

    public static Component add(Component baseComp, Component addingComp, int level) {
        addingComp.getStack().forEach( np -> np.level+= level);
        baseComp.getStack().addAll(addingComp.getStack());
        return baseComp;
    }

    public static Component repeat(int repetitions, Component baseComp){
        var newComp = new Component();
        for(int i = 0; i < repetitions; i++){
            var copyComp = new Component(baseComp);
            newComp.getStack().addAll(copyComp.getStack());
        }
        return newComp;
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
}
