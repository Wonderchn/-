package com.hongna.leetcode.Set;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static double testSet(Set<String> set,String fileName){
        long startTime = System.nanoTime();

        System.out.println(fileName);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(fileName,words)) {
            System.out.println("Total words" + words.size());
            for (String word : words) {
                set.add(word);
            }
            System.out.println("Total different words:" + set.getSize());
        }
        long entTime = System.nanoTime();
        return (entTime - startTime) /1000000000.0;
        }

    public static void main(String[] args) throws IOException {

        String path = Main.class.getClassLoader().getResource("").getPath();//注意getResource("")里面是空字符串
        System.out.println(path);


        String filename = ("pride-and-prejudice.txt");
        String filePath = path + filename;
        System.out.println(filePath);
        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filePath);
        System.out.println("Bst set" + time1  +"s");
        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filePath);
        System.out.println("LinkedListSet"+time2);

        File file = new File(filePath);
        System.out.println(file.isFile());
        System.out.println(file.exists());
    }


}
