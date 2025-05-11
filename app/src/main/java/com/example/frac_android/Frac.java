package com.example.frac_android;

import androidx.annotation.NonNull;

/**
 * Высоцкая И.Д.
 * Класс - ссылочный тип в Java, при объявлении переменной, создаётся не объект, а ссылка на него, все классы Java наследуются от класса Object
 * Пример:
 * public com.example.frac_android.Frac first = new com.example.frac_android.Frac(); // создание дроби, ссылка и запись ячейки памяти
 * private com.example.frac_android.Frac fract // создание ссылки на объект
 * private - область класса, где данные защищены от доступа функций, расположенных вне класса(принцип сокрытия)
 * public - область класса, данные в которой доступны за пределами класса
 */
public class Frac {
    private int num; // числитель
    private int den; // знаменатель

    // Конструктор по умолчанию
    public Frac()
    {
        num = 0; // по умолчанию числитель равен 0
        den = 1; // по умолчанию знаменатель равен 1
    }

    /**
     * Конструктор с параметрами
     * int numinator - числитель, int denominator - знаменатель
     */
    public Frac(int numinator, int denominator)
    {
        setNum(numinator); // числитель
        setDen(denominator); // знаменатель
    }

    /**
     * Метод инициализации числителя
     * int num - числитель
     */
    public void setNum(int num)
    {
        this.num = num; // инициализация числителя
    }

    /**
     * Метод инициализации знаменателя
     * int denom - знаменатель
     */
    public void setDen(int denom)
    {
        if (denom != 0) // если не равен 0
        {
            den = denom; // инициализация знаменателя
        }
        else {
            den = 1; // иначе становится равен 1
        }
    }

    /**
     * Метод для просмотра значения числителя
     */
    public int getNum()
    {
        return num; // возвращаем числитель
    }

    /**
     * Метод для просмотра значения знаменателя
     */
    public int getDen()
    {
        return den; // возвращаем знаменатель
    }

    /**
     * Метод для перевода в строку
     * @Override - переопределение
     */
    @NonNull
    @Override
    public String toString()
    {
        return num + "/" + den; // возвращаем строку числитель/знаменатель
    }

    /**
     * Метод сложения двух дробей
     * static - метод может быть вызван без создания объекта класса
     * Frac first_frac - первая дробь, Frac second_frac - вторая дробь
     */
    static public Frac summ(Frac first_frac, Frac second_frac)
    {
        Frac rez = new Frac(); // переменная класса дробь для записи результата
        if (first_frac.getDen() != second_frac.getDen()) // если знаменатели дробей не равны
        {
            int new_den = first_frac.getDen() * second_frac.getDen(); // вычисляем НОЗ
            int new_num1 = first_frac.getNum() * second_frac.getDen(); // вычисляем первый новый числитель
            int new_num2 = second_frac.getNum() * first_frac.getDen(); // вычисляем второй новый числитель
            rez.setDen(new_den); // записываем новый знаменатель вычисленной дроби
            rez.setNum(new_num1 + new_num2); // вычисляем и записываем новый числитель вычисленной дроби
        }
        else // иначе(если знаменатели дробей равны)
        {
            rez.setDen(first_frac.getDen()); // за новый знаменатель берём знаменатель первой дроби
            int num1 = first_frac.getNum(); // присваиваем переменной числитель первой дроби
            int num2 = second_frac.getNum(); // присваиваем переменной числитель второй дроби
            rez.setNum(num1 + num2); // вычисляем новый числитель
        }
        return rez; // возвращаем результат
    }

    /**
     * Метод перемножения двух дробей
     * static - метод может быть вызван без создания объекта класса
     * Frac first_frac - первая дробь, Frac second_frac - вторая дробь
     */
    static public Frac comp(Frac first_frac, Frac second_frac)
    {
        Frac rez = new Frac(); // переменная класса дробь для записи результата
        int new_num = first_frac.getNum() * second_frac.getNum(); // умножаем числитель первой дроби на числитель второй дроби
        int new_den = first_frac.getDen() * second_frac.getDen(); // умножаем знаменатель первой дроби на знаменатель второй дроби
        rez.setNum(new_num); // записываем новый числитель вычисленной дроби
        rez.setDen(new_den); // записываем новый знаменатель вычисленной дроби
        return rez; // возвращаем результат
    }

    /**
     * Метод разности двух дробей
     * static - метод может быть вызван без создания объекта класса
     * Frac first_frac - первая дробь, Frac second_frac - вторая дробь
     */
    static public Frac minus(Frac first_frac, Frac second_frac)
    {
        Frac rez = new Frac(); // переменная класса дробь для записи результата
        if (first_frac.getDen() != second_frac.getDen()) // если знаменатели не равны
        {
            int new_den = first_frac.getDen() * second_frac.getDen(); // вычисляем НОЗ
            int new_num1 = first_frac.getNum() * second_frac.getDen(); // вычисляем первый новый числитель
            int new_num2 = second_frac.getNum() * first_frac.getDen(); // вычисляем второй новый числитель
            rez.setDen(new_den); // записываем новый знаменатель вычисленной дроби
            rez.setNum(new_num1 - new_num2); // вычисляем и записываем новый числитель вычисленной дроби
        }
        else // иначе(если знаменатели дробей равны)
        {
            rez.setDen(first_frac.getDen()); // за новый знаменатель берём знаменатель первой дроби
            int num1 = first_frac.getNum(); // присваиваем переменной числитель первой дроби
            int num2 = second_frac.getNum(); // присваиваем переменной числитель второй дроби
            rez.setNum(num1 - num2); // вычисляем новый числитель
        }
        return rez; // возвращаем результат
    }

    /**
     * Метод деления двух дробей
     * static - метод может быть вызван без создания объекта класса
     * Frac first_frac - первая дробь, Frac second_frac - вторая дробь
     */
    static public Frac divis(Frac first_frac, Frac second_frac)
    {
        Frac rez = new Frac(); // переменная класса дробь для записи результата
        int new_num = first_frac.getNum() * second_frac.getDen(); // умножаем числитель первой дроби на знаменатель второй дроби
        int new_den = first_frac.getDen() * second_frac.getNum(); // умножаем знаменатель первой дроби на числитель второй дроби
        if (new_den != 0)
        {
            rez.setNum(new_num); // записываем новый числитель вычисленной дроби
            rez.setDen(new_den); // записываем новый знаменатель вычисленной дроби
            return rez; // возвращаем результат
        }
        else
        {
            throw new RuntimeException(); // кидаем сообщение об ошибке
        }
    }

    /**
     * Метод перевода в десятичную дробь
     */
    public float dec()
    {
        float rez; // переменная для записи результата
        rez = (float) (getNum()) / (float) getDen(); // перевод в десятичную дробь
        return rez; // возвращаем результат
    }

}
