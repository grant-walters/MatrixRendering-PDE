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
    
    void update() {
        disp();
        bottom();
    }
    
    void disp() {
        textSize(size);
        int fade = 255;
        for(int yoff = 1; yoff < 30; yoff++ ) {
            char c = char(floor(random(33,126)));
            fill(0,255,0,fade);
            text(c,x,y-yoff*10);
            fade -= 10;
        }
        char c = char(floor(random(33,126)));
        fill(255,255);
        text(c,x,y);
        y+=speed;    
    }
    
    void bottom() {
        if(y>height+200) {
            y=0;
            x=random(width);
        }
    }
}
