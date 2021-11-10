package com.yasynskyi.filework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileAnalizer {
    public static void main(String[] args) throws IOException {
        analyze("C:\\Users\\Den\\Desktop\\LuxCampus\\ДЗ\\HomeworkTwo\\src\\test\\testfolder\\Test1", "to" );
    }

    public static void analyze(String path, String word) throws IOException {

        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        byte[] contentFile = new byte[(int)file.length()];
        inputStream.read(contentFile);

        byte[] contentWord = new byte[word.length()];

        int counter =0;
        for (int i = 0; i < contentFile.length; i++){
            for (int j = 0; j < contentWord.length; j++) {
                if (contentFile[i] == contentWord[j]){
                    continue;
                } else {
                    break;
                }

            }
        }
    }
}
