package mvc;
import java.io.Serializable;
/*
Edits:
   Hiba 3/5/24: created file
   
   Christopher 3/10/24: implemented Model (MVC pattern; finished)

   Adarsh 3/10/24: fixed class header to extend Publisher class and implement Serializable interface
   
   Christopher 3/10/24: changed visibility of attributes and changed()
   
   Christopher 3/13/24: added required methods used by Utilities and imported Serializable,
   	changed() now calls notifySubs() according to Publisher-Subscriber
   	(no longer using PropertyChangeListener)
*/

public abstract class Model extends Publisher implements Serializable {
	private boolean unsavedChanges = false;
	private String fileName = null;
	
	// sets the flag to true and "fires a property change event."
	public void changed() {
		unsavedChanges = true;
		this.notifySubs();
	}
	
	public boolean getUnsavedChanges() {
		return unsavedChanges;
	}
	public void setUnsavedChanges(boolean hasChanges) {
		unsavedChanges = hasChanges;
	}
	
	public void setFileName(String fName) {
		fileName = fName;
	}
	public String getFileName() {
		return fileName;
	}
}