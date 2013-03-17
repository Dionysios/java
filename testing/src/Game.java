import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {


private static void start() {

 int guess = 0; int e= 0 ;
 String name ;
 
 Scanner sc = new Scanner (System.in);

 ArrayList<Integer> score = new ArrayList<Integer>();
 ArrayList<String> playern = new ArrayList<String>();
 
 
    boolean a=false;

    all: do {
   
    	int tries = 1 ; //variable which will count the valued tries of the player 
   
   
   a=false;
     int answer = (int) (Math.random() * 1000 + 1) ;
     System.out.print(answer);
     System.out.println( "Hello and welcome to this guessing game!" )  ;
     System.out.print("Start guessing, it's a number between 1 and 1000 : ");
               String input1 = sc.nextLine();
               top:       do
      {


               if(input1.equals("quit")){ System.out.println("The game is over"); break all;}
                   try    {
                       e = Integer.parseInt(input1);
                       guess = e;
              } catch (NumberFormatException nfe) 
                        {
            System.out.println(" Are you stupid?Only numbers ");
                     String input2 = sc.nextLine();
                     input1 = input2; continue top;}          
        if (guess > 1000 | guess <1 )
        {
            System.out.println("Not in range");
                      String input3 = sc.nextLine();
                      input1 = input3;
        }
        else if (guess < answer )
          {
            System.out.println("Guess too low ");
          String input4 = sc.nextLine();
                    input1 = input4;
                        tries ++;
        }


    else if(guess  > answer )
        {
            System.out.println("Guess too high ");
        String input5 = sc.nextLine();
               input1 = input5;
                        tries ++;
        }

               
    else if (guess == answer)
        {       
            System.out.println("CORRECT!");
            
                        
                        System.out.println("You guessed the correct number in " + tries + "guesses");
                        System.out.println("Please enter your name ");

                  name = sc.nextLine();
           
            //add score name to their arrayList
            score.add(tries);
            playern.add(name);
            
            // shorting
            
            for ( int g=0; g < score.size()-1; g++){
                for ( int b=g+1; b < score.size(); b++){
                    if (score.size()>1){
                    if  (score.get (g) > score.get (b)){
                      Collections.swap(score, g, b);
                      Collections.swap(playern, g, b);
                     

                    }
                    }
                    if (score.get (g)==score.get(b) )
                    {
                      Collections.swap(score, g, b);
                      Collections.swap(playern, g, b);
                     
                    }
                }

            }
            
            
            
             boolean s = false  ; 
             while (s==false)
              {
       
                       System.out.println("Do you like to play again?(y/n)");
                     input1 = sc.nextLine();
                      if (input1.matches("y"))
            {
                     System.out.println("Current highScore: \nGuess\tName");
                //print out high score list
                for (int i = 0;i < score.size(); i++)
                {
                System.out.println(score.get(i)+"\t" + playern.get(i));
                }

                     s=true;
            }

                             if (input1.matches("n"))
            {
                System.out.println("HighScore:\nGuess\tName");

                for (int i = 0;i < score.size(); i++)
                {
                	System.out.println(score.get(i)+"\t"+ playern.get(i));
                }
                                System.out.println("The game is over");
                                a=true;

                                s=true;
                                 break;  
                    } 
       }
          }

        } while (guess != answer);

  }while(a==false);

}



	public static void main(String[] args) {
    
		Game.start();
	}   
	    
}
	
