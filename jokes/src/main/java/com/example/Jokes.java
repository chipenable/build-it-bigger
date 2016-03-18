package com.example;

import java.util.Random;

public class Jokes {

    private Random randomGenerator;
    private String[] jokes = new String[]{
            "Never take life seriously. Nobody gets out alive, anyway.",
            "Age doesn't always bring wisdom. Sometimes age comes alone.",
            "The early bird gets the worm, but the second mouse gets the cheese.",
            "If the police arrest a mime, do they tell him he has the right to remain silent.",
            "Borrow money from pessimist. They don't expect it back.",
            "How do 'Do not walk on the grass' signs get there?",
            "I like work; it fascinates me. I can sit and look at it for hours.",
            "If a turtle doesn't have a shell, is it homeless or naked?",
            "Be nice to your kids. They'll choose your nursing home.",
            "Please, Lord, let me prove that winning the lottery won't spoil me."
    };

    public Jokes(){
        randomGenerator = new Random();
    }

    public String getJoke(){
        int i = randomGenerator.nextInt(jokes.length);
        return jokes[i];
    }

}
