// Dog class definition
public class Dog {
	//
	// Fields (states) for Dog objects - should be private
	//
	private String name;
	private boolean goodDog;

	// OVERLOADED constructor - different parameter list
	public Dog() {
		this.name = "Fido";
		this.goodDog = false;
	}


	//
	// Constructor for Dog objects - should initialize fields
	//    NOTE: Constructor name must be same as the class with NO return type,
	//          this. differentiates fields from parameters
	// 
    public Dog(String name, boolean goodDog) {
    	// INITIALIZE FIELDS with constructor parameters
    	// this. differentiates fields from method parameters
    	this.name = name;
    	this.goodDog = goodDog;
    }
    
    //
    // Getter method - returns the value of a field
    //
    public boolean isGoodDog() {
    	return goodDog;
    }
    
    //
    // Setter method - allows field values to be changed
    //
    public void giveNewName(String newName) {
    	name = newName;
    }
    
    //
    // Instance methods - determine behaviors of objects of this class
    //
    public void bark() {
    	System.out.println(name + " barks");
    }
    
    public void respondToCall(String nameCalled) {
    	// Good dogs come when their name is called
    	if (name.equals(nameCalled) && goodDog) {
    		System.out.println(name + " comes");
    	} else {
    		System.out.println(name + " does not respond");
    	}
    }
    
    public void train() {
    	goodDog = true;
    }
}