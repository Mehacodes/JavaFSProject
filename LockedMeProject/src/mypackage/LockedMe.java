package mypackage;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe {
	static final String projectFilesPath="C:\\LockedMeFiles";
	static final String errorMessage="Some error occured.contact admin@lockedme.com ";
public static void main(String[] args) 
{
		Scanner obj=new Scanner(System.in);
	     int ch;
	     do {
	    	 displayMenu();
	    	 System.out.println("Enter your choice");
	    	 ch=Integer.parseInt(obj.nextLine());
	    	 switch(ch)
	    	 {
	    	 case 1:getAllFiles();
	    	 break;
	    	 case 2:createFiles();
	    	 break;
	    	 case 3:deleteFiles();
	    	 break;
	    	 case 4:searchFiles();
	    	 break;
	    	 case 5:System.exit(0);
	    	 break;
	    	 default:System.out.println("invalid option");
	    	 break;
	    	 }
	    	 
	     }
		while(ch>0);
	     obj.close();
	     }

	public static void displayMenu() {
	System.out.println("$**********************************************************$");
	System.out.println("\t\t Welcome to Locked Me.com ");
	System.out.println("\t\t Created by Meha Tamrakar Verma");
	System.out.println("$***********************************************************$");
	System.out.println("\t\t1.display all the files");
	System.out.println("\t\t2.add a file");
	System.out.println("\t\t3.delete a file");
	System.out.println("\t\t4.search a file");
	System.out.println("\t\t5.exit");
	
	
	
	
}
public static void getAllFiles()
{
	try {
	File folder = new File(projectFilesPath);
	File[] listOfFiles = folder.listFiles();
	if(listOfFiles.length==0)
		System.out.println("no files exist in the directory");
	else {
		
	
for(var l:listOfFiles) {
	System.out.println(l.getName());
	
}    
}
       }
	catch(Exception e)
	{
		System.out.println(errorMessage);
	}
}
public static void createFiles()
{
	try {
		Scanner obj=new Scanner(System.in);
		String fileName;
		System.out.println("enter filename");
		fileName=obj.nextLine();
		
		int linesCount;
		System.out.println("enter how many lines in the files:");
		linesCount=Integer.parseInt(obj.nextLine());
		
		FileWriter myWriter = new FileWriter(projectFilesPath+ "\\"+fileName);
	    
	    for(int i=1;i<=linesCount;i++)
	    {
	    	System.out.println("enter the file line");
	    	myWriter.write(obj.nextLine()+"\n");
	    	
	    	
	    }
	    System.out.println("File created sucessfully");
	    myWriter.close();
    	obj.close();
	}
		catch(Exception Ex)
		{
			System.out.println("some error occured");
		}
}
public static void deleteFiles()
{
	Scanner obj=new Scanner(System.in);
	try {
		String fileName;
		
		System.out.println("enter the filename to be deleted");
		fileName=obj.nextLine();
		
		File file = new File(projectFilesPath+ "\\"+fileName);
		if(file.exists())
		{
			file.delete();
			System.out.println("file deleted sucessfully");
		}
		else
				System.out.println("files do not exist");
	
	          
	}
	catch(Exception e)
	{
		System.out.println(errorMessage);
	}
	finally {
		obj.close();
	}
}


public static void searchFiles()
{
	Scanner obj=new Scanner(System.in);
	try {
		String fileName;
		
		System.out.println("enter the filename to be searched");
		fileName=obj.nextLine();
		File folder = new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();
		LinkedList<String>filenames=new
		LinkedList<String>();
		for(var l:listOfFiles)
			filenames.add(l.getName());
		if(filenames.contains(fileName))
			System.out.println("file is available");
		else
			System.out.println("file is not available");
		
	}
	catch(Exception e)
	{
		System.out.println(errorMessage);
	}
	finally {
		obj.close();
	}	
}
}
