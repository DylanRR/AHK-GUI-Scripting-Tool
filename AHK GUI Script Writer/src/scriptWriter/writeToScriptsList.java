package scriptWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class writeToScriptsList {

	
	public static void writeToCompiledScripts(String s) throws IOException {
        File f = new File(filePaths.pathOfCompiledScripts_List); //Create file if not allready created
        FileWriter fw = new FileWriter(f, false); //New FileWriter
        fw.write(s + System.getProperty("line.separator")); //Use FileWriter to wite the param<String> to txt file
        fw.close(); //Close out txt file
    }
	
	public static void writeToNonCompiledScripts(String s) throws IOException {
        File f = new File(filePaths.pathOfNonCompiledScripts_List); //Create file if not allready created
        FileWriter fw = new FileWriter(f, false); //New FileWriter
        fw.write(s + System.getProperty("line.separator")); //Use FileWriter to wite the param<String> to txt file
        fw.close(); //Close out txt file
    }
}
