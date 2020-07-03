import java.awt.*;
import java.util.Random;

public class Model {
    public Color[] getColours() {
        return colours;
    }

    public Color getRandomColor() {
        Random random = new Random(); // RANDOM STUFF
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color(r, g, b);
    }

    public void mixOneColor(int i) {
        colours[i] = getRandomColor();
    }

    public void copyColor(int i, Color c) {
        colours[i] = c;
    }

    public void mixAllColors() {
        for (int i = 0; i < 49; i++) {
            mixOneColor(i);
        }
    }

    public void resetAllColors() {
        for (int i = 0; i < 49; i++) {
            colours[i] = Color.WHITE;
        }
    }

    private Color[] colours = null;
    public Color storedColour = null;

    public void initialise() {
        colours = new Color[49];
        mixAllColors();
    }

}
