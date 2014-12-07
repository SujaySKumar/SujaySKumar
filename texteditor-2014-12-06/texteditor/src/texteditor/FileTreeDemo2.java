package texteditor;

//package texteditor;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.io.File;

public class FileTreeDemo2 {
	String ioNames[],utilNames[],langNames[],mathNames[];
	File root[]=new File[4]; File io,util,lang,math;
    public FileTreeDemo2(){
    	io = new File("C:\\Vinay\\java\\io");
        util= new File("C:\\Vinay\\java\\util");
        lang= new File("C:\\Vinay\\java\\lang");
        math= new File("C:\\Vinay\\java\\math");
        //root[]={io,util,lang,math};
        root[0]=io;
        root[1]=util;
        root[2]=lang;
        root[3]=math;
        ioNames=this.populateArray(this.getIO()); 
        //this.display(ioNames);
        utilNames=this.populateArray(this.getUtil()); 
        //this.display(utilNames);
        langNames=this.populateArray(this.getLang()); 
        //this.display(langNames);
        mathNames=this.populateArray(this.getMath()); 
        //this.display(mathNames);
    }
    public static void main(String args[])
    {
        FileTreeDemo2 demo=new FileTreeDemo2();
        
    }
	public File getIO()
	{
		return io;
	}
	public File getUtil()
	{
		return util;
	}
	public File getLang()
	{
		return lang;
	}
	public File getMath()
	{
		return math;
	}
  
  public String[] getIOArray(){
	  return ioNames;
  }
  public String[] getLangArray(){
	  return langNames;
  }
  public String[] getMathArray(){
	  return mathNames;
  }
  public String[] getUtilArray(){
	  return utilNames;
  }
  public void display(String[] array)
  {
	  for(int i=0;i<array.length;i++)
		  if(array[i]!=null)
		  System.out.println(array[i]);
  }
    public String[] populateArray(File root){
    // Create a TreeModel object to represent our tree of files
    
    FileTreeModel model = new FileTreeModel(root);
    String[] array=new String[200];
    // Create a JTree and tell it to display our model
    JTree tree = new JTree();
    tree.setModel(model); int k=0;
    for(int i=0;i<model.getChildCount(root);i++)
    {	
    	File f = new File(model.getChild(root,i).toString());
		 //System.out.println(f.getName());

    	if((!f.getName().contains("$")) && (f.getName().endsWith(".class")))
    	{
    		int lastPeriodPos = f.getName().lastIndexOf('.');
    		 File renamed = new File(f.getParent(), f.getName().substring(0, lastPeriodPos));
    		 //System.out.println(f.getName());
    		 array[k++]=renamed.getName();
    	}
    	
    	//System.out.println("The Child is: " + model.getChild(root,i).toString() );
    
    
    // The JTree can get big, so allow it to scroll.
   // JScrollPane scrollpane = new JScrollPane(tree);
    
    // Display it all in a window and make the window appear
    //JFrame frame = new JFrame("FileTreeDemo");
    //frame.getContentPane().add(scrollpane, "Center");
    //frame.setSize(400,600);
    //frame.setVisible(true);
    }return array;
  }}

/**
 * The methods in this class allow the JTree component to traverse
 * the file system tree, and display the files and directories.
 **/
class FileTreeModel implements TreeModel {
  // We specify the root directory when we create the model.
  protected File root;
  public FileTreeModel(File root) { this.root = root; }

  // The model knows how to return the root object of the tree
  public Object getRoot() { return root; }

  // Tell JTree whether an object in the tree is a leaf or not
  public boolean isLeaf(Object node) {  return ((File)node).isFile(); }

  // Tell JTree how many children a node has
  public int getChildCount(Object parent) {
    String[] children = ((File)parent).list();
    if (children == null) return 0;
    return children.length;
  }

  // Fetch any numbered child of a node for the JTree.
  // Our model returns File objects for all nodes in the tree.  The
  // JTree displays these by calling the File.toString() method.
  public Object getChild(Object parent, int index) {
    String[] children = ((File)parent).list();
    if ((children == null) || (index >= children.length)) return null;
    return new File((File) parent, children[index]);
  }

  // Figure out a child's position in its parent node.
  public int getIndexOfChild(Object parent, Object child) {
    String[] children = ((File)parent).list();
    if (children == null) return -1;
    String childname = ((File)child).getName();
    for(int i = 0; i < children.length; i++) {
      if (childname.equals(children[i])) return i;
    }
    return -1;
  }

  // This method is only invoked by the JTree for editable trees.  
  // This TreeModel does not allow editing, so we do not implement 
  // this method.  The JTree editable property is false by default.
  public void valueForPathChanged(TreePath path, Object newvalue) {}

  // Since this is not an editable tree model, we never fire any events,
  // so we don't actually have to keep track of interested listeners.
  public void addTreeModelListener(TreeModelListener l) {}
  public void removeTreeModelListener(TreeModelListener l) {}
}
