package Phase1project;

import java.io.IOException;
import java.util.Scanner;
public class Work1 
{ 
 public static final String path = "E:\\directory";
 Scanner in=new Scanner(System.in);
 
 public static void maindisp()
 {
	 System.out.println("----WELCOME TO FILE DIRECTORY----");
	 System.out.println("---------------------------------");
	 System.out.println("---------------------------------");
	 System.out.println("----------YOU  ARE HERE----------");
	 System.out.println("---------------------------------");
	 System.out.println(path);
	 System.out.println("---------------------------------");
	 System.out.println("---------------------------------");
 }
 
 public static void menu1()
 {
	 System.out.println("---------------------------------");
	 System.out.println("1.SHOW ALL FILES IN SORTED MANNER");
	 System.out.println("2.GO TO FILE OPTIONS");
	 System.out.println("3.EXIT OUT");
	 System.out.println("----------------------------------");
	 System.out.println("----------------------------------");
	 System.out.println("ENTER YOUR CHOICE");
	 System.out.println("ENTER NUMBERS 1 TO 3 ONLY");
	 System.out.println("-----------------------------------");
 }
 public static void menu2()
 {
	 System.out.println("---------------------------------");
	 System.out.println("1.ADD A FILE");
	 System.out.println("2.DELETE A FILE");
	 System.out.println("3.SEARCH A FILE");	 
	 System.out.println("4.READ A FILE");
	 System.out.println("5.WRITE CONTENTS TO A FILE");
	 System.out.println("6.GO BACK");
	 System.out.println("----------------------------------");
	 System.out.println("----------------------------------");
	 System.out.println("ENTER YOUR CHOICE");
	 System.out.println("ENTER NUMBERS 1 TO 6 ONLY");
	 System.out.println("-----------------------------------");
 }
 public static void exitdisp()
 {
	 System.out.println("---------------------------------");
	 System.out.println("---------------------------------");
	 System.out.println("-----------YOU ARE OUT-----------");
	 System.out.println("------------THANK YOU------------");
	 System.out.println("---------------------------------");
 }
 
 public static void menu1ops()
 {
	 int choice=0;
	 char decission=0;
	 try (Scanner in = new Scanner(System.in)) {
		Filehandle ob = new Filehandle();
		 //MENU 1 OPERATIONS ARE DONE 
		 do
		 {
			 menu1();
			  try {
				  choice=Integer.parseInt(in.nextLine());
			  }catch(NumberFormatException e){
				  System.out.println("INVALID INPUT");
				  System.out.println("ENTER NUMBERS 1 TO 3 ONLY");
				  menu1ops(); 
			  }
			   switch(choice)
			   {
			   case 1:
				   System.out.println();
					try {
						  ob.listAllFiles(path);
					}catch(NullPointerException e) {
						System.out.println(e.getMessage());
					}catch(IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("\n***********************************\n");
					break;
					
			   case 2:
				   menu2ops();
				   break;
				   
					
			   case 3:
				   System.out.println("\n Are you sure you want to exit ? ");
					System.out.println("  (Y) ==> Yes    (N) ==> No        ");
					decission = in.nextLine().toUpperCase().charAt(0);
					if(decission == 'Y') 
					{
						System.out.println("\n");
						exitdisp();
						System.exit(1);
					}else if(decission == 'N') {
						System.out.println("\n");
						menu1ops();
					}else {
						System.out.println("\nInvalid Input \nValid Inputs :(Y/N)\n");
						menu1ops();
					}
					break;
					
			   default:
					System.out.println("\nInvalid Input \nValid Input Integers:(1-3)\n");
					menu1ops();
			   }
			  
		 }while(true);
	}
 }
 //MENU 1 OPS ENDED
 public static void menu2ops()
 {
	 try (Scanner in = new Scanner(System.in)) {
		do
		 {
			 String file = null;
			 String fileName = null;
			 int choice = 0;
			 
			 menu2();
				
				try {
					choice = Integer.parseInt(in.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Invalid Input \nValid Input Integers:(1-4)");
					menu2ops();
				}
				
				
				switch (choice) {
				case 1: 
						System.out.println("\n==> Adding a File...");
						System.out.println("Please enter a file name : ");
						file = in.nextLine();
						fileName = file.trim();
						try {
							Filehandle.createNewFile(path, fileName);
						}catch(NullPointerException e) {
							System.out.println(e.getMessage());
						}catch(IOException e) {
							System.out.println("Error occurred while adding file..");
							System.out.println("Please try again...");
						}catch(Exception e) {
							System.out.println("Error occurred while adding file..");
							System.out.println("Please try again...");
						}
						System.out.println("\n**********************************\n");
						break;
						
				case 2: 
						System.out.println("\n==> Deleting a File...");
						System.out.println("Please enter a file name to Delete : ");
						file = in.nextLine();
						fileName = file.trim();
						try {
							Filehandle.deleteFile(path, file);
						}catch(NullPointerException e) {
							System.out.println(e.getMessage());
						}catch(IOException e) {
							System.out.println("Error occurred while Deleting File..");
							System.out.println("Please try again...");
						}catch(Exception e) {
							System.out.println("Error occurred while Deleting File..");
							System.out.println("Please try again...");
						}
						System.out.println("\n***********************************\n");
						break;
						
				case 3: 
						System.out.println("\n==> Searching a File...");
						System.out.println("Please enter a file name to Search : ");
						file = in.nextLine();
						fileName = file.trim();
						try {
							Filehandle.searchFile(path, fileName);
						}catch(NullPointerException e) {
							System.out.println(e.getMessage());
						}catch(IllegalArgumentException e) {
							System.out.println(e.getMessage());
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						System.out.println("\n***********************************\n");
						break;
						
				
				case 4:
					System.out.println("\n==> Reading a File...");
					System.out.println("Please enter a file name to read : ");
					file = in.nextLine();
					fileName = file.trim();
					try {
						Filehandle.readFile(fileName,path);
					}catch(NullPointerException e) {
						System.out.println(e.getMessage());
					}catch(IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("\n***********************************\n");
					
				    break;
				    
				
				
				case 5 :
					System.out.println("\n==> Writing to a File...");
					System.out.println("Please enter a file name to write : ");
					file = in.nextLine();
					fileName = file.trim();
					try {
						Filehandle.writeFile(fileName,path);
					}catch(NullPointerException e) {
						System.out.println(e.getMessage());
					}catch(IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("\n***********************************\n");
					break;
					
				case 6 :
					menu1ops();
				    break;
				    
				default:
					System.out.println("Invalid Input \nValid Input Integers:(1-4)");
					menu2ops();
					
				}
				
			file = null;
			fileName = null;
		 }while(true);
	}
 }
 public static void main(String args[])
 {

	 maindisp();
	 menu1ops();
	 	 
 }
}
