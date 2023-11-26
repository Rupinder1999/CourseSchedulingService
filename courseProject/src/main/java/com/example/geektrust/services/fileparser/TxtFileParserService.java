package com.example.geektrust.services.fileparser;

import com.example.geektrust.interfaces.services.IFileParserService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TxtFileParserService implements IFileParserService {
    @Override
    public List<String[]> parseFile(String filePath) {
        List<String[]> commands= new ArrayList<>();
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(filePath);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String command[]=line.split(" ");
                commands.add(command);
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }
        return commands ;
    }
}
