/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmi;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "bmi")
@SessionScoped
public class CalculatorBMI implements Serializable {
    
    private Integer weight;
    private Integer height;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return height;
    }

    public String calculate() {
        if (weight > 0 && height > 0) {
            double BMI = weight / (height / 100 * height / 100);
            if (BMI < 18.5) {
                result = "That you are too thin.";
            }
            if (BMI > 18.5 && BMI < 25) {
                result = "That you are healthy.";
            }
            if (BMI > 25) {
                result = "That you have overweight.";
            }
        } else {
            result = "Please Fill in everything correctly";

        }
        return result;
    }

}
