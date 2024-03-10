package mvc;

/*
Edits:
   Hiba 3/5/24: created file
   
   Christopher 3/10/24: implemented Model (MVC pattern; finished)
*/

public abstract class Model {
	boolean unsavedChanges = false;
	String fileName = null;
	
	// Sets the unsavedChanges flag to true and "fires a property change event."
	void changed() {
		unsavedChanges = true;
	}

}
