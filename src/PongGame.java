import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PongGame extends JPanel implements MouseMotionListener {

    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private Ball ball;
    private Paddle userPaddle, pcPaddle;
    private int userScore, pcScore;
    private int userMouseY;
    private int bounceCount =0;

    public PongGame() {

        ball = new Ball(320, 200, 3, 3, 3, 10, Color.YELLOW); // Change the initial x position of the ball to be in the center
        userPaddle = new Paddle(20, 200, 75, 5, Color.BLUE); // Change the initial x position of the user paddle to avoid overlapping with the line
        pcPaddle = new Paddle(600, 200, 75, 5, Color.RED); // Change the initial x position of the pc paddle to avoid overlapping with the line
        userMouseY = 0;

        userScore = 0; pcScore = 0;

        addMouseMotionListener(this);

    }
    public void paintComponent(Graphics graphics){
        graphics.fillRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        graphics.setColor(Color.BLACK);
        ball.paintBall(graphics);
        userPaddle.paint(graphics);
        pcPaddle.paint(graphics);
        graphics.setColor(Color.WHITE);
        graphics.drawString("Score - User [ " + userScore + " ]   PC [ " + pcScore + " ]", 250, 20   );
        graphics.fillRect(315, 0, 10, WINDOW_HEIGHT); // Draw a white rectangle in the center of the game area
    }

    public void gameLogic(){
        ball.moveBall();
        ball.bounceOffEdges(0, WINDOW_HEIGHT);
        userPaddle.moveTowards(userMouseY);
        pcPaddle.moveTowards(ball.getY());


        if (userPaddle.checkCollision(ball)) {
            ball.reverseX();
        }


        if (pcPaddle.checkCollision(ball)) {
            ball.reverseX();
        }
        if(ball.getX() < 10){ // Change the left boundary to account for the line width
            pcScore++;
            reset();
        }
        else if(ball.getX() > WINDOW_WIDTH - 10){ // Change the right boundary to account for the line width
            userScore++;
            reset();
        }
        bounceCount++;
        if (bounceCount == 5){
            //reset counter
            bounceCount = 0;
            //increase ball speed
            ball.increaseSpeed();
        }


    }
    public void reset(){
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //reset ball
        ball.setX(320); // Change the initial x position of the ball to be in the center
        ball.setY(200);
        ball.setCx(3);
        ball.setCy(3);
        ball.setSpeed(3);
        bounceCount = 0;
    }



    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        userMouseY = e.getY();
    }
}