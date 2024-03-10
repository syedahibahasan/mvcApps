package mvc;

/*
Edits:
   Hiba 3/5/24: created file
   
   Christopher 3/10/24: implemented Model (MVC pattern; finished)

   Adarsh 3/10/24: fixed class header to extend Publisher class and implement Serializable interface

*/

public abstract class Model extends Publisher implements Serializable {
	boolean unsavedChanges = false;
	String fileName = null;
	
	// Sets the unsavedChanges flag to true and "fires a property change event."
	void changed() {
		unsavedChanges = true;
	}

}
