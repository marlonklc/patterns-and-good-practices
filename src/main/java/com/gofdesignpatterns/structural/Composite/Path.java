package com.gofdesignpatterns.structural.Composite;

import java.util.List;

public interface Path {

    String name();
    Path parent();
    List<Path> children();
    long size();
}
