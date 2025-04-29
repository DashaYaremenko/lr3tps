package org.example.lr3tps.dbModel;

import jakarta.persistence.*;

@Entity
@Table(name = "stations")
public class StationClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NameStation")
    private String nameStation;

    public StationClass(String nameStation) {
        this.nameStation = nameStation;
    }

    public StationClass() {}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNameStation() {return nameStation;}
    public void setNameStation(String nameStation) {this.nameStation = nameStation;}
}
