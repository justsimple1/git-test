package ru.job4j.tracker;

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * Class Profession release UML scheme and his update from previous lesson .
 * @author NikPanin .
 * @version 1.0 .
 * @since 08.08.2018 .
 */
public class Profession {

    private String profession;
    private String name;

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession(){
        return profession;
    }

    public String getName() {
        return name;
    }
}

class Doctor extends Profession{

    public Diagnose heal(Pacient pacient){
        return null;
    }
}
class Diagnose{
    private String titleDisease;

    public void setTitleDisease(String titleDisease){
        this.titleDisease = titleDisease;
    }
    public String getTitleDisease(){
        return titleDisease;
    }
        }
class Pacient{
    private String name;
    private String troubleHealth;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTroubleHealth(String troubleHealth) {
        this.troubleHealth = troubleHealth;
    }

    public String getTroubleHealth() {
        return troubleHealth;
    }


}
class Engineer extends Profession{
    public void build(House house){}
}

class House{
}

class Teacher extends Profession{
    public void teach(Student student){}
}
class Student{
   private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}