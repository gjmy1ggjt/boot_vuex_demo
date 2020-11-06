package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UtilTest {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(LocalDate.now());

        System.out.println(LocalDate.now().isAfter(LocalDate.now().plusDays(-1)));
    }
}
