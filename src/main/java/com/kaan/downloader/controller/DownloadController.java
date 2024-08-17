/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaan.downloader.controller;

import com.kaan.downloader.dao.DownloadRequest;
import com.kaan.downloader.service.DownloadService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kaan
 */
@RestController
public class DownloadController {

    private DownloadService downloadService;

    public DownloadController(DownloadService downloadService) {
        this.downloadService = downloadService;
    }

    @PostMapping("/download")
    public @ResponseBody
    byte[] downloadVideo(@RequestBody DownloadRequest downloadRequest) {
        byte[] result = null;
        try {
            result = downloadService.downloadVideo(downloadRequest.getUrl());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
