package javaInterview;

public class Team {
	public String name = null;

	public  int score = 0;
	public  int pure = 0;
	public  int hit = 0;

	public Team(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public Team(String name, int pure, int hit) {
		super();
		this.name = name;
		this.pure = pure;
		this.hit = hit;
	}

	@Override
	public String toString() {
		return name ;
	}
	
	
	

}
