package onlineCode;

public class CircleColor {
	
	
	public static int Colour(int colour_number, int split_part) {  
	    int f2 = colour_number * (colour_number - 1), f1 = f2 * (colour_number - 2);  
	    if (split_part == 1)  
	        return colour_number;  
	    else if (split_part == 2)  
	        return f2;  
	    else if (split_part == 3)  
	        return f1;  
	    int i = 3;  
	    int temp = 0;  
	    do {  
	        temp = (colour_number - 1)*f2 + (colour_number - 2)*f1;  
	  
	        f2 = f1;  
	        f1 = temp;  
	        i++;  
	    } while (i < split_part-3);  
	    return f1;  

	}  
	
	public static void main(String[] args) {
		int i = Colour(3,4);
		System.out.println(i);
	}

}
