package com.revature.project_p2.utility;


import java.io.InputStream;

public interface IFileStore {

    void save(String path, String fileName, InputStream inputStream);

    byte[] download(String path, String key);



}
