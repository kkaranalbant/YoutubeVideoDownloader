/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaan.downloader.service.impl;

import com.kaan.downloader.service.DownloadService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.stereotype.Service;

/**
 *
 * @author kaan
 */
@Service
public class YoutubeDownloadService implements DownloadService {

    private static final String DEFAULT_DIR;
    
    private static final String PY_INTERPRETER_DIR ;

    static {
        DEFAULT_DIR = "/";
        PY_INTERPRETER_DIR = "your-py-interpreter-dir" ;
    }

    @Override
    public byte[] downloadVideo(String url) throws IOException {
        ProcessBuilder pBuilder = new ProcessBuilder(PY_INTERPRETER_DIR, "mp3_converter.py", url, DEFAULT_DIR);

        Process process = pBuilder.start();

        StringBuilder sb = new StringBuilder();

        BufferedReader bReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line = null;

        while ((line = bReader.readLine()) != null) {
            sb.append(line);
        }

        bReader.close();

        String fileName = sb.toString();
        
        File file = new File(fileName);

        FileInputStream fis = new FileInputStream(file);

        byte[] result = fis.readAllBytes();

        fis.close();
        
        process.destroy();

        return result;

    }

}
