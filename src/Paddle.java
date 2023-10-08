import java.awt.*;

public class Paddle {
    private int height, x, y, speed;
    private Color color;
    static final int PADDLE_WIDTH = 15;

    public Paddle(int x, int y, int height, int speed, Color color) {
        this.height = height;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveTowards(int moveToY) {
        int centerY = y + height / 2;
        if(Math.abs(centerY - moveToY) > speed){
            if(centerY > moveToY){
                y -= speed;
            }
            if(centerY < moveToY){
                y += speed;
            }
        }

    }
    public boolean checkCollision(Ball b){
        Rectangle paddleRect = new Rectangle(x, y, PADDLE_WIDTH, height);
        Rectangle ballRect = new Rectangle(b.getX(), b.getY(), b.getSize(), b.getSize());
        return paddleRect.intersects(ballRect);

    }
    public void paint(Graphics graphics){
        graphics.setColor(color);
        graphics.fillRect(x, y, PADDLE_WIDTH,height);
    }
}
