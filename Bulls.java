/*This is a program to play the game of Cows and Bulls using a number of 4 digits.
 *This program sends a 4 digit number to a server as a "guess".
 *If a digit in the number guessed matches with a digit in the number being guessed but the position doesn't match,
 *then it becomes a cow.
 *If both the position and the digit matches, it becomes a bull.
 *The server in turn sends back two numbers. The first one being the number of bulls and 
 *the second one being the number of cows.
 *Based on this data, the number that is stored in the server will be guessed correctly.
 *Repetition of numbers is not allowed
 */
import java.util.Scanner;

public class Bulls{
  public static void main(String args[]){
  
          int sum=0,count=0,j;
          
          Scanner in=new Scanner(System.in);
          String s;
          int flag=0;
          
          //Array to store the final answer i.e the four digit number
          int output[]=new int[4];
          
          for(int i=1;i<=9;i++){
          
              //Creating a 4 digit number having same digits
              int x=(1000*i)+(100*i)+(10*i)+(1*i);
              
              sum=0;
              flag=0;
              
              //Output to the server
              System.out.println(x);
              
              //Splitting the number into 4 numbers of single digits
              int temp[]={i,i,i,i};
              
              //if a bull is received from the server,find the bull position by changing the digits
              if(in.nextInt()==1){
                      for(j=0;j<4;j++){
                      temp[3-j]=0;
                      sum=0;
                      
                      //Creating the new 4 digit number with one of it's digit changed
                      for(int k=4;k>0;k--)
                      sum+=(temp[4-k]*Math.pow(10,k-1));
                      
                      //Send the new number to the server  
                      System.out.println(sum);
                      
                      int n=in.nextInt();
                      
                      //Check whether the Bull value has become 0
                      //If yes, store the position.It is the correct digit
                      //Else, change the other digit and check again
                      if(in.nextInt()==0){
                        flag=1;
                        break;
                      }
                  }
                  if(flag==1){
                    count++;
                    output[j]=i;
                  }
                }
                
                //Check whether all the digits have been guessed
                if(count==4)break;
                in.nextInt();
            }
           
           //Convert the output array have 4 digits into a single number of 4 digits.
           sum=0;
           for(int i=3;i>=0;i--)
           sum+=output[i]*Math.pow(10,i);
           System.out.println(sum);
    }
}
        
                        
                      
                      