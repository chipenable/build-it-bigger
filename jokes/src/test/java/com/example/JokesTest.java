package com.example;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pashgan on 09.03.2016.
 */
public class JokesTest {

    @Test
    public void testGetJoke() throws Exception {
        Jokes jokes = new Jokes();
        String joke;

        for(int i = 0; i < 10; i++) {
            joke = jokes.getJoke();
            Assert.assertTrue("jokes are not found", joke != null && joke.length() > 0);
            System.out.println(joke);
        }
    }

}