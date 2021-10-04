
public final class Penguin extends Bird 
{
	//Properties
	private int swimmingSpeed;
	
	//Constructor
	public Penguin(String name, int swimmingSpeed)
	{
		super(name, "not endangered", false, "Penguin");
		this.swimmingSpeed = swimmingSpeed;
	}
	
	//utilities
	public void display()
	{
		System.out.println("%s is a penguin who can swim %d m/s.\n", name, swimmingSpeed);
	}
	
	public int getSwimmingSpeed() 
	{
		return swimmingSpeed;
	}
	
	public void setSwimmingSpeed(int newSwimmingSpeed)
	{
		this.swimmingSpeed = newSwimmingSpeed;
	}
}
