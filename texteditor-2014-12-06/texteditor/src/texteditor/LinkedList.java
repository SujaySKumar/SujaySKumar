package texteditor;
import java.io.*;
import javax.swing.JOptionPane;
class LinkedList {
	Node first;

	void add(String v) {
		Node p = new Node();
		p.setData(v);
		if (first == null)
			first = p;
		else {
			Node q = first;
			while (q.getNext() != null) {
				q = q.getNext();
			}
			q.setNext(p);
		}
	}
        
        boolean presearch(String v) {
            System.out.println(v);
		//boolean found=false;
      Node q = first;
		//int pos = 1;
		while (q != null) {
                        System.out.println(q.getData());
			if (v.equals(q.getData()))
			return true;	
            //found=true;
                   
                            q = q.getNext();
		}
                JOptionPane.showMessageDialog(null,"Search not found");
                 return false;
        }
   
	void search(String v,String x) {
		boolean found=false;
      Node q = first;
		int pos = 1;
		while (q != null) {
			if (v.compareTo(q.getData()) == 0){
				q.setData(x);
            found=true;
            
            }
           	pos++;
			   q = q.getNext();
		}
      if(!found){
          JOptionPane.showMessageDialog(null,"Search not found");
          
          //System.out.println("Not found");
          
      }
      else
          JOptionPane.showMessageDialog(null,"Replacement done!");
          
	}

	void display() {
   PrintWriter outputfile;
   try{
    outputfile=new PrintWriter("C://Vinay//Indent.txt");
		Node temp = first;
                //char d='\0'; String abc=null;
		while (temp != null) {
			System.out.println("Working");
                    char c=temp.getData().charAt(0);
                    
                    if(temp.getData().length()==1 ){
                        if(temp.getData().equals("{") || (temp.getData().equals("}")) || (temp.getData().equals(";")))
                            outputfile.print(temp.getData()+ "\n");
                        else
                           outputfile.print(temp.getData());
			temp = temp.getNext();
                        //abc=temp.getNext().getData();
                       // d=abc.charAt(0);
                        //&& !(d>97&&d<122&&d>65&&d<90&&d>48&&d<57))
                    }
                    else if(temp.getNext().getData().length()==1 ) {
                        char d=temp.getNext().getData().charAt(0);
                        if((d>=97 && d<=122) || (d>=65 && d<=90) || (d>=48 && d<=57)){
                        outputfile.print(temp.getData()+" ");
                    }
                        else 
                        outputfile.print(temp.getData());
                        temp=temp.getNext();
                    }
                    else{
                        outputfile.print(temp.getData()+" ");
                        temp=temp.getNext();
                    }
                      
		}
      outputfile.close();

      }
      catch(Exception e){}
      	}
}

