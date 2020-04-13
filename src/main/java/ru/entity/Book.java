package ru.entity;

import javax.persistence.*;

@Entity
@Table(name ="carbook", schema = "public", catalog = "zlt36")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", length = 6, nullable = false, columnDefinition = "serial")
    private long id;
    @Column(name="carnum", length = 10, nullable = false)
    private String carNum;
    @Column(name="carcolor", length = 30, nullable = false)
    private String carColor;
    @Column(name="caryear",  nullable = false)
    private Integer carYear;
    @Column(name="carmodel", length = 40, nullable = false)
    private String carModel;
    public Book() {}

    public long getId() {        return id;    }
    public void setId(long id) {        this.id = id;    }
    public String getCarNum() {        return carNum;    }
    public void setCarNum(String carNum) {       this.carNum = carNum;    }
    public String getCarColor() {        return carColor;    }
    public void setCarColor(String carColor) {        this.carColor = carColor;    }
    public Integer getCarYear() {        return carYear;    }
    public void setCarYear(Integer carYear) {        this.carYear = carYear;    }
    public String getCarModel() {        return carModel;    }
    public void setCarModel(String carModel) {        this.carModel = carModel;    }
}
