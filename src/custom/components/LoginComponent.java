package custom.components;

import dev.quangson.bradley.htjc.Component;
import dev.quangson.bradley.htjc.ComponentBuilder;
import dev.quangson.bradley.htjc.HyperNode;

import java.util.List;

public final class LoginComponent extends Component{

    public LoginComponent() {
        super(initialize());
    }

    private static List<HyperNode> initialize(){
        return new ComponentBuilder()
                .div(1).attributes("class=container login")
                .h1(2).text("Login")
                .div(2).attributes("class=container form")
                .form(3).attributes("method=post", "action=/")
                .label(4).text("Username").attributes("for=username")
                .input(4).attributes("type=text", "name=formUsername", "id=username")
                .label(4).text("Password").attributes("for=password")
                .input(4).attributes("type=text", "name=formPassword", "id=password")
                .div(4).attributes("class=row")
                .button(5).text("Login").attributes("class=button")
                .a(5).text("Cancel").attributes("class=button")
                .getNodes()
                ;
    }
}
