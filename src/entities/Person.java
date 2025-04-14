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

    public double calculateDays(String start, String end) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime startDate = LocalDateTime.parse(start, dtf);
        LocalDateTime finalDate = LocalDateTime.parse(end, dtf);

        Duration duration = Duration.between(startDate, finalDate);
        double seconds = duration.getSeconds();
        double days = seconds / (60*60*24);

        //SE O VALOR DE DIAS QUEBRADO FOR MAIOR QUE O CASTING DE DIAS PRA INTEIRO (ARREDONDA PRA BAIXO)
        if (days > (int) days) {
            //DIAS RECEBE O ARREDONDAMENTO E MAIS UMA DIÁRIA
            days = (int) days + 1;
        }
        return days;
    }

}
