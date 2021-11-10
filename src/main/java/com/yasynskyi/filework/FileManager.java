package com.yasynskyi.filework;

import java.io.*;

public class FileManager {
    public static int countFiles(String path) {
        int counter = 0;
        File[] file = new File(path).listFiles();
        for (int i = 0; i < file.length; i++){
            if(file[i].isDirectory()){
                counter +=countFiles(file[i].toString());
            }
            counter++;
        }
        return counter;
    }

    public static int countDirs(String path) {
        int counter = 0;
        File[] file = new File(path).listFiles();
        for (int i = 0; i < file.length; i++){
            if (file[i].isDirectory()) {
                counter += countDirs(file[i].toString());
                counter++;
            }
        }
        return counter;
    }

    public static void copy(String from, String to) throws IOException {
        File[] file = new File(from).listFiles();
        for (int i = 0; i < file.length; i++) {
            if(file[i].isDirectory()){
                String newFolder = to + "\\" + file[i].getName();
                new File(newFolder).mkdir();
                copy(file[i].getPath(), newFolder);
            }
            if(file[i].isFile()) {
                String newFile = to + "\\" + file[i].getName();
                new File(newFile).createNewFile();
                copyData(file[i].getPath(), newFile);
            }
        }
    }

    private static void copyData(String from, String to) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(from);
        FileOutputStream fileOutputStream = new FileOutputStream(to);
        fileOutputStream.write(fileInputStream.readAllBytes());
        fileInputStream.close();
        fileOutputStream.close();
    }


    public static void move(String from, String to) throws IOException {
        copy(from,to);
        deleteOldFiles(from);
    }

    private static void deleteOldFiles(String from){
        File[] file = new File(from).listFiles();
        for(int i = 0; i < file.length; i++){
            if (file[i].isDirectory()){
                deleteOldFiles(file[i].toString());
            }
            file[i].delete();
        }
    }

    public static boolean isEmpty (String path) throws IOException {
        File file = new File(path);
        if(file.isDirectory()){
            if (countFiles(path) == 0) {
                return true;
            }
            return false;
        } else if (file.isFile()) {
            InputStream inputStream = new FileInputStream(path);
            if (inputStream.read() == -1) {
                return true;
            }
        }
        return false;
    }
}
