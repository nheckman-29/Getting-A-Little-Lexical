//Created by Nathan Heckman
import java.util.*;

public class Conway { 
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String size = s.nextLine();											//get array size from user. String so any whitespace can be trimmed in future method
		int[] list = createarray(size);										//create array of user-specified size
		int cells = list[0];												//size of array is first input
		int generation = list[1];											//number of generations wanted is second input
		String first = s.nextLine();										//first generation specified by user
		int[] dead_alive = createFirst(first,cells);						//create array based on first generation
		int[] changing = new int[cells];									//create array to store changed values between generations
		System.arraycopy(dead_alive, 0, changing, 0, cells);				//copy cells number of elements from dead_alive to changing
		
		for(int y = 0; y < generation; y++) {								//for each generation...
			for(int x = 0; x < cells; x++) {								//for each cell...
				if(x == 0) {
					if(dead_alive[x+1] + dead_alive[cells-1] == 1) {		//see if neighbors are on or off and adjust accordingly
						changing[x] = 1;  									//cells at beginning have neighbor at end of array
					}														//cells at end have neighbor at beginning of array
					else {
						changing[x] = 0;
					}
				}
				else if(x == cells-1) {
					if(dead_alive[x-1] + dead_alive[0] == 1) {
						changing[x] = 1;
					}
					else {
						changing[x] = 0;
					}
				}
				else {
					if(dead_alive[x-1] + dead_alive[x+1] == 1) {
						changing[x] = 1;
					}
					else {
						changing[x] = 0;   
					}
				}
			//update dead_alive to reflect changes in changing
			System.arraycopy(changing, 0, dead_alive, 0, changing.length);
			}
		}
		System.out.println(java.util.Arrays.toString(changing));
		s.close();
	}
	private static int[] createarray(String input)
	{
		String[] args = input.trim().split("\\s+");							//trim and split integers from input
		int array[] = new int[2];											//create new array to store integers
		array[0] = Integer.parseInt(args[0]);								//update array with integers, parseInt since they are Strings
		array[1] = Integer.parseInt(args[1]);
		return array;
	}
	private static int[] createFirst(String first,int totalcells)
	{
		int array[] = new int[totalcells];									//create new array based on total number of cells
		for(int i = 0; i < first.length(); i++)								
		{
			array[i] = Character.digit(first.charAt(i), 10);
		}
		return array;
	}
}