/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rest.api.photoz_Clone.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.photoz_Clone.model.Photo;
import com.rest.api.photoz_Clone.reposittory.PhotozRepository;

/**
 *
 * @author zeemo
 */
// @Component
@Service
public class PhotoServices {

    private final PhotozRepository photozRepository;

    public PhotoServices(@Autowired PhotozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }

    public Iterable<Photo> getAll() {
        return photozRepository.findAll();
    }

    public Photo get(int id) {
        // TODO Auto-generated method stub
        return photozRepository.findById(id).orElse(null);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        // photo.setId(idGenerator());
        photo.setFileName(fileName);
        photo.setData(data);
        photo.setContentType(contentType);
        photozRepository.save(photo);
        return photo;

    }

    public void remove(int id) {
        photozRepository.deleteById(id);
    }

    private String idGenerator() {
        // TODO Auto-generated method stub
        return UUID.randomUUID().toString();

    }

}
