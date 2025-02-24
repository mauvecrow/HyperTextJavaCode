package dev.quangson.bradley.htjc;

import custom.components.LoginComponent;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome ot HTJC - Hyper Text Java Code!");

        var htmldoc = new ComponentBuilder()
                .html(1)
                .head(2)
                .body(2)
                ;

        var bodyContent = new ComponentBuilder()
                .div(1).attributes("id=div1", "class=container background")
                .div(2)
                .ul(3).attributes("class=list blue")
                .li(4).text("this is ").strong(5).text("SO").em(5).text("cool!") .empty(5).text(" amirite?")
                .a(5).text("click me for more details")
                .li(4)
                .span(5).text("list items are helpful")
                .li(4)
                .input(5).attributes("type=text", "value=Hi", "id=hello")
                .div(1)
                .span(2)
                ;

        String htmlString = htmldoc.add(bodyContent,2)
                .build()
                .render();

        System.out.println(htmlString);
        System.out.println(Components.prettify(htmlString));

        var listItem = new ComponentBuilder()
                .li(1).span(2).text("item")
                .build();

        var listItems = Components.repeat(3, listItem);
        var parentList = new ComponentBuilder().ul(1).build();
        var list = Components.add(parentList, listItems,1);
        System.out.println(list.render());
        System.out.println(Components.prettify(list.render()));

        LoginComponent login = new LoginComponent();
        System.out.println(Components.prettify(login.render()));

        Model m = new Model("Mercedes", 4, new String[]{"bharain", "australia","monaco"});
        ComponentBuilder races = new ComponentBuilder();
        for(String race : m.arr){
            races.li(1).span(2).text(race);
        }
        var raceList = new ComponentBuilder()
                .ul(1)
                .add(races, 1)
                .build();


        System.out.println(raceList.render());
        System.out.println(races.build().render());
    }

    record Model(String name, int num, String[] arr){}
}
