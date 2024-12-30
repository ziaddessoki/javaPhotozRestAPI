/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rest.api.photoz_Clone.reposittory;

import org.springframework.data.repository.CrudRepository;

import com.rest.api.photoz_Clone.model.Photo;

/**
 *
 * @author zeemo
 */
public interface PhotozRepository extends CrudRepository<Photo, Integer> {

}
