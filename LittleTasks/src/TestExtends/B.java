package TestExtends;

public class B extends LitTestStakOverfolov {
     String variable = "Klas B";

    public B(){
    	
    	//printVariable();// in that way it will be print from class ListTest***
    	System.out.println("B");
       // System.out.println("variable value in B = " + this.variable);
        printVariable();
     
    	
    }
public B(String egf){
    	
    	//printVariable();// in that way it will be print from class ListTest***
	   
        this();
        
        System.out.println("this() B2");
        
     
    	
    }

    protected void printVariable(){
      //  variable = "variable is initialized in B Class";
    	System.out.println("b");
    //   System.out.println("variable value in B = " + this.variable);
    }
}