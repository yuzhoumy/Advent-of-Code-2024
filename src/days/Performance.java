package days;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class Performance {

    protected final List<String> input;

    {
        try {
            input = Files.readAllLines(Paths.get("./inputs/" + this.getClass().getSimpleName() + ".txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract void perform();

//    private List<String> getInput() throws IOException {
//        return Files.readAllLines(Paths.get("./inputs/" + this.getClass().getSimpleName() + ".txt"));
//    }

    public void time() {
        System.out.println("Warm up");
        perform();

        System.out.println("===================");

        long startTime = System.nanoTime();
        perform();
        long endTime = System.nanoTime();

        System.out.println("===================");

        long duration = endTime - startTime;
        System.out.println("~Duration~");
        System.out.println("Nanosecond: " + duration);
        System.out.printf("Millisecond: %.6f%n" , duration / (double) 1000000);
        System.out.printf("Second: %.10f%n" , (duration / (double) 1000000) / (double) 1000000);
    }

    public long nanoSecond() {
        System.out.println("Warm up");
        perform();

        System.out.println("===================");

        long startTime = System.nanoTime();
        perform();
        long endTime = System.nanoTime();

        System.out.println("===================");

        return endTime - startTime;
    }

}
