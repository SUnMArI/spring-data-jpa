package com.example.demo.model.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "classes")
public class Class {
    @Id
    @GeneratedValue(strategy =GenerationType.UUID)
    private UUID classId;
}
