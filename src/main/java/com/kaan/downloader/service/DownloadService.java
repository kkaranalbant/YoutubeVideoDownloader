/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaan.downloader.service;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Service;

/**
 *
 * @author kaan
 */
@Service
public interface DownloadService {
    
    public byte [] downloadVideo (String url) throws IOException ;
    
    
}
