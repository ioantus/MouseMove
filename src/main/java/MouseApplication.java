package main.java;

import java.awt.*;
import java.util.Random;

public class MouseApplication {
    public static final int ONE_MINUTE = 60 * 1000;

    public static void main(String... args) throws Exception {
        Robot robot = new Robot();
        Random random = new Random();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWight = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();
        Point point = MouseInfo.getPointerInfo().getLocation();
        while (true) {
            Thread.sleep(ONE_MINUTE);
            if (!isMouseMoved(point)) {
                robot.mouseMove(random.nextInt(screenWight), random.nextInt(screenHeight));
                point = MouseInfo.getPointerInfo().getLocation();
            }
        }
    }

    private static boolean isMouseMoved(Point prevPoint){
        return !prevPoint.equals(MouseInfo.getPointerInfo().getLocation());
    }

}