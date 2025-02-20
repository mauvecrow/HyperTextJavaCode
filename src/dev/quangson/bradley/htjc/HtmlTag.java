package dev.quangson.bradley.htjc;

public enum HtmlTag {

        HTML("html"), HEAD("head"),	BODY("body"), TITLE("title"),
        H1("h1"), H2("h2"),	H3("h3"),H4("h4"), H5("h5"),	H6("h6"),
        P("p"), DIV("div"),	SPAN("span"),
        UL("ul"), OL("ol"),	LI("li"),
        TABLE("table"),	TR("tr"), TD("td"),	TH("th"), THEAD("th"), TFOOT("tf"), CAPTION("caption"),
        IMG("img", true),
        A("a"), LINK("link", true),
        FORM("form"), INPUT("input", true), LABEL("label"), BUTTON("button"),	TEXTAREA("textarea"),
        I("i"),	U("u"), EM("em"), STRONG("strong"),
        BR("br", true),
        empty("empty", true);

        private final String tag;
        private final boolean selfClosing;

        HtmlTag(String string) {
            tag = string;
            selfClosing = false;
        }

        HtmlTag(String tag, boolean flag){
            this.tag = tag;
            selfClosing = flag;
        }


        public String endTag() {
            return !selfClosing ? "</" + tag + ">" : "";
        }

        public String openStartTag(){
            return !tag.equals("empty") ? "<" + tag + " " : "";
        }

        public String closeStartTag(){
            return !tag.equals("empty") ? !selfClosing ? ">" : "/>" : "";
    }
}
