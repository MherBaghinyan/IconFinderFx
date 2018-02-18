package com.memento.model;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Gebruiker on 2/18/2018.
 */
public class MementoResponseParser {

    public MementoResponseModel jsonToModel() throws FileNotFoundException {

        Gson gson = new Gson();

        String fileName = "iconfinder.json";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        return gson.fromJson(new FileReader(file.getAbsolutePath()), MementoResponseModel.class);
    }
}
