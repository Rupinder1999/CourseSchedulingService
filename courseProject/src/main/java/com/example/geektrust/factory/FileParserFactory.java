package com.example.geektrust.factory;

import com.example.geektrust.interfaces.services.IFileParserService;
import com.example.geektrust.services.fileparser.TxtFileParserService;

import static com.example.geektrust.constant.FileType.TXT;

public class FileParserFactory {
    public  static IFileParserService getFileParserService(String fileType){
        switch (fileType){
            case TXT:
                return new TxtFileParserService();
            default:
                return new TxtFileParserService() ;
        }
    }
}
