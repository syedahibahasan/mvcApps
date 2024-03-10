package mvc;
import java.util.List;

/*
Edits:

    Adarsh 3/10/24: implemented AppFactory (MVC Framework: finished)

 */

public interface AppFactory {

    public Model makeModel();

    public View makeView();

    public String getTitle();

    public List<String> getHelp();

    public String about();

    public List<String> getEditCommands();

    public Command makeEditCommand(String name);


}
