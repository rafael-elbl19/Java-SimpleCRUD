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

        long hours = duration.toHours();
        if (hours < 24 && hours > 0) {
            return 1.0;
        } else if (hours >= 24) {
            return Math.ceil((double) hours / 24);
        } else {
            return 0.0;
        }
    }

    public Double finalBill(Double days, Double valuePerDays) {
        this.total = taxService.afterTaxes(days, valuePerDays);
        return this.total;
    }

}
