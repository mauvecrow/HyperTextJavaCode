package dev.quangson.bradley.htjc;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome ot HTJC - Hyper Text Java Code!");

        var htmldoc = new Component()
                .html(1)
                .head(2)
                .body(2)
                ;

        var bodyContent = new Component()
                .div(1).attributes("id=div1", "class=container background")
                .div(2)
                .ul(3).attributes("class=list blue")
                .li(4)
                .a(5).text("click me for more details")
                .li(4)
                .span(5).text("list items are helpful")
                .li(4)
                .input(5).attributes("type=text", "value=Hi", "id=hello")
                .div(1)
                .span(2)
                ;

        String htmlString = htmldoc.add(bodyContent,2).render();
        System.out.println(Component.prettify(htmlString));
    }
}
