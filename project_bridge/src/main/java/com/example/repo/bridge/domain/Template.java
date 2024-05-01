package com.example.repo.bridge.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.yaml.snakeyaml.events.Event;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table
public class Template {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long templateId;

    private String content;

    private int score;

    @OneToMany(mappedBy = "template")
    private List<Validate> validates;

}
