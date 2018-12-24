import java.io.*;
import java.util.*;

class Bayesian
{
     
    public static void main(String args[])
     {
	   Scanner src = new Scanner (System.in);
	    int match=0;
		int total=0;
		int fp=0,fn=0;
		double ratio=0;
	   String ip[][]= new String [1758][7];
	   String ou[]= new String [7];
	   int count=0;
	   int c=0;
         String x,x1;
       try{
        FileInputStream f = new FileInputStream("merged_log.txt");
        InputStreamReader isr = new InputStreamReader(f);
        BufferedReader bf= new BufferedReader(isr);
          x=bf.readLine();
          x=bf.readLine();
		  do{
		      
		   StringTokenizer str = new StringTokenizer(x);
		     ip[count][c]=str.nextToken();
			  c++;
			 ip[count][c]=str.nextToken();
			    c++;
			 ip[count][c]=str.nextToken();
			     c++;
			 ip[count][c]=str.nextToken();
			     c++;
			 ip[count][c]=str.nextToken();
			     c++;
		     ip[count][c]=str.nextToken();
			   c++;
		     ip[count][c]=str.nextToken();
			   c=0;
			   count++;
			   x=bf.readLine();
			  }while(x!=null);
		  }
		  catch (Exception e){}
		  
			  
			 /*System.out.println("Message sent//sec");
			  String ms = src.next();
			 System.out.println("Message?");
			  String msg = src.next();
			  System.out.println("Echo?");
			  String echo = src.next();
			  System.out.println("Memory?");
			  String mem = src.next();
			  System.out.println("Processor?");
			  String pro = src.next();*/
				c=0;
				try{
				//System.out.println(total);
        FileInputStream f = new FileInputStream("testing_log.txt");
        InputStreamReader isr = new InputStreamReader(f);
        BufferedReader bf= new BufferedReader(isr);
          x1=bf.readLine();
          x1=bf.readLine();
		  do{
		      
		   StringTokenizer str = new StringTokenizer(x1);
		       ou[c]=str.nextToken();
			  c++;
			 ou[c]=str.nextToken();
			    c++;
			 ou[c]=str.nextToken();
			     c++;
			 ou[c]=str.nextToken();
			     c++;
			 ou[c]=str.nextToken();
			     c++;
		     ou[c]=str.nextToken();
			   c++;
		     ou[c]=str.nextToken();
			   c=0;
			   //count++;
			   x1=bf.readLine();
			  
		  
			  int ms_yes=0;
			  int ms_no=0;
			  int msg_yes=0;
			  int msg_no=0;
			  int echo_yes=0;
			  int echo_no=0;
			  int mem_yes=0;
			  int mem_no=0;
			  int pro_yes=0;
			  int pro_no=0;
			  int yes=0;
			  int no=0;
			  for(int i=0;i<1757;i++)
			    if(ip[i][6].equals("yes"))
				   yes++;
				else
				  no++;
			  
			  //System.out.println("Yes="+yes+"   No="+no);
				    x = ou[1];
				  int b=1;
				double probab_yes = (double) yes / 1757.0;
 				double probab_no = (double) no / 1757.0;
				
				 /*System.out.println("Probability of yes "+ probab_yes);
				 System.out.println("Probability of no "+ probab_no);*/
				 
				  //for Message_sent/sec
				 for(int i=0;i<1757;i++)
				  {
  				  if(ip[i][b].equals(x) && ip[i][6].equals("yes"))
				     ms_yes++;
				  else if(ip[i][b].equals(x) && ip[i][6].equals("no"))
				     ms_no++;
				  }
				  //System.out.println("ms_yes="+ms_yes +"  ms_no="+ms_no);
				  b++;
				   x=ou[2];
				  //for Message/sec
				   for(int i=0;i<1757;i++)
				  {
  				  if(ip[i][b].equals(x) && ip[i][6].equals("yes"))
				     msg_yes++;
				  else if(ip[i][b].equals(x) && ip[i][6].equals("no"))
				     msg_no++;
				  }
				  //System.out.println("msg_yes="+msg_yes +"  msg_no="+msg_no);
				  b++;
				  x=ou[3];
				  //for Echo/sec
				   for(int i=0;i<1757;i++)
				  {
  				  if(ip[i][b].equals(x) && ip[i][6].equals("yes"))
				     echo_yes++;
				  else if(ip[i][b].equals(x) && ip[i][6].equals("no"))
				     echo_no++;
				  }
				  //System.out.println("echo_yes="+echo_yes +"  echo_no="+echo_no);
				  b++;
				  x=ou[4];
				   for(int i=0;i<1757;i++)
				  {
  				  if(ip[i][b].equals(x) && ip[i][6].equals("yes"))
				     mem_yes++;
				  else if(ip[i][b].equals(x) && ip[i][6].equals("no"))
				     mem_no++;
				  }
				  //System.out.println("mem_yes="+mem_yes +"  mem_no="+mem_no);
				    b++;
				  x=ou[5];
				   for(int i=0;i<1757;i++)
				  {
  				  if(ip[i][b].equals(x) && ip[i][6].equals("yes"))
				     pro_yes++;
				  else if(ip[i][b].equals(x) && ip[i][6].equals("no"))
				     pro_no++;
				  }
				  //System.out.println("pro_yes="+pro_yes +"  pro_no="+pro_no);
				  //for "yes"
				      
				  double p_yes = ((double)ms_yes * (double)msg_yes * (double)echo_yes * (double)mem_yes * (double)pro_yes )/(double)(yes*yes*yes*yes*yes);
				  double p_no =  ((double)ms_no * (double)msg_no * (double)echo_no * (double)mem_no * (double)pro_no )/(double)Math.pow(no,5);
				  
				  double yes_x = p_yes * probab_yes;
				  double no_x = p_no* probab_no;
				 /* System.out.println("p_yes  = "+ p_yes);
				  System.out.println("p_no  = "+ p_no);
				  System.out.println(" P(C1/X) = "+ yes_x);
				  System.out.println(" P(C2/X) = "+ no_x);*/
				  
				  if(yes_x>no_x)
				    {
					//System.out.println("Worm = YES ");
					//System.out.println(ou[0]+" ");
					
					  if(ou[6].equals("yes"))
					    match++;
					  
					}
					
			      else 
				    {
					  if(ou[6].equals("no"))
					   match++;
					 }
				  if(ou[6].equals("yes") &&  yes_x<no_x)
				    {
					 fn++;
					  System.out.println(ou[0]+" "+ou[1]+" "+ou[2]+" "+ou[3]+" "+ou[4]+" "+ou[5]+" "+ou[6]);
					}
					
				  if(ou[6].equals("no") && yes_x>no_x)
				    {
					fp++;
					 System.out.println(ou[0]+" "+ou[1]+" "+ou[2]+" "+ou[3]+" "+ou[4]+" "+ou[5]+" "+ou[6]);
					}
					total++;
					}while(x1!=null);
		  }
		    catch(Exception  e){}
			System.out.println("Total="+ total+" Match = "+match);
			System.out.println("Ratio = "+(double)match/(double)total);
			System.out.println("FP= "+(double)fp/(double)total);
			System.out.println("FN= "+(double)fn/(double)total);
         }//main
	}//class
				   
				   
					 
				  
			 
			  
			 
			  
			 
		   