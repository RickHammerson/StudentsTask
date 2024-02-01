package ru.rickh.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.Data;
import ru.rickh.model.Student;
import ru.rickh.util.PrintUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

@Data
public class FileService {
    private ObjectMapper objectMapper=new ObjectMapper();
    private File studentsFile;
    public List<Student> load(String filePath) throws RuntimeException, IOException {
        if (StringUtils.isEmpty(filePath)) {
            throw new RuntimeException("Переданный путь к файлу пустой");
        }
        File file = new File(filePath);
        if (!file.exists() || file.isDirectory()) {
            throw new RuntimeException("Файла с таким путём не существует или он является папкой");
        }
        this.studentsFile = file;
        return objectMapper.readValue(file,new TypeReference<List<Student>>(){});
    }
    
    public List<Student> create() throws RuntimeException, IOException {
        this.studentsFile = new File("created.txt");
        studentsFile.createNewFile();
        return new ArrayList<>();
    }
    
    public void save(List<Student> students) throws IOException {
        FileWriter fileWriter = new FileWriter(studentsFile,false);
        objectMapper.writeValue(fileWriter, students);
    }
}
