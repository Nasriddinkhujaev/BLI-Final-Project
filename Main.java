import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
        double ball_radius = 0.05;
        double moveAmount = 0.02;

        
        // brick variables
        double random_brick_y = randomNumGen.nextDouble(1.0);
        double brick_x = 1;
        double brick_radius = 0.2;
       

        
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

              
            



    //         // Move bricks and check for reset
    //         boolean resetBricks = false;
    //         for (int i = 0; i < bricks.size(); i++) {
    //             Brick brick = bricks.get(i);
    //             brick.x -= brickSpeed;
    //             if (brick.x + brickWidth < 0) {
    //                 resetBricks = true;
    //             }
    //         }

    //         if (resetBricks) {
    //             bricks.removeIf(brick -> brick.x + brickWidth < 0);
    //             bricks.add(new Brick(1.0, 0.2 + new Random().nextDouble() * (1 - brickHeight - 0.2)));
    //         }

    //         // Draw bricks and check collision
    //         PennDraw.setPenColor(110, 179, 92); // Brick color
    //         for (int i = 0; i < bricks.size(); i++) {
    // Brick brick = bricks.get(i);

    // // Draw the brick
    // PennDraw.filledRectangle(brick.x + brickWidth / 2, brick.y, brickWidth, brickHeight);

    // // Check collision with ball
    // if (brick.x < x + ball_radius && brick.x + brickWidth > x - ball_radius &&
    //     y + ball_radius > brick.y - brickHeight / 2 && y - ball_radius < brick.y + brickHeight / 2) {
    //     System.out.println("Collision detected!");
    //     return; // End the game on collision
    //  }
    // }

             // Draw the ball
            PennDraw.setPenColor(255, 0, 0); // Red ball
            PennDraw.filledCircle(ball_x, ball_y, ball_radius);

            // draw the brick
            PennDraw.setPenColor(250, 120, 0);
            PennDraw.filledSquare(brick_x, random_brick_y, brick_radius);

            brick_x -= 0.02;
        
           boolean collision = (ball_x + ball_radius >= brick_x + brick_radius)  &&  (ball_y + brick_radius >= random_brick_y + brick_radius);
           
           System.out.println(collision);
           if( collision){
               System.out.println("Collision happened");
               touched = true;
           }

            PennDraw.advance();
        }
    }

}