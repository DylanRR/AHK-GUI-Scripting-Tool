package scriptWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class filePaths {
	public static String ahk2ExePath;
	
	public static ArrayList<String> readFilePath() {
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
            	Pattern SearchPattern = Pattern.compile("\".*\"");
            	Matcher MatchString = SearchPattern.matcher(line);
            	while(MatchString.find()) {
            		System.out.println("Matching String" + MatchString.group());
            	}
            	
        } catch (FileNotFoundException e) { // Catch File Not Found
            e.printStackTrace();
        } catch (IOException e) { // Catch IOExeption
            e.printStackTrace();
        }
	
	return paths;
	}
	
	public static void main(String[] args) {
		readFilePath();
		System.out.println(ahk2ExePath);
	}
}
