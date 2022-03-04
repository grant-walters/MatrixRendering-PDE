import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Matrix extends PApplet {

Letter[] letters;

int numTraces = 1000;

public void setup() {
    
    background(0);
    letters = new Letter[numTraces];
    for(int i=0;i<numTraces;i++) {
        letters[i] = new Letter(random(width),random(height+200));
    }
}


public void draw() {
    println(frameRate);
    background(0);
    for(Letter letter : letters) {
        letter.update();
    }
}
public class Letter {
    private float x;
    private float y;
    private int speed;
    private int size;
    
    public Letter(float x,float y) {
        this.x = x;
        this.y = y;
        speed = floor(random(5,15));
        size = floor(random(5,15));
    }
    
    public void update() {
        disp();
        bottom();
    }
    
    public void disp() {
        textSize(size);
        int fade = 255;
        for(int yoff = 1; yoff < 30; yoff++ ) {
            char c = PApplet.parseChar(floor(random(33,126)));
            fill(0,255,0,fade);
            text(c,x,y-yoff*10);
            fade -= 10;
        }
        char c = PApplet.parseChar(floor(random(33,126)));
        fill(255,255);
        text(c,x,y);
        y+=speed;    
    }
    
    public void bottom() {
        if(y>height+200) {
            y=0;
            x=random(width);
        }
    }
}
    public void settings() {  fullScreen(); }
    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Matrix" };
        if (passedArgs != null) {
          PApplet.main(concat(appletArgs, passedArgs));
        } else {
          PApplet.main(appletArgs);
        }
    }
}
