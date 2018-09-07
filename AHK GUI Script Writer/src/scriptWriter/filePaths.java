package scriptWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 *@author mothership
 *@desc Class to read system file paths from paths.exe and set the paths as public variables to pull from
 *@param pathOfAhk2Exe system path to ahk to exe converter for scripts
 *@param pathOfScripts system path to Compiled Scripts
 *@param pathOfCompiledScripts_List system path to a list of compiled scripts
 *@param pathOfNonCompiledScripts_List system path to a list of un-compiled scripts
 *@param pathOfCompileBatch system path to bat file to run ahk to exe converter for scripts
 */
public class filePaths {
	public static String pathOfAhk2Exe;
	public static String pathOfScripts;
	public static String pathOfCompiledScripts_List;
	public static String pathOfNonCompiledScripts_List;
	public static String pathOfCompileBatch;
	
	/**
	 * Reads path.txt which contains all system paths that are used
	 * @catch FileNotFoundException for path.txt
	 * @catch IOException for bufferwriter writing comment
	 */
	public static void readFilePath() {
		ArrayList < String > paths = new ArrayList < String > ();
		File f = new File("Path.txt");
	    if (!f.exists()) {
	        try {
				PrintWriter writer = new PrintWriter("Path.txt");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	
	    try (BufferedReader br = new BufferedReader(new FileReader(f))) { //Try-Catch
            String line = new String();
            while ((line = br.readLine()) != null) {
            	if (! line.startsWith("|")) {
            	int indexOf = line.indexOf('"');
            	String pathBuilder = line.substring(indexOf +1, line.length()-1);
            	paths.add(pathBuilder);
            	}
            }           	
        } catch (FileNotFoundException e) { // Catch File Not Found
            e.printStackTrace();
        } catch (IOException e) { // Catch IOExeption
            e.printStackTrace();
        }
	
	    pathOfAhk2Exe = paths.get(0);
	    pathOfScripts = paths.get(1);
	    pathOfCompiledScripts_List = paths.get(2);
	    pathOfNonCompiledScripts_List = paths.get(3);
	    pathOfCompileBatch = paths.get(4);
	    
	}
}
