package com.gofdesignpatterns.structural.Composite;

public class CompositeApp {

    static long bytes = 1024;

    public static void main(String[] args) {

        Folder rootFolder = Folder.of(null, "/");
        rootFolder.add(File.of(rootFolder, "file1.txt", 2000));
        rootFolder.add(File.of(rootFolder, "file2.mp3", 2555000));

        Folder folder1 = Folder.of(rootFolder, "folder");
        Folder folder2 = Folder.of(folder1, "folder");
        folder1.add(folder2);
        folder2.add(File.of(folder2, "video1.avi", 1211555000));
        folder2.add(File.of(folder2, "video2.avi", 911555000));

        rootFolder.add(folder1);

        long size = rootFolder.size();
        double kb = (double) size / bytes;
        double mb = kb / bytes;
        double gb = mb / bytes;
        System.out.println(size + " Bytes");
        System.out.println(format(kb) + " Kb");
        System.out.println(format(mb) + " Mb");
        System.out.println(format(gb) + " Gb");
    }

    public static String format(double value) {
        return String.format("%.2f", value);
    }
}
