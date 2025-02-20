package dev.quangson.bradley.htjc;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome ot HTJC - Hyper Text Java Code!");

        var htmldoc = new Component()
                .html(1)
                .head(2)
                .body(2)
                ;

        var bodyContent = new Component()
                .div(1)
                .div(2)
                .ul(3)
                .li(4)
                .a(5)
                .li(4)
                .span(5)
                .li(4)
                .input(5)
                .div(1)
                .span(2)
                ;

        String htmlString = htmldoc.add(bodyContent,2).render();
        System.out.println(Component.prettify(htmlString));
    }
}
