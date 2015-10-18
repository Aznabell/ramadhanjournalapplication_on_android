package pklapp.ramadhanjournal;

import java.util.HashMap;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class GlobalDataClass {

	// Shared Preferences
    SharedPreferences pref;
     
    // Editor for Shared preferences
    Editor editor;
     
    // Context
    Context _context;
     
    // Shared pref mode
    int PRIVATE_MODE = 0;
     
    // Sharedpref file name
    private static final String PREF_NAME = "GlobalDataPref";
      
    // id (make variable public to access from outside)
    public static final String KEY_ID = "id";
     
    // Constructor
    public GlobalDataClass(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    
    public void createIDSession(int id){
        // Storing name in pref
        editor.putInt(KEY_ID, id);
         
        // commit changes
        editor.commit();
    }
    
    public int getSessionID(){
    	int sessionID = pref.getInt(KEY_ID, 1);
    	return sessionID;
    }
    
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user id
        user.put(KEY_ID, pref.getString(KEY_ID, null));
         
        // return user
        return user;
    }
}
