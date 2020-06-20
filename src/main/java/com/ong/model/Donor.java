/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ong.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Data;

/**
 *
 * @author Martins
 */
@Data
@Entity
public class Donor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "donor_gen")
    @SequenceGenerator(name = "donor_gen", initialValue = 1, allocationSize = 1, sequenceName = "donor_seq")
    private Integer code;

    @Column(nullable = false)
    private String name;

    private String donor;


}
