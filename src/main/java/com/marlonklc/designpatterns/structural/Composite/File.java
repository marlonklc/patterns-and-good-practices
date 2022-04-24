package com.marlonklc.designpatterns.structural.Composite;

import java.util.List;

public class File implements Path {

    private Folder parentFolder;
    private String fileName;
    private long sizeInBytes;

    private File(Folder folder, String fileName, long sizeInBytes) {
        this.fileName = fileName;
        this.parentFolder = parentFolder;
        this.sizeInBytes = sizeInBytes;
    }

    public static File of(Folder parentFolder, String fileName, long sizeInBytes) {
        return new File(parentFolder, fileName, sizeInBytes);
    }

    @Override
    public Path parent() {
        return parentFolder;
    }

    @Override
    public String name() {
        return fileName;
    }

    @Override
    public List<Path> children() {
        return null;
    }

    @Override
    public long size() {
        return sizeInBytes;
    }

    @Override
    public String toString() {
        return fileName;
    }
}
