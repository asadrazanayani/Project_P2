package com.revature.project_p2.utility;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class LocalStore implements IFileStore {

    @Value("${local.Store.Path}")
    private String localStorePath;

    @Override
    public void save(String path, String fileName, InputStream inputStream) {
        Path pathToFile = Paths.get(localStorePath+"/"+path+"/"+fileName);
        byte[] buffer;
        try {
            buffer = java.nio.file.Files.readAllBytes(pathToFile);
            File targetFile = new File("src/test/resources/targetFile.tmp");
            OutputStream outStream = new FileOutputStream(targetFile);
            outStream.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public byte[] download(String path, String key) {
        File pathToFile = new File(
                localStorePath+"/"+path+"/"+key);

        byte[] array;
        try {
            array = method(pathToFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Printing the byte array
        System.out.print(Arrays.toString(array));


    }

    private static byte[] method(File file)
            throws IOException
    {

        // Creating an object of FileInputStream to
        // read from a file
        FileInputStream fl = new FileInputStream(file);

        // Now creating byte array of same length as file
        byte[] arr = new byte[(int)file.length()];

        // Reading file content to byte array
        // using standard read() method
        fl.read(arr);

        // lastly closing an instance of file input stream
        // to avoid memory leakage
        fl.close();

        // Returning above byte array
        return arr;
    }


}