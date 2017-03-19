package hw2.pkg1.pkg0;

import java.io.*;
import java.util.*;

public class HW210 {
    
    Scanner scanner = new Scanner(System.in);
    
    String getFileAddr(String st){
        
        //System.out.println("Enter file address: ");
        //String file_addr = scanner.nextLine();
        //String file_addr = "C:/Users/KAREL/Desktop/Folder/a";
        String file_addr = st;
        return file_addr;
    }
        
    List<String> getFileName(String st){
        
        //System.out.println("Enter search term name(s): ");
        //String file_name = scanner.nextLine();
        //String file_name = "clueweb12-0000wt-02-00010,foo,clueweb12-0000wt-02-00101,"
                //+ "clueweb12-0000wt-02-00002,foo,foo,clueweb12-0000tw-36-00433,clueweb12-0000tw-36-01212,"
               // + "clueweb12-0000wb-31-01035,clueweb12-0000wb-31-01392,clueweb12-0000wt-02-01344,foo";
        String file_name = st;
        ArrayList<String> docIDs = new ArrayList<String>(Arrays.asList(file_name.split(",")));

        return docIDs;
    }
    
    
    public void search(List<String> docID, String fileAddr){
       File path = new File(fileAddr);
       File [] files = path.listFiles();
       boolean flag = false;
       List<String> results = new ArrayList<String>();
       
        for (String searchTerm : docID){
            String a = "-1";
           for (File a_file : files){ 
               
                BufferedReader br = null;
                try{	
                    br = new BufferedReader(new FileReader(a_file));		

                       //System.out.println("Searching for "+searchTerm+" in "+a_file);
                       String contentLine = br.readLine();
                            while (contentLine != null) {     
                             contentLine = contentLine.trim();
                             String[] x = contentLine.split(" ");
                            // System.out.println(x[0] +" and "+x[1]);
                             String str = x[0];
                             String str2 = x[1];
                              //String str = contentLine.substring(3,28);
                              //String str2 = contentLine.substring(0,2);
                                   if (searchTerm.equals(str2)){
                                     a = str;
                                     flag = true;
                                   }
                                   
                                contentLine = br.readLine();
                                }
                    } 
                catch (IOException ioe) 
                    {
                    ioe.printStackTrace();
                    } 
                finally 
                   {
                    try {
                       if (br != null)
                            br.close();
                        } 
                    catch (IOException ioe) 
                    {
                        System.out.println("Error in closing the reader");
                    }
                    }
                
           }
         if (flag==true){
             results.add(a);}
         else if (flag==false){
             results.add("-1");}    
         }  
        
    System.out.println(results);
    }    
    
   public static void main(String[] args) {
       
       if (args.length < 2) {
            System.out.println("Please enter directory path and search terms");
            System.out.println("Format: program file_path search_terms");
            return;
        }else{
            String file_name = args[1];
            String file_addr = args[0];
            HW210 rfd = new HW210();
            
            rfd.search(rfd.getFileName(file_name), rfd.getFileAddr(file_addr));
       
   }
}
   
}
//"/home/yazid/NetBeansProjects/A/src/readfiledemo/"
//"newfile.txt"
//waterloo-spam-cw12-decoded
//cw12-0000tw.txt,cw12-0000wt.txt,cw12-0001wb.txt
///home/yazid/Downloads/waterloo-spam-cw12-decoded/
///home/yazid/NetBeansProjects/a/src/a/
// 123,223,823,923
// cw12-0000wt.txt
// C:/Users/KAREL/Desktop/Folder/a
//clueweb12-0000wt-02-00000,foo,clueweb12-0000wt-02-00001,clueweb12-0000wt-02-00002,foo,foo
//,clueweb12-0000wt-02-00003,clueweb12-0000wt-02-00004,clueweb12-0000wt-02-00005
//,clueweb12-0000wt-02-00006, clueweb12-0000wt-02-00007
/* clueweb12-0000wt-02-00010,foo,clueweb12-0000wt-02-00101,clueweb12-0000wt-02-00002,foo,foo,clueweb12-0000tw-36-00433,clueweb12-0000tw-36-01212,clueweb12-0000wb-31-01035,clueweb12-0000wb-31-01392,clueweb12-0000wt-02-01344,foo*/
