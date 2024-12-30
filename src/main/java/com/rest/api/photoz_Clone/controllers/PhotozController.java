/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rest.api.photoz_Clone.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.rest.api.photoz_Clone.model.Photo;
import com.rest.api.photoz_Clone.services.PhotoServices;

/**
 *
 * @author zeemo
 */
@RestController
public class PhotozController {

    private final PhotoServices photoServices;

    public PhotozController(@Autowired PhotoServices photoServices) {
        this.photoServices = photoServices;
    }

    // final List<Photo> db =  List.of(new Photo(1,"image1"));
    @GetMapping("/")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/photoz")
    public Iterable<Photo> get() {
        return photoServices.getAll();
    }

    @GetMapping("/photo/{id}")
    public Photo get(@PathVariable int id) {
        Photo photo = photoServices.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    @DeleteMapping("/photo/{id}")
    public void delete(@PathVariable int id) {
        photoServices.remove(id);
    }

    @PostMapping("/photo")
    public ResponseEntity<Object> add(@RequestParam(value = "data", required = false) MultipartFile file) throws IOException {
        // Photo photo=  new Photo(UUID.randomUUID().toString(),"image2");
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("No file uploaded or file is empty");
        }
        Photo photo = photoServices.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return ResponseEntity.status(HttpStatus.CREATED).body(photo);
    }

}
