package com.ong.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Martins
 */
@NoArgsConstructor
@Data
@Entity(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "us_gen")
    @SequenceGenerator(name = "us_gen", initialValue = 1, allocationSize = 1, sequenceName = "user_seq")
    private Integer code;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String cpf;

    @Column(nullable = false)
    private Integer value;

}
