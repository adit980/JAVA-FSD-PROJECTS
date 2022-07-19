package assign;
import java.util.ArrayList;
import java.util.Scanner;

public class Emailvalidation
{

    public static void main(String[] args)
    {
        
        //arrray list to store email ids
    	ArrayList<String> emailID = new ArrayList<String>();
        int f=0,c=0;
        
        emailID.add("max.blake520@fbz.com");
        emailID.add("rony34422@tlc.com");
        emailID.add("reena.josh11@yahi.com");
        emailID.add("spiderman230@gml.com");
        emailID.add("harrypottr232@hogw.com");
        emailID.add("leomessi10@gix.com");
        emailID.add("admax_23@gmi.com");
        emailID.add("madmaxx980@ply.com");
        emailID.add("batman223@ork.com");
        emailID.add("network360@jig.com");
        
        //string to take input from user
         String echeck = null;
         //loop to reenter value if null is passed by user
         do {
        	 System.out.println("Enter the email to search");
             Scanner in = new Scanner(System.in);
             echeck = in.nextLine();
               
               if (echeck.length()==0) 
               
                    System.out.println("You haven't entered an email");
               else
               {
            	   f=1;
            	   break;
               }
               
         }
         while(f!=1);
         //for loop to access value store in array string list
           for (String eloop : emailID)
           {
        	   if (eloop.equals(echeck))
        	   { 
        	      System.out.println(eloop +" is present");
        	      c=1;
        	      break;
        	   }
        	      
        	}
           // c is a flag to check if value was present in list or not.
           if (c==0)
        	   System.out.println("NOT PRESENT");
                 
    }

    }

