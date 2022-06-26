package ru.learnup.homework26.exeption;

public class NotEnoughItems extends Throwable {
    static int count = 0;
    String name;

    public NotEnoughItems(String name){
        count++;
        this.name = name;
    }

    @Override
    public String toString(){
        String text="\nВозникла ошибка!\n";
        text += "Описание: " + name + "\n";
        text += "Номер ошибки: " + count;
        return text;}
}
