package com.webautomation.exploration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStream {
    public static void main(String[] args) {
        //di java stream : looping yg bisa menggunakan filter
        
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,5,5,5,55,5,5,5,5,5,6,7,8,9,10);
        List<Integer> result = new ArrayList<>();
        //scenario nya adalah kita mengambil semua yg ada angka 5, terus di add ke result
        
        //1. Menggunakan tradisional looping

        //>> Cara 1
        // for(int i=0; i<numbers.size(); i++){
        //     if(numbers.get(i) == 5){
        //         result.add(numbers.get(i));
        //     }
        // }
        // System.out.println("Ini adalah result 1 : " + result);

        //>> Cara 2
        for(Integer integer : numbers){
            if(integer == 5){
                result.add(integer);
            }
        }
        System.out.println("Ini adalah result 2 for looping : " + result);

        //2. Menggunakan stream
        result = numbers.stream().filter(integer -> integer.equals(5)).collect(Collectors.toList());
        //filter 5, ditampung dalam sebuah value bernama integer, masukkan ke sebuah list
        //kelemahan for : kalau element lumayan banyak, kodingannya jg akan banyak sampai ke bawah
        //menggunakan stream bisa mempersingkat looping nya
        System.out.println("Ini adalah result stream : " + result);

        

    }
}
