package com.yasynskyi.filework;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTest {
    @Test
    public void testCountFilesReturnTrueOnEmptyFolder() {
        String testPath = "C:\\Users\\Den\\Desktop\\LuxCampus\\ДЗ\\HomeworkTwo\\src\\test\\testfolder\\Folder1\\Folder2\\Folder6";
        assertEquals(0, FileManager.countFiles(testPath));
    }


    @Test
    public void testCountFilesReturnTrueOnNotEmptyFolder() {
        String testPath = "C:\\Users\\Den\\Desktop\\LuxCampus\\ДЗ\\HomeworkTwo\\src\\test\\testfolder";
        assertTrue(FileManager.countFiles(testPath) > 0);
    }

    @Test
    public void testCountFilesReturnTrueOnCorrectNumberOfFiles() {
        String testPath = "C:\\Users\\Den\\Desktop\\LuxCampus\\ДЗ\\HomeworkTwo\\src\\test\\testfolder";
        assertEquals(12, FileManager.countFiles(testPath));
    }

    @Test
    public void testCountDirsReturnTrueOnEmptyFolder() {
        String testPath = "C:\\Users\\Den\\Desktop\\LuxCampus\\ДЗ\\HomeworkTwo\\src\\test\\testfolder\\Folder1\\Folder2\\Folder6";
        assertEquals(0, FileManager.countDirs(testPath));
    }

    @Test
    public void testCountDirsReturnTrueOnNotEmptyFolder() {
        String testPath = "C:\\Users\\Den\\Desktop\\LuxCampus\\ДЗ\\HomeworkTwo\\src\\test\\testfolder";
        assertTrue(FileManager.countDirs(testPath) > 0);
    }

    @Test
    public void testCountDirsReturnTrueOnCorrectNumberOfFiles() {
        String testPath = "C:\\Users\\Den\\Desktop\\LuxCampus\\ДЗ\\HomeworkTwo\\src\\test\\testfolder";
        assertEquals(6, FileManager.countDirs(testPath));
    }

    @Test
    public void testIsEmptyReturnTrueOnEmptyFile() throws IOException {
        String testPath = "C:\\Users\\Den\\Desktop\\LuxCampus\\ДЗ\\HomeworkTwo\\src\\test\\testfolder\\Folder1\\Folder2\\Folder3\\Test4";
        assertTrue(FileManager.isEmpty(testPath));
    }

    @Test
    public void testIsEmptyReturnTrueOnEmptyDirectory() throws IOException {
        String testPath = "C:\\Users\\Den\\Desktop\\LuxCampus\\ДЗ\\HomeworkTwo\\src\\test\\testfolder\\Folder1\\Folder2\\Folder4";
        assertTrue(FileManager.isEmpty(testPath));
    }

    @Test
    public void testIsEmptyReturnFaleOnNotEmptyDirectory() throws IOException {
        String testPath = "C:\\Users\\Den\\Desktop\\LuxCampus\\ДЗ\\HomeworkTwo\\src\\test\\testfolder\\Folder1\\Folder2\\Folder3";
        assertFalse(FileManager.isEmpty(testPath));
    }

    @Test
    public void testIsEmptyReturnFalseOnNotEmptyFile() throws IOException {
        String testPath = "C:\\Users\\Den\\Desktop\\LuxCampus\\ДЗ\\HomeworkTwo\\src\\test\\testfolder\\Test1";
        assertFalse(FileManager.isEmpty(testPath));
    }

    @Test
    public void testMoveReturnTrueOnEmptyMovedDirectory() throws IOException {
        String to = "C:\\Users\\Den\\Desktop\\LuxCampus\\ДЗ\\HomeworkTwo\\src\\test\\testfolder";
        String from = "C:\\Users\\Den\\Desktop\\LuxCampus\\ДЗ\\HomeworkTwo\\src\\test\\folderforcopy";
        FileManager.move(from,to);
        assertTrue(FileManager.isEmpty(from));
    }

    @Test
    public void testCopyReturnFalseOnEmptyDirectoryWithCopy() throws IOException {
        String from = "C:\\Users\\Den\\Desktop\\LuxCampus\\ДЗ\\HomeworkTwo\\src\\test\\testfolder";
        String to = "C:\\Users\\Den\\Desktop\\LuxCampus\\ДЗ\\HomeworkTwo\\src\\test\\folderforcopy";
        FileManager.copy(from, to);
        assertFalse(FileManager.isEmpty(to));
    }
}
