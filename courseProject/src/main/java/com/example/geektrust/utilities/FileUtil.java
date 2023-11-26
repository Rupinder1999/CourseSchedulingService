package com.example.geektrust.utilities;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.example.geektrust.constant.FileType.TXT;

public class FileUtil {
    public static String getFileType(String filePath){

        Path path = Paths.get(filePath);
        String fileName = path.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex != -1 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex + 1);
        }
        //I am assuming default file as txt
        return TXT;
    }
}
