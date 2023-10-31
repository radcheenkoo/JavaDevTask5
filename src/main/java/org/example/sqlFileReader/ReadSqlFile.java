package org.example.sqlFileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ReadSqlFile {
    public String readFileContent(String filePath) throws IOException {
        StringBuffer sb = new StringBuffer();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.lines().forEach(sb::append);
        }
        return sb.toString();
    }
}
