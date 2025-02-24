package dev.alm.FileListings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class AnotherChallenge {
    public static void main(String[] args) {
        List<String> values = new ArrayList <>();
        Map <String,Integer> map = new HashMap <>();
        Path path = Path.of("FileExceptions/src/dev/alm/FileListings/textFile.txt");
        try {

            Files.readAllLines(path).forEach(lines-> {
                String[] words = lines.split(" ");
                for (String word : words){
                    if (!(word.length() <= 5)){
                        if (word.charAt(word.length()-1) == '.' || word.charAt(word.length()-1) == ','){
                            String parsedWord = word.substring(0, word.length()-1);
                            values.add(parsedWord);
                        } else {
                            values.add(word);
                        }
                    }
                }
                System.out.println(values);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String word : values){
            if (map.containsKey(word)){
                map.put(word, map.get(word) + 1);
            }
            else{
                map.put(word, 1);
            }
        }
        map.forEach((s,i) -> System.out.println(s+" "+i));
    }
}









