package dev.quangson.bradley.htjc;

import java.util.ArrayList;
import java.util.List;

public class Components {

    public static Component add(Component baseComp, Component addingComp, int level) {
        var copyBaseComp = new ComponentBuilder(baseComp);
        var copyAddingComp = new ComponentBuilder(addingComp);
        copyBaseComp.add(copyAddingComp, level);
        return copyBaseComp.build();
    }

    public static Component repeat(int repetitions, Component baseComp){
        var newComp = new ComponentBuilder();
        for(int i = 0; i < repetitions; i++){
            var copyComp = new ComponentBuilder(baseComp);
            newComp.add(copyComp, 0);
        }
        return newComp.build();
    }

    public static String prettify(String html) {
        List<int[]> breaks = new ArrayList<>(); // size 2 array where first = pos, second = depth
        int depth = 1;
        final int spacing = 4;
        StringBuilder sb = new StringBuilder(html);
        for (int i = 1; i < html.length(); i++) {
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
            else if(i > 1  && html.charAt(i-1) == '>'
                    && i < html.length()-1 && html.charAt(i+1) != '<')
                breaks.add(new int[]{ i, depth });

        }

        while (!breaks.isEmpty()) {
            int[] last = breaks.removeLast();
            int position = last[0];
            int depths = last[1];
            StringBuilder newLine = new StringBuilder();
            newLine.append("\n");
            newLine.append(" ".repeat(spacing * depths));
            sb.insert(position, newLine);

        }

        return sb.toString();
    }
}
