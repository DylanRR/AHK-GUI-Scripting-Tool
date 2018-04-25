package scriptWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ahkToExeCompiler {
	
		 public static void writeToFile(String s) throws IOException {
		        File f = new File("compile.bat"); //Create file if not allready created
		        FileWriter fw = new FileWriter(f, true); //New FileWriter
		        fw.write(s + System.getProperty("line.separator")); //Use FileWriter to wite the param<String> to txt file
		        fw.close(); //Close out txt file
		    }
		 
		 public static void compileAhk(String nameOfAhk) throws IOException {
			 filePaths.readFilePath();
			 writeToFile("@echo off");
			 writeToFile("cd " + filePaths.pathOfAhk2Exe);
			 writeToFile("Ahk2Exe.exe /in \"" + filePaths.pathOfScripts + nameOfAhk + ".ahk"); // TODO prompt user for Script name and pass here
			 writeToScriptsList.writeToCompiledScripts(nameOfAhk + ".ahk");
		 }
}
