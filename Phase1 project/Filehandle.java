package Phase1project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filehandle
{
	
         public void listAllFiles(String path)
         {
		
		if (path == null || path.isEmpty() || path.isBlank())
			throw new NullPointerException("Path cannot be Empty or null");
			
		
		File dir = new File(path);
		
		if(!dir.exists())
			throw new IllegalArgumentException("Path does not exist");
		
		if(dir.isFile())
			throw new IllegalArgumentException("The given path is a file. A directory is expected.");
		
		
		
		String files[] = dir.list();
		System.out.println("\n***********************************");
		
		if(files != null && files.length > 0) {
			
			Set<String>filesList = new TreeSet<String>(Arrays.asList(files)); 
			System.out.println("The Files in "+ dir.getAbsolutePath() + " are: \n");
			
			for(String file1:files) {
				
				System.out.println(file1);
				
			}
			
			System.out.println("\nTotal Number of files: "+ filesList.size());	
		}else {
			
			System.out.println("Directory is Empty");
		}
		
	}
	
	
	   public static void createNewFile(String path , String fileName) throws IOException
	
	   
	   {
		   
		
		if (path == null || path.isEmpty() || path.isBlank())
			throw new NullPointerException("Path cannot be Empty or null");
	
		
		if (fileName == null || fileName.isEmpty() || fileName.isBlank())
			throw new NullPointerException("File Name cannot be Empty or null");
		
		File newFile = new File(path + File.separator + fileName);
		
		boolean createFile = newFile.createNewFile();
		
		if (createFile) {
			
			System.out.println("\nFile Successfully Created: " + newFile.getAbsolutePath());
			
		}else if(!createFile) {
			
			System.out.println("\nFile Already Exist.. Please try again." );
			
		}
		
			
	}
	
	
	
        public static void deleteFile(String path , String fileName) throws IOException 
        {
		
		if (path == null || path.isEmpty() || path.isBlank())
			throw new NullPointerException("Path cannot be Empty or null");
		
		
		if (fileName == null || fileName.isEmpty() || fileName.isBlank())
			throw new NullPointerException("File Name cannot be Empty or null");
		
		File newFile = new File(path + File.separator + fileName);
		
		boolean deleteFile = newFile.delete();
		
		if (deleteFile) {
			
			System.out.println("\nFile deleted Successfully");
			
		}else {
			
			System.out.println("\nFile Not Found.. Please try again." );
			
		}
			
	}
	


        public static void searchFile(String path , String fileName)
        {
		
		if (path == null || path.isEmpty() || path.isBlank())
			throw new NullPointerException("Path cannot be Empty or null");
		
		
		if (fileName == null || fileName.isEmpty() || fileName.isBlank())
			throw new NullPointerException("File Name cannot be Empty or null");
		
		File dir = new File(path);
		
		if(!dir.exists())
			throw new IllegalArgumentException("Path does not exist");
		
		if(dir.isFile())
			throw new IllegalArgumentException("The given path is a file. A directory is expected.");
		
		
		String [] fileList = dir.list();
		boolean flag = false;
		
		Pattern pat = Pattern.compile(fileName);
		
		if(fileList != null && fileList.length > 0) {
			for(String file:fileList) {
				Matcher mat = pat.matcher(file);
				if(mat.matches()) {
					System.out.println("File Found at location: " + dir.getAbsolutePath());
					flag = true;
					break;
				}
			}
		}
		
		if(flag == false)
			System.out.println("File Not Found.. Please try again.");
		
			
	}
        
        public static void readFile(String filename,String path)
        {
        	File myFile = new File(path + File.separator + filename);
        	System.out.println("-------------------------------------");
        	System.out.println("---------------CONTENTS :------------");
            try {
                Scanner sc = new Scanner(myFile);
                while(sc.hasNextLine()){
                    String line = sc.nextLine();
                    System.out.println(line);
                }
                System.out.println("-------------------------------------");
                System.out.println("READING :-> SUCCESSFUL");
                System.out.println("-------------------------------------");
                sc.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("------------------------------------");
                System.out.println("READING :-> FAILED");
                System.out.println("------------------------------------");

            }
                
        }
       
        	public static void writeFile(String filename,String path)
        	{
        		File myFile = new File(path + File.separator + filename);
        		
        	 try
        	   {
        		 
        	         Scanner in = new Scanner(System.in);
        	         System.out.println("------------------------------");
        	         System.out.println("***** START WRITING *****");
        	         String Str = in.nextLine();
        	         FileOutputStream fileout = new FileOutputStream(myFile);
        	         byte b[] = Str.getBytes();
        	         fileout.write(b);
        	         System.out.println("------------------------------");
        	         fileout.close();
        	         System.out.println("*************************************");
        	         System.out.println("WRITING :-> SUCCESSFUL");
        	         System.out.println("*************************************");
        	  }
        	 catch(Exception e)
        	 {
        		 
        	     System.out.println(e);
        	     System.out.println("*************************************");
        	     System.out.println("WRITING :-> FAILED");
        	     System.out.println("*************************************");
        	 }
        	 
        }
}

    		
        

