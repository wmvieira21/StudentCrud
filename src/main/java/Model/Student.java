/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author willi
 */
public class Student {

    private Integer id;
    private String name;
    private String course;
    private Double fee;

    public Student(Integer id, String name, String coruse, Double fee) {
        this.name = name;
        this.course = coruse;
        this.fee = fee;
        this.id = id;
    }

    public Student(String name, String coruse, Double fee) {
        this.name = name;
        this.course = coruse;
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
