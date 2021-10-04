
public abstract class Bird extends Animal {
	//Properties
	protected boolean canFly;
	
	//Constructor
	public Bird(String name, String conservationStatus, boolean canFly, String species) 
	{
		super(name, conservationStatus, species);
		this.canFly = canFly;
	}
	
	//utilities
	public abstract void display();

}
