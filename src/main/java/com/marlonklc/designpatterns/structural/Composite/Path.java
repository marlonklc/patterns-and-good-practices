package com.marlonklc.designpatterns.structural.Composite;

import java.util.List;

public interface Path {

    String name();
    Path parent();
    List<Path> children();
    long size();
}
