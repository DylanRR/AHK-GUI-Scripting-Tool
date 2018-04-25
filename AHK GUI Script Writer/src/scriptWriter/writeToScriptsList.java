package scriptWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
	
	public static void overWriteToFile() throws IOException {
        File f = new File(filePaths.pathOfNonCompiledScripts_List); //Create file if not allready created
        FileWriter fw = new FileWriter(f, false); //New FileWriter
        fw.write(""); //Use FileWriter to wite the param<String> to txt file
        fw.close(); //Close out txt file
    }
	
	public static void pergeFromNonCompiledScripts(String s) throws IOException {
		ArrayList < String > fileList = new ArrayList < String > (); //New ArrayList <String>
		  try (BufferedReader br = new BufferedReader(new FileReader(filePaths.pathOfNonCompiledScripts_List))) { //Try-Catch
	            String line;
	            while ((line = br.readLine()) != null) {
	                if(!(line.equals(s))) {
	                	fileList.add(line);
	                }
	            }
	        } catch (FileNotFoundException e) { // Catch File Not Found
	            e.printStackTrace();
	        } catch (IOException e) { // Catch IOExeption
	            e.printStackTrace();
	        }
		  overWriteToFile();
		  
		  for(int i=0; i< fileList.size();i++) {
			  writeToCompiledScripts(fileList.get(i));
		  }
	}
}
