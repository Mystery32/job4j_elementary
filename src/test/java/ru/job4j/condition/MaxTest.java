package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int left = 1;
        int right = 2;
        int result = Max.max(left, right);
        int expected = 2;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax7To6Then7() {
        int left = 7;
        int right = 6;
        int result = Max.max(left, right);
        int expected = 7;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax3To5Then5() {
        int left = 3;
        int right = 5;
        int result = Max.max(left, right);
        int expected = 5;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax9To9Then9() {
        int left = 9;
        int right = 9;
        int result = Max.max(left, right);
        int expected = 9;
        Assert.assertEquals(result, expected);
    }
}