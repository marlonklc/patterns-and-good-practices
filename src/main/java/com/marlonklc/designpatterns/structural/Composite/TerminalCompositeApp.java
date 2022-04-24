package com.marlonklc.designpatterns.structural.Composite;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class TerminalCompositeApp {

    public static void main(String[] args) {
        Folder rootFolder = Folder.of(null, "/");
        Folder homeFolder = Folder.of(rootFolder, "home");
        Folder userFolder = Folder.of(homeFolder, "user");
        homeFolder.add(userFolder);
        rootFolder.add(homeFolder);
        Folder currentFolder = userFolder;
        printInput(currentFolder);

        try (Scanner scanner = new Scanner(System.in)) {
            String line;
            while ((line = scanner.nextLine()) != null) {
                if (line.isBlank()) {
                    printInput(currentFolder);
                    continue;
                }

                String[] command = line.split(" ");

                switch (command[0]) {
                    case "du":
                        if (command.length <= 2) break;
                        String argument1 = command[1];
                        String argument2 = command[2];
                        if ("-sh".equals(argument1) && ".".equals(argument2)) {
                            long size = currentFolder.size();
                            double kb = (double) size / 1024;
                            double mb = kb / 1024;
                            double gb = mb / 1024;
                            printOutput(String.format("%.2f", gb) + " Gb");
                        }
                        break;

                    case "mkdir": {
                        if (command.length <= 1) {
                            printOutput("missing parameter {folder name}");
                            break;
                        }
                        String argument = command[1];
                        if (hasPathWithSameName(currentFolder, argument)) {
                            printOutput("cannot create directory '%s': file already exists");
                            break;
                        }
                        currentFolder.add(Folder.of(currentFolder, argument));
                        break;
                    }

                    case "touch": {
                        if (command.length <= 1) {
                            printOutput("missing parameter {file name}");
                            break;
                        }
                        String argument = command[1];
                        if (hasPathWithSameName(currentFolder, argument)) break;
                        int sizeOfFile = new Random().nextInt();
                        currentFolder.add(File.of(currentFolder, argument, Integer.signum(sizeOfFile) == -1 ? 0 : sizeOfFile));
                        break;
                    }

                    case "pwd": {
                        printOutput(Color.WHITE_BOLD.print(generatePwd(currentFolder)));
                        break;
                    }

                    case "ls": {
                        String output = currentFolder.children()
                            .stream()
                            .map(path -> {
                                if (path instanceof Folder) return Color.BLUE_BOLD.print(path.name());
                                else return Color.WHITE_BOLD.print(path.name());
                            })
                            .collect(Collectors.joining(" "));

                        if (output.isBlank()) break;
                        printOutput(output);
                        break;
                    }

                    case "cd": {
                        if (command.length <= 1) break;
                        String argument = command[1];

                        if ("~".equals(argument)) {
                            currentFolder = userFolder;
                            break;
                        }
                        if ("/".equals(argument)) {
                            currentFolder = rootFolder;
                            break;
                        }
                        if ("..".equals(argument)) {
                            if (nonNull(currentFolder.parent())) {
                                currentFolder = (Folder) currentFolder.parent();
                            }
                            break;
                        }
                        Optional<Path> targetPath = currentFolder.children()
                            .stream()
                            .filter(path -> path.name().equals(argument))
                            .findAny();
                        if (!targetPath.isPresent()) {
                            printOutput("no such file or directory");
                            break;
                        }
                        if (targetPath.get() instanceof File) {
                            printOutput("not a directory");
                            break;
                        }
                        currentFolder = (Folder) targetPath.get();
                        break;
                    }

                    default:
                        printOutput("command not found");
                }

                printInput(currentFolder);
            }
        }
    }

    private static void printOutput(String output) {
        System.out.println(output);
    }

    private static void printInput(Path currentFolder) {
        String pwd = generatePwd(currentFolder);
        System.out.print("user@gof:" + pwd + "$ ");
    }

    private static String generatePwd(Path currentFolder) {
        if (isNull(currentFolder.parent())) return currentFolder.name();

        StringBuilder sb = new StringBuilder();
        Path folder = currentFolder;

        while (nonNull(folder)) {
            if (nonNull(folder.parent())) sb.insert(0, "/" + folder.name());
            folder = folder.parent();
        }

        return sb.toString();
    }

    private enum Color {
        WHITE_BOLD() {
            @Override
            String print(String text) {
                return "\033[1;38m" + text + "\033[0m";
            }
        },
        BLUE_BOLD() {
            @Override
            String print(String text) {
                return "\033[1;34m" + text + "\033[0m";
            }
        };

        abstract String print(String text);
    }

    private static boolean hasPathWithSameName(Folder currentFolder, String name) {
        return currentFolder.children()
            .stream()
            .anyMatch(path -> path.name().equals(name));
    }
}
