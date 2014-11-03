import java.io.IOException;
import javax.swing.text.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jsoupTrial {
public static void main(String args[]){
	String webpage_link;
	
	//Initialising the document of class Document
	org.jsoup.nodes.Document d = null;
    
	webpage_link="http://en.wikipedia.org/w/api.php?action=query&titles=Audi";
    try{
    	
    	//Gets the html source code of the web page and stores it in Document
        d=Jsoup.connect(webpage_link).get();            
    
    }catch(Exception e){
        e.getMessage();
    }
    
    //Getting the title of the html document
    String Title=d.title();
    System.out.println("The title of the document is:"+Title);
    
    //Displaying the Document object which prints the entire html code of the web page
    System.out.print(d.toString());
    
    /* d.select("a[href]") selects all the attributes with href
     * All the href links are stored in the object of type Elements
     * By using the for loop, for every Element L belonging to Elements link,
     * print the attribute href of the link.
     * The purpose of using abs: is to display the absolute url of the link.
     * Usually the web pages contain relative urls which is avoided by using abs:
     */
    Elements link = d.select("a[href]");
    for(Element L:link){
    	System.out.println(L.attr("abs:href"));
    }
}
}
