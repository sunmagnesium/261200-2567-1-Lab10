public class MultiThreadedDrawing {
    public static void main(String[] args) {
        // Create turtles
        turtle turtle1 = new turtle();
        turtle turtle2 = new turtle();
        turtle turtle3 = new turtle();

        // Set positions to prevent overlap
        turtle1.setPosition(-200, 0);
        turtle2.setPosition(0, 0);
        turtle3.setPosition(200, 0);

        // Customize turtles (optional)
        turtle1.penColor("red");
        turtle2.penColor("green");
        turtle3.penColor("blue");

        // Define drawing tasks
        Runnable drawSquare = () -> {
            for (int i = 0; i < 4; i++) {
                turtle1.forward(100);
                turtle1.right(90);
                try {
                    Thread.sleep(200); // Control speed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable drawTriangle = () -> {
            for (int i = 0; i < 3; i++) {
                turtle2.forward(100);
                turtle2.right(120);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable drawCircle = () -> {
            for (int i = 0; i < 360; i++) {
                turtle3.forward(1);
                turtle3.right(1);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Create threads
        Thread thread1 = new Thread(drawSquare);
        Thread thread2 = new Thread(drawTriangle);
        Thread thread3 = new Thread(drawCircle);

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
