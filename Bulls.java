  import java.util.Scanner;
    public class Bulls{
      public static void main(String args[]){
          int v,mid,low,high,sum=0;int count=0;
          Scanner in=new Scanner(System.in);int j,z=0;
          int a[]={1111,2222,3333,4444,5555,6666,7777,8888,9999};String s;int flag=0;int output[]=new int[4];//int temp=new int[4];
          for(int i=1;i<=9;i++){
              int x=(1000*i)+(100*i)+(10*i)+(1*i);
              sum=0;flag=0;
              System.out.println(x);
              int temp[]={i,i,i,i};
              if(in.nextInt()==1){
                  //in.nextInt();
                  for(j=0;j<4;j++){
                      temp[3-j]=0;
                      sum=0;
                      for(int k=4;k>0;k--)
                        sum+=(temp[4-k]*Math.pow(10,k-1));
                        //if(sum==3) System.out.println("Hi");
                       //if(j==0) System.out.print(z);
                      System.out.println(sum);
                      
                      int n=in.nextInt();
                      if(in.nextInt()==0){
                          flag=1;
                          break;
                        }
                    }
                  if(flag==1){count++;
                  output[j]=i;
                  }
                }
                //else
                if(count==4)break;
               in.nextInt();
            }
            //for(int i=0;i<4;i++)System.out.print(output[i]);
            sum=0;
            for(int i=3;i>=0;i--)
            sum+=output[i]*Math.pow(10,i);
            System.out.println(sum);
        }
    }
        
                        
                      
                      