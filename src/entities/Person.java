package entities;

import services.TaxService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Person {

    private String name;
    private String email;
    private String sex;
    private Integer age;
    private Integer room;
    public Double total;

    

    public TaxService taxService;

    public Person(String name, String email, Integer age, String sex, Integer room) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.sex = sex;
        this.room = room;
    }

    public Person(String name, String email, Integer age, String sex, Integer room, TaxService taxService) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.sex = sex;
        this.room = room;
        this.taxService = taxService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public double calculateDays(String firstDay, String lastDay) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime firstLDT = LocalDateTime.from(dtf.parse(firstDay));
        LocalDateTime lastLDT = LocalDateTime.from(dtf.parse(lastDay));

        Duration duration = Duration.between(firstLDT, lastLDT);

        //MATH.CEIL ARREDONDA O DECIMAL PARA O INTEIRO MAIS PRÓXIMO
        return (int) Math.ceil(duration.getSeconds()) / (60.0*60.0*24.0);
    }

    public void finalBill(Double days, Double valuePerDays) {
        this.total = taxService.afterTaxes(days, valuePerDays);
    }

}
