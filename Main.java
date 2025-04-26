import java.awt.event.KeyEvent;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Set up the canvas and animation
        PennDraw.setCanvasSize(500, 500);
        PennDraw.enableAnimation(30);
        Random randomNumGen = new Random(); //Declaring the random number generator


    
        // Ball variables
        double ball_x = 0.2;
        double ball_y = 0.5;
        double ball_radius = 0.02;
        double moveAmount = 0.02;

        
        // brick variables
        double random_brick_y = randomNumGen.nextDouble();
        double brick_x = 1;
        double brick_radius = 0.1;
        double brick_width = brick_radius;  
        double brick_height = brick_radius; 


        // score variable
        int score = 0;
       

        
        boolean touched = false;
        
        while (!touched) {
            PennDraw.clear(153, 169, 143);

            // Ball movement
            if (PennDraw.isKeyPressed(KeyEvent.VK_S) && ball_y - ball_radius - moveAmount >= 0) {
                ball_y -= moveAmount;
            }
            if (PennDraw.isKeyPressed(KeyEvent.VK_W) && ball_y + ball_radius + moveAmount <= 1) {
                ball_y += moveAmount;
            }


             // Draw the ball
            PennDraw.setPenColor(255, 0, 0); // Red ball
            PennDraw.filledCircle(ball_x, ball_y, ball_radius);


            // draw the brick
            PennDraw.setPenColor(250, 120, 0);
            PennDraw.filledSquare(brick_x, random_brick_y, brick_radius);


            // moving the brick speed of 0.02
            brick_x -= 0.02;


            // Check if the brick is off-screen 
            if (brick_x + brick_width < 0) {
                brick_x = 1.0; // Reset to right side of the canvas
                random_brick_y = randomNumGen.nextDouble(); // New random Y position
                score++;
            }


            // printing out the score
            PennDraw.text(.9, .9, "score " + score);


            // check for collision 
            boolean collision = (ball_x + ball_radius > brick_x - brick_width  &&
                                 ball_x - ball_radius < brick_x + brick_width  &&
                                 ball_y + ball_radius > random_brick_y - brick_height  &&
                                 ball_y - ball_radius < random_brick_y + brick_height );


           if( collision){
               System.out.println("Collision happened");
               touched = true;
               PennDraw.setPenColor(PennDraw.GREEN);
               PennDraw.text(0.5, 0.5, "Collision happened!");
               PennDraw.advance(); // Show the text
           }


        //    leveling up 

           boolean level2 = score == 5;
           boolean level3 = score == 10;
           boolean level4 = score == 15;
           boolean level5 = score == 20;
           boolean level6 = score == 25;
           boolean level7 = score == 30;


        if(level2 || level3 || level4){
            brick_x -= 3;
            ball_radius  += 0.03;
            brick_radius += 0.03;
        }else if( level5 || level6 || level7){
            brick_x -=3;
        }


            PennDraw.advance();
        }
    }

}
