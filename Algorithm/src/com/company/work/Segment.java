package com.company.work;

import lombok.Data;

import java.util.List;

@Data
public class Segment {
    private int id;

    private String name;

    private List<Component> components;
}
