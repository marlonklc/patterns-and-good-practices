package com.gofdesignpatterns.structural.Composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Folder implements Path {

    private String folderName;
    private Folder parentFolder;
    private List<Path> children = new ArrayList<>();

    private Folder(Folder parentFolder, String folderName, Path... paths) {
        this.folderName = folderName;
        this.parentFolder = parentFolder;
        children.addAll(Arrays.asList(paths));
    }

    public static Folder of(Folder parentFolder, String folderName, Path... paths) {
        return new Folder(parentFolder, folderName, paths);
    }

    public Folder add(Path path) {
        children.add(path);
        return this;
    }

    public Folder remove(Path path) {
        children.remove(path);
        return this;
    }

    @Override
    public Path parent() {
        return parentFolder;
    }

    @Override
    public List<Path> children() {
        return children;
    }

    @Override
    public String name() {
        return folderName;
    }

    @Override
    public long size() {
        return children.stream()
            .map(Path::size)
            .reduce(0l, Long::sum);
    }

    @Override
    public String toString() {
        return folderName;
    }
}
