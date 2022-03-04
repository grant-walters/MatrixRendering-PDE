Letter[] letters;

int numTraces = 1000;

void setup() {
    fullScreen();
    background(0);
    letters = new Letter[numTraces];
    for(int i=0;i<numTraces;i++) {
        letters[i] = new Letter(random(width),random(height+200));
    }
}


void draw() {
    println(frameRate);
    background(0);
    for(Letter letter : letters) {
        letter.update();
    }
}
