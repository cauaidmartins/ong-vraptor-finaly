/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ong.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Lucas Rasec
 */
@NoArgsConstructor
@Data
@Entity
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ca_gen")
    @SequenceGenerator(name = "ca_gen", initialValue = 1, allocationSize = 1, sequenceName = "case_seq")
    private Integer code;

    @Column(nullable = false)
    private Number value;
    
    private String desc;

}
