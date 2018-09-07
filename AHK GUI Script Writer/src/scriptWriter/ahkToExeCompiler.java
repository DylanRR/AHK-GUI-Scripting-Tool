package scriptWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ahkToExeCompiler {
			/**
			 * 
			 * @param s String you wish to write to CompileBatch
			 * @throws IOException
			 */
		 public static void writeToFile(String s) throws IOException {
		        File f = new File(filePaths.pathOfCompileBatch); //Create file if not allready created
		        FileWriter fw = new FileWriter(f, true); //New FileWriter
		        fw.write(s + System.getProperty("line.separator")); //Use FileWriter to wite the param<String> to txt file
		        fw.close(); //Close out txt file
		    }
		 /**
		  * @desc Overwrites and makes the CompileBatch file blank
		  * @throws IOException
		  */
		 public static void overWriteToFile() throws IOException {
		        File f = new File(filePaths.pathOfCompileBatch); //Create file if not allready created
		        FileWriter fw = new FileWriter(f, false); //New FileWriter
		        fw.write(""); //Use FileWriter to wite the param<String> to txt file
		        fw.close(); //Close out txt file
		    }
		 /**
		  * @desc Sets up the batch file to use proper syntax for the command line tool aswell as setting the name you want for the ahk file
		  * @param nameOfAhk Name you wish for ahk file
		  * @throws IOException
		  */
		 public static void compileAhk(String nameOfAhk) throws IOException {
			 filePaths.readFilePath();
			 overWriteToFile();
			 writeToFile("@echo off");
			 writeToFile("cd " + filePaths.pathOfAhk2Exe);
			 writeToFile("Ahk2Exe.exe /in \"" + filePaths.pathOfScripts + nameOfAhk + ".ahk"); // TODO prompt user for Script name and pass here
			 writeToScriptsList.writeToCompiledScripts(nameOfAhk);
			 
		        try {
		            Process p2 = Runtime.getRuntime().exec(filePaths.pathOfCompileBatch);     
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		 }
		/* 
		 public static void main(String[] args) throws IOException {
			 compileAhk("Test1");
		 }
		//*/ 
}
