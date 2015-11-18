package com.springapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Cuong on 2015/11/18.
 */
@Entity
@Table(name = "mst_japan")
public class Japanese implements Serializable {

    @Id
    @Column(name = "code_level")
    private String codeLevel;

    @Column(name = "name_level")
    private String nameLevel;

    public String getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(String codeLevel) {
        this.codeLevel = codeLevel;
    }

    public String getNameLevel() {
        return nameLevel;
    }

    public void setNameLevel(String nameLevel) {
        this.nameLevel = nameLevel;
    }
}
