//Import the required Java IO Resources
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RecurseThroughDir {

	public static void main(String[] args) throws IOException{
		//Create Scanner Object named userInput
		Scanner userInput = new Scanner(System.in);
		//Prinout cursor prompt
		System.out.println("=========================================================");
		System.out.println("= Please Enter Directory to be Recursively Printed out. =");
		System.out.println("=========================================================");
		System.out.print("> ");
		//Set the String variable directorySelection to the nextLine from the scanner object.
		String directorySelection = userInput.nextLine();
		//Create a File object with the directorySelection string as it directory.
		File currentSelectedDir = new File(directorySelection);
		//Check is the File object currentSelectedDir is an actual directory
		if(currentSelectedDir.exists())
		{
			/*
			 * If the directory is valid then call the printListedDirectory method 
			 * to recurse through the directory and print all of the files 
			 * and directories as an output.
			 */
			printListedDirectory(currentSelectedDir);
		}
		else
		{
			System.out.println("Error: Not a valid directory.");
			//If the given directory was not valid then print an error message.
		}
	} //end of main method
	
	/**
	 * This method serves as a "separator" method that prevents possible
	 * printout errors between the user's programming and the actual
	 * printout, this is due to the method setting the default parameter
	 * for levelDir to zero in the first iteration and call of the recursive
	 * listAllInDirectory() method.
	 * @param dirPath This is the File object that is passed into the method
	 * which is parsed into lastAllInDirectory for the acutal recursion
	 * @throws IOException throws exception if an IO error is found.
	 */
	public static void printListedDirectory(File dirPath) throws IOException
	{
		//set the directory levelDir parameter to zero for the first call.
		listAllInDirectory(dirPath, 0);
	}

	/**
	 * This method Recursively printout all directory and files within the 
	 * given directory file object parameter and directory level variable.
	 * 
	 * This method can be directly called however it is required that
	 * the directory levelDir variable that controlled for indendation is
	 * set to zero.
	 * @param directoryPath This is the file object that is used to printout 
	 * all of the recursed data. 
	 * @param level This is the variable that defines the current levelDir of directory
	 * processing given. 
	 * @throws IOException IOException throws exception if an IO error is found.
	 */
	public static void listAllInDirectory(File directoryPath, int levelDir) throws IOException {
		//Create a file object to store all of the list files from directoryPath
	    File[] primaryLevelFiles = directoryPath.listFiles();
	    //If the primaryLevelFiles does not equal null and have a length above zero. 
	    if(primaryLevelFiles != null && primaryLevelFiles.length > 0) {
	    	//for every iterated object in aGivenFile through primaryLevelFiles
	        for(File aGivenFile : primaryLevelFiles) {
	        	//for 0 to levelDir (this controlled indentation between directory levels)
	            for(int i = 0; i < levelDir; i++) { //controll for directory level tabs
	            	//printout a tab
	                System.out.print("\t");
	            }
	            //If the object in aGivenFile is a directory
	            if(aGivenFile.isDirectory()) {
	            	//printout directory name
	                System.out.println(aGivenFile.getName());
	                //update the object aGivenFile's absoluteFile to aGivenFile's absolute file path.
	                aGivenFile = aGivenFile.getAbsoluteFile();
	                //Recurse the method with the updated aGivenFile and the incramented levelDir variable. 
	                listAllInDirectory(aGivenFile, (levelDir+1));
	                //The base case is completed when there no more directories/files to recurse through.
	            } 
	            else 
	            {
	            	//printout the name of the file since the current object is not a directory. 
	                System.out.println(aGivenFile.getName());
	            } //end of else
	        } //end of for loop
	    } //end of if loop
	} //end of method
	
} //end of class
