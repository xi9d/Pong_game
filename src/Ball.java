import java.awt.*;

public class Ball {
    private int x, y, cx, cy, speed, size;
    private Color color;
    static final int MAX_SPEED = 7;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCx() {
        return cx;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }

    public int getCy() {
        return cy;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Ball(int x, int y, int cx, int cy, int speed, int size, Color color) {
        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
        this.speed = speed;
        this.size = size;
        this.color = color;
    }
    public int getY(){
        return y;
    }

    public int getX() {
        return x;
    }

    public void paintBall(Graphics graphics){
        graphics.setColor(color);
        graphics.fillOval(x,y, size,size);
    }

    public void moveBall(){
        x +=cx;
        y += cy;
    }
    public void bounceOffEdges(int top, int bottom){
        if(y > bottom - size){
            reverseY();
        }else if( y< top){
            reverseY();
        }

    }

    public void reverseX(){
        cx *= -1;
    }
    public void reverseY(){
        cy *= -1;
    }
    public void increaseSpeed(){
        //make sure current speed is less than max speed before incrementing
        if(speed < MAX_SPEED){
            //increase the speed by one
            speed ++;

            //alternative way to do it
            if(cx > 0){
                cx = speed;
            }
            else if(cx < 0){
                cx = speed * -1;
            }
            if(cy > 0){
                cy = speed;
            }
            else if(cy < 0){
                cy = speed * -1;
            }
        }
    }

}
