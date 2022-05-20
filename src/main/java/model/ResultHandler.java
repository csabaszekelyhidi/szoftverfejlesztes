package model;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

public class ResultHandler {

    private Result result = new Result();

    public ResultHandler(boolean win, int guess) {

        var objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        Result old = new Result();
        try {
            old = objectMapper.readValue(new FileReader("result.json"), Result.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        result = old;

        if ( win ) {
            switch (guess) {
                case 1: result.setGuess1(old.getGuess1()+1); break;
                case 2: result.setGuess2(old.getGuess2()+1); break;
                case 3: result.setGuess3(old.getGuess3()+1); break;
                case 4: result.setGuess4(old.getGuess4()+1); break;
                case 5: result.setGuess5(old.getGuess5()+1); break;
                case 6: result.setGuess6(old.getGuess6()+1); break;
            }
            result.setStreak(old.getStreak()+1);
        } else {
            result.setLost(old.getLost()+1);
            result.setStreak(0);
        }

        try (var writer = new FileWriter("result.json")) {
            objectMapper.writeValue(writer, result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getGuess1()
    {
        return result.getGuess1();
    }
    public int getGuess2()
    {
        return result.getGuess2();
    }
    public int getGuess3()
    {
        return result.getGuess3();
    }
    public int getGuess4()
    {
        return result.getGuess4();
    }
    public int getGuess5()
    {
        return result.getGuess5();
    }
    public int getGuess6()
    {
        return result.getGuess6();
    }
    public int getLostGamesCount()
    {
        return result.getLost();
    }
    public int getStreak()
    {
        return result.getStreak();
    }
    public int getAllCounted()
    {
        return result.getAll();
    }
    public int getMax()
    {
        int[] tab = {result.getGuess1(), result.getGuess2(), result.getGuess3(), result.getGuess4(), result.getGuess5(), result.getGuess6()};
        return Arrays.stream(tab).max().getAsInt();
    }

    public double getProgress(int index) {
        double back = 0.0;
        switch (index) {
            case 1: back = (double) result.getGuess1()/getMax(); break;
            case 2: back = (double)result.getGuess2()/getMax(); break;
            case 3: back = (double)result.getGuess3()/getMax(); break;
            case 4: back = (double)result.getGuess4()/getMax(); break;
            case 5: back = (double)result.getGuess5()/getMax(); break;
            case 6: back = (double)result.getGuess6()/getMax(); break;
            case 7: back = (double)result.getLost()/getMax(); break;
        }
        return back;
    }
}
