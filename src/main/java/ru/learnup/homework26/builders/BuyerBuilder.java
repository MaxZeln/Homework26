package ru.learnup.homework26.builders;

import ru.learnup.homework26.entity.Buyer;

public class BuyerBuilder {

    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String birthday;

    public BuyerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BuyerBuilder withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public BuyerBuilder withPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    public BuyerBuilder withBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public Buyer build() {
        Buyer buyer = new Buyer();
        buyer.setName(name);
        buyer.setSurname(surname);
        buyer.setPatronymic(patronymic);
        buyer.setBirthday(birthday);
        return buyer;
    }

}