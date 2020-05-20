package com.example.apipoc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Y.Parasuram
 *
 */
public class Counter {

    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Value")
    private Integer value;
    public Counter(Integer id, String name, Integer value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void increaseCount() {
        value = value + 1;
    }

}
