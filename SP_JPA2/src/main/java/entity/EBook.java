/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sanox
 */
@Entity
public class EBook extends Book implements Serializable {

    private static final long serialVersionUID = 1L;
    private int isbn;
    private String URL;
    private double MBSize;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public double getMBSize() {
        return MBSize;
    }

    public void setMBSize(double Size) {
        this.MBSize = Size;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

}
