/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rest.api.photoz_Clone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author zeemo
 */
@Getter
@Setter
@Table("PHOTOZ")
public class Photo {

    @Id
    private int id;
    @NotEmpty(message = "File name is required")
    private String FileName;
    @JsonIgnore
    private byte[] data;
    private String contentType;

    public Photo() {
    }

    public Photo(int id, String FileName, byte[] data) {
        this.id = id;
        this.FileName = FileName;
        this.data = data;
    }

}
