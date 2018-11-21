package ralli.yugesh.com.javajokelibrary;

import java.util.Random;

public class JokeSupplier {

    public JokeSupplier(){

    }

    public static String jokeShow()
    {
        String jokes[]={
                "Parallel lines have so much in common. It's a shame they're never going to meet\n",
                "Where do typists go for a drink? The space bar\n",
                "What do you call a shoe made out of a banana? A slipper"};

        Random random=new Random();
        return jokes[random.nextInt(jokes.length)];
    }
}
