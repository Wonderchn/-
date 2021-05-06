package com.hongna.leetcode.Set;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

//文件相关操作
public class FileOperation {
    public static boolean readFile(String fileName, ArrayList<String> words){
        if (fileName == null || words == null){
            System.out.println("filename is null or words is null");
            return false;
        }
        //文件读取
        Scanner scanner;
        try{
            File file = new File(fileName);
            if (file.exists()){
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis),"UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            }
            else
                return false;
        }
        catch (IOException ioe) {
            System.out.println("Cannot open "+ fileName);
            return false;
        }

        if (scanner.hasNextLine()){
            String contents = scanner.useDelimiter("\\A").next();
            int start  = firstCharacterIndex(contents,0);
            for (int i = start+1 ; i<= contents.length();)
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;

                }else
                    i++;

            }

        return false;

    }



    private static int firstCharacterIndex(String s , int start){
        for (int i = start; i < s.length(); i++){
            if (Character.isLetter(s.charAt(i)))
                return i;
        }
        return s.length();
    }
}
