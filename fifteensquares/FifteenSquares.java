package fifteensquares;
import java.util.*;
public class FifteenSquares {
Random rn = new Random();
// object allows for randomization
int [] blocks = new int[16];
// creates a int array
int[] neighboursArray = new int[4];
// creates an array that checks the up, down and side positions, 
// moving the tile and replace the location with the number you're moving to

//constructor
  public FifteenSquares(){ 
// the constructor values 1-15 into positions 0-14 
       for(int i = 1; i < blocks.length; i++) {   
       blocks [i-1]=i;
       // loop with negative increments instead of positive increments    
       }
       scramble ();
       // calls the scramble method, make sure it's not in the for loop
    }
 
public void move( int number ) {            
	// this method finds the blank space
    if (number >= blocks.length)
      return;
    int i;                              
    // find the slot this number is in 
    for (i=0; i < blocks.length; i++)
      if (blocks[i] == number)
        break;
    if (tryAbove(i)) return;
    if (tryBelow(i)) return;
    if (tryLeft(i))  return;
    if (tryRight(i)) return;
  }
   private boolean tryAbove( int pos ) {
    if (pos < 4){                            
    // if the blank is on the edge do nothing (position < 4)
      return false;
    }
    if (blocks[pos-4] != 0){                
    // if blank space is not found, do nothing and return blank 
      return false;                         
    } else {
    swap( pos, pos-4 );                  
    // else if blank space is found and not on the boundary, then swap positions with its neightbor 
    return true;
    }
  }
 
 
  private boolean tryBelow( int pos ) {
    if (pos > 11){
      return false;
    }
    if (blocks[pos+4] != 0){
      return false;
      } else {                           
      // moves blank space 
    swap( pos, pos+4 );
    return true;
    }
  }
  
  private boolean tryLeft( int pos ) {
    if (pos%4 == 0)
      return false;
    if (blocks[pos-1] != 0)
      return false;
    swap( pos, pos-1 );
    return true;
  }
  private boolean tryRight( int pos ) {
    if (pos%4 == 3)
      return false;
    if (blocks[pos+1] != 0)
      return false;
    swap( pos, pos+1 );
    return true;
  }
  private void swap( int one, int two ) {
    int   temp = blocks[one];
    blocks[one] = blocks[two];
    blocks[two] = temp;
  }
  
  
  
  
  
  // using scramble, randomization and neighbours array to scramble 15squares  
    private void scramble(){                
    // scrambles the tiles 200 times by moving blank space around 200 times 
    int[] neighbours = new int [4];         
    int numNeighbours, temp, moveTo, blank = 15;        
    // creating same data-type variables of the same type, and they all have the hard coded value of 15
    for (int i=0; i < 200; i++){                         
    numNeighbours = findNeighbours (blank, neighbours); 
    // findNeighbours scarmbes the position of the blank in neighbours array 
    moveTo = neighbours [rn.nextInt(numNeighbours)];    
    // this randomizes what index goes where because of MoveTO, using the randomnumber 
    // object to come up with a value in one of the (4) indexes from neighbours give it a value from 1-15
    temp = blocks [moveTo];                             
    // whatever random value MoveTo has been assigned, hold the position there on the original array 
    blocks[moveTo] = blocks[blank];                    
    // recall blank= 15 so it is the blank space, setting the value of temp into the blank space 
    blocks[blank] = temp;                               
    // blank space = temp = 15, this number is reset 
    blank = moveTo;                                     
    // resetting to 15            
}
} 
    
private int findNeighbours ( int blank, int [] array){    
	// checks for neighbours by checking th blanks relative positions to the borders or corners
	// there are only 12 positions with neghtbours
    int numNeighbours = 0;                                
    if (blank > 3)  array[numNeighbours++] = blank - 4;   
    // conditions for random number to pass in orderto keep the values in the boundaries 
    if (blank < 12) array[numNeighbours++] = blank + 4;   
    if (blank % 4 != 0) array[numNeighbours++] = blank -1;  
    // divides blank by 4 and leaves a random number
    if (blank % 4 != 3) array[numNeighbours++] = blank +1;  
    return numNeighbours;                                   
} 

public String format (int number){                       
        if (number == 0) return " x ";                     
        // puts a blank space at the end of the grid 
        return ((number < 10) ? " " : "") + number + " ";   
        // creates spaces between the numbers for ledgibility
       }
  
    public void display (){                                 
    // this method is going to show me what is happening in the code 
        System.out.println();                              
         for (int i=0; i < 4; i++){                       
       	 // nesting a for loop as long as i<4 because we have 4 rows
           for (int j=0; j < 4; j++)                     
        	// nesting another for loop because we have 4 columns
           System.out.print(format(blocks[i * 4 + j]));    
           // populates the grid w/ i and j arrays
             System.out.println();  
         }
    }
     
    
    
    
    
    
    
    public static void main(String[] args) {
        FifteenSquares puzzle = new FifteenSquares ();     
        // makes an object 
        Scanner input = new Scanner (System.in);           
        // create a new scanner object 
        int number; 
        while (true){                                         
        puzzle.display ();                               
        // shows the puzzle/game
            System.out.print("\nEnter a number from 1 - 15: ");               
            // Displays message to user to play the game
        number = input.nextInt();
            
        if (number==0)
            break;
        puzzle.move(number);
    }
    }
   
}
   