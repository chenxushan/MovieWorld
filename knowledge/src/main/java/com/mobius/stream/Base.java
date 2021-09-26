package com.mobius.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Base {
    public static void main(String[] args) {
        List<String> nameStrs = Arrays.asList("Monkey", "Lion", "Giraffe","Lemur");

        List<String> list = nameStrs.stream()
                .filter(s -> s.startsWith("L"))
                .map(String::toUpperCase)
                .sorted()
                .collect(toList());
        System.out.println(list);
    }

    String[] array = {"Monkey", "Lion", "Giraffe", "Lemur"};
    Stream<String> nameStrs2 = Stream.of(array);

    Stream<String> nameStrs3 = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");

    List<String> list = Arrays.asList("Monkey", "Lion", "Giraffe", "Lemur");
    Stream<String> streamFromList = list.stream();

    Set<String> set = new HashSet<>(list);
    Stream<String> streamFromSet = set.stream();

    //将文本文件转换为管道流


    Stream<String> lines;

    {
        try {
            lines = Files.lines(Paths.get("file.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
