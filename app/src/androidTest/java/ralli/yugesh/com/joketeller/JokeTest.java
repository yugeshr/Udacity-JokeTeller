package ralli.yugesh.com.joketeller;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class JokeTest extends ApplicationTestCase<Application> implements OnJokeReceiver{

    private CountDownLatch signal;
    private String mJoke;

    public JokeTest() {
        super(Application.class);
    }

    @Override
    public void Joke(String joke) {
        mJoke = joke;
        signal.countDown();
    }

    public void testJoke() {
        try {
            signal = new CountDownLatch(1);
            new EndpointsAsyncTask(this).execute();
            signal.await(10, TimeUnit.SECONDS);
            assertNotNull("NULL",mJoke);
            assertFalse("Joke is empty",mJoke.isEmpty());

        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }
    }
}
