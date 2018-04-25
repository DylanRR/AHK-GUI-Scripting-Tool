package scriptWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class filePaths {
	public static String pathOfAhk2Exe;
	public static String pathOfScripts;
	public static String pathOfCompiledScripts_List;
	public static String pathOfNonCompiledScripts_List;
	public static String pathOfCompileBatch;
	
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
