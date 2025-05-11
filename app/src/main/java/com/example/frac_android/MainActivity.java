package com.example.frac_android;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

/**
 * Высоцкая И.Д.
 * Главный класс активности приложения для выполнения операций над обыкновенными дробями
 * Наследуется от AppCompatActivity, который предоставляет совместимость с современными функциями Android и упрощает управление активностью на разных версиях ОС
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Метод жизненного цикла активности, вызываемый при её создании.
     * savedInstanceState Содержит данные, сохранённые при предыдущем закрытии активности, или null, если активность создаётся впервые
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Вызывает реализацию метода onCreate в родительском классе AppCompatActivity для инициализации базовых компонентов активности
        EdgeToEdge.enable(this); // Включает режим отображения приложения в полноэкранном режиме, позволяя контенту занимать область системных панелей
        setContentView(R.layout.activity_main); // Устанавливает XML-лейаут activity_main.xml в качестве пользовательского интерфейса активности.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> { // Устанавливает слушатель для обработки отступов (insets) системных панелей, чтобы контент не перекрывался ими.
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()); // Получает размеры системных панелей (статус-бар, навигационная панель) для корректного размещения контента.
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom); // Устанавливает отступы для корневого View (с id "main") в соответствии с размерами системных панелей.
            return insets; // Возвращает объект insets для дальнейшей обработки системой, подтверждая, что отступы применены.
        });
    }

    public Frac frac1 = new Frac(); // поле для хранения первой дроби
    public Frac frac2 = new Frac(); // поле для хранения второй дроби
    public Frac ans; // поле для хранения ответа


    public final int errzero = 0xE0FF8888; // цвет поля для нулевого введенного числа (розовый)

    public final int errnonum = 0xE0FF3333; // цвет поля для невозможности преобразования введенного значения (красный)

    /**
     * Обработчик нажатия кнопки "+" для вычисления суммы двух дробей
     * view View-объект кнопки, вызвавшей событие
     */
    public void onClickAdd(View view)
    {
        TextInputEditText num1 = findViewById(R.id.num1); // находит поле ввода числителя первой дроби для получения введённого пользователем значения
        num1.setBackground(null);
        TextInputEditText num2 = findViewById(R.id.num2); // находит поле ввода числителя второй дроби для получения введённого пользователем значения
        num2.setBackground(null);
        TextInputEditText den1 = findViewById(R.id.den1); // находит поле ввода знаменателя первой дроби для получения введённого пользователем значения
        den1.setBackground(null);
        TextInputEditText den2 = findViewById(R.id.den2); // находит поле ввода знаменателя второй дроби для получения введённого пользователем значения
        den2.setBackground(null);

        // инициализация
        int num1f;
        int num2f;
        int den1f;
        int den2f;

        try
        {
            num1f = Integer.parseInt(String.valueOf(num1.getText())); // пробуем преобразовать введенное пользователем число
        } catch (NumberFormatException e) // если невозможно преобразовать
        {
            num1.setBackgroundColor(errnonum); // меняем цвет поля на красный
            return;
        }

        try
        {
            num2f = Integer.parseInt(String.valueOf(num2.getText())); // пробуем преобразовать введенное пользователем число
        } catch (NumberFormatException e) // если невозможно преобразовать
        {
            num2.setBackgroundColor(errnonum); // меняем цвет поля на красный
            return;
        }

        try
        {
            den1f = Integer.parseInt(String.valueOf(den1.getText())); // пробуем преобразовать введенное пользователем число
        } catch (NumberFormatException e) // если невозможно преобразовать
        {
            den1.setBackgroundColor(errnonum); // меняем цвет поля на красный
            return;
        }
        try
        {
            den2f = Integer.parseInt(String.valueOf(den2.getText())); // пробуем преобразовать введенное пользователем число
        } catch (NumberFormatException e) // если невозможно преобразовать
        {
            den2.setBackgroundColor(errnonum); // меняем цвет поля на красный
            return;
        }
        if (den1f == 0) // если знаменатель первой дроби равен 0
        {
            den1.setBackgroundColor(errzero); // меняем цвет поля на розовый
            return;
        }
        if (den2f == 0) // если знаменатель второй дроби равен 0
        {
            den2.setBackgroundColor(errzero); // меняем цвет поля на розовый
            return;
        }

        frac1.setNum(num1f);
        frac1.setDen(den1f);
        frac2.setNum(num2f);
        frac2.setDen(den2f);

        ans = Frac.summ(frac1, frac2); // вычисление суммы
        TextInputEditText rez = findViewById(R.id.rez); // находит поле для вывода ответа
        rez.setText(ans.toString()); // вывод ответа
    }

    /**
     * Обработчик нажатия кнопки "-" для вычисления разности двух дробей
     * view View-объект кнопки, вызвавшей событие
     */
    public void onClickMin(View view)
    {

        TextInputEditText num1 = findViewById(R.id.num1); // находит поле ввода числителя первой дроби для получения введённого пользователем значения
        num1.setBackground(null);
        TextInputEditText num2 = findViewById(R.id.num2); // находит поле ввода числителя второй дроби для получения введённого пользователем значения
        num2.setBackground(null);
        TextInputEditText den1 = findViewById(R.id.den1); // находит поле ввода знаменателя первой дроби для получения введённого пользователем значения
        den1.setBackground(null);
        TextInputEditText den2 = findViewById(R.id.den2); // находит поле ввода знаменателя второй дроби для получения введённого пользователем значения
        den2.setBackground(null);

        int num1f;
        int num2f;
        int den1f;
        int den2f;

        try
        {
            num1f = Integer.parseInt(String.valueOf(num1.getText())); // пробуем преобразовать введенное пользователем число
        } catch (NumberFormatException e) // если невозможно преобразовать
        {
            num1.setBackgroundColor(errnonum); // меняем цвет поля на красный
            return;
        }

        try
        {
            num2f = Integer.parseInt(String.valueOf(num2.getText())); // пробуем преобразовать введенное пользователем число
        } catch (NumberFormatException e) // если невозможно преобразовать
        {
            num2.setBackgroundColor(errnonum); // меняем цвет поля на красный
            return;
        }

        try
        {
            den1f = Integer.parseInt(String.valueOf(den1.getText())); // пробуем преобразовать введенное пользователем число
        } catch (NumberFormatException e) // если невозможно преобразовать
        {
            den1.setBackgroundColor(errnonum); // меняем цвет поля на красный
            return;
        }
        try
        {
            den2f = Integer.parseInt(String.valueOf(den2.getText())); // пробуем преобразовать введенное пользователем число
        } catch (NumberFormatException e) // если невозможно преобразовать
        {
            den2.setBackgroundColor(errnonum); // меняем цвет поля на красный
            return;
        }
        if (den1f == 0) // если знаменатель первой дроби равен 0
        {
            den1.setBackgroundColor(errzero); // меняем цвет поля на розовый
            return;
        }
        if (den2f == 0) // если знаменатель второй дроби равен 0
        {
            den2.setBackgroundColor(errzero); // меняем цвет поля на розовый
            return;
        }

        frac1.setNum(num1f);
        frac1.setDen(den1f);
        frac2.setNum(num2f);
        frac2.setDen(den2f);

        ans = Frac.minus(frac1, frac2); // вычисление разности
        TextInputEditText rez = findViewById(R.id.rez); // находит поле для вывода ответа
        rez.setText(ans.toString()); // вывод ответа
    }

    /**
     * Обработчик нажатия кнопки "*" для вычисления произведения двух дробей
     * view View-объект кнопки, вызвавшей событие
     */
    public void onClickMul(View view)
    {

        TextInputEditText num1 = findViewById(R.id.num1); // Находит поле ввода числителя первой дроби для получения введённого пользователем значения
        num1.setBackground(null);
        TextInputEditText num2 = findViewById(R.id.num2); // Находит поле ввода числителя второй дроби для получения введённого пользователем значения
        num2.setBackground(null);
        TextInputEditText den1 = findViewById(R.id.den1); // Находит поле ввода знаменателя первой дроби для получения введённого пользователем значения
        den1.setBackground(null);
        TextInputEditText den2 = findViewById(R.id.den2); // Находит поле ввода знаменателя второй дроби для получения введённого пользователем значения
        den2.setBackground(null);

        int num1f;
        int num2f;
        int den1f;
        int den2f;

        try
        {
            num1f = Integer.parseInt(String.valueOf(num1.getText())); // пробуем преобразовать введенное пользователем число
        } catch (NumberFormatException e) // если невозможно преобразовать
        {
            num1.setBackgroundColor(errnonum); // меняем цвет поля на красный
            return;
        }

        try
        {
            num2f = Integer.parseInt(String.valueOf(num2.getText())); // пробуем преобразовать введенное пользователем число
        } catch (NumberFormatException e) // если невозможно преобразовать
        {
            num2.setBackgroundColor(errnonum); // меняем цвет поля на красный
            return;
        }

        try
        {
            den1f = Integer.parseInt(String.valueOf(den1.getText())); // пробуем преобразовать введенное пользователем число
        } catch (NumberFormatException e) // если невозможно преобразовать
        {
            den1.setBackgroundColor(errnonum); // меняем цвет поля на красный
            return;
        }
        try
        {
            den2f = Integer.parseInt(String.valueOf(den2.getText())); // пробуем преобразовать введенное пользователем число
        } catch (NumberFormatException e) // если невозможно преобразовать
        {
            den2.setBackgroundColor(errnonum); // меняем цвет поля на красный
            return;
        }
        if (den1f == 0) // если знаменатель первой дроби равен 0
        {
            den1.setBackgroundColor(errzero); // меняем цвет поля на розовый
            return;
        }
        if (den2f == 0) // если знаменатель второй дроби равен 0
        {
            den2.setBackgroundColor(errzero); // меняем цвет поля на розовый
            return;
        }

        frac1.setNum(num1f);
        frac1.setDen(den1f);
        frac2.setNum(num2f);
        frac2.setDen(den2f);

        ans = Frac.comp(frac1, frac2); // вычисление произведения
        TextInputEditText rez = findViewById(R.id.rez); // находит поле для вывода ответа
        rez.setText(ans.toString()); // вывод ответа
    }

    /**
     * Обработчик нажатия кнопки "/" для вычисления частного двух дробей
     * view View-объект кнопки, вызвавшей событие
     */
    public void onClickDiv(View view)
    {
        TextInputEditText num1 = findViewById(R.id.num1); // Находит поле ввода числителя первой дроби для получения введённого пользователем значения
        num1.setBackground(null);
        TextInputEditText num2 = findViewById(R.id.num2); // Находит поле ввода числителя второй дроби для получения введённого пользователем значения
        num2.setBackground(null);
        TextInputEditText den1 = findViewById(R.id.den1); // Находит поле ввода знаменателя первой дроби для получения введённого пользователем значения
        den1.setBackground(null);
        TextInputEditText den2 = findViewById(R.id.den2); // Находит поле ввода знаменателя второй дроби для получения введённого пользователем значения
        den2.setBackground(null);


        int num1f;
        int num2f;
        int den1f;
        int den2f;

        try
        {
            num1f = Integer.parseInt(String.valueOf(num1.getText())); // пробуем преобразовать введенное пользователем число
        } catch (NumberFormatException e) // если невозможно преобразовать
        {
            num1.setBackgroundColor(errnonum); // меняем цвет поля на красный
            return;
        }

        try
        {
            num2f = Integer.parseInt(String.valueOf(num2.getText())); // пробуем преобразовать введенное пользователем число
        } catch (NumberFormatException e) // если невозможно преобразовать
        {
            num2.setBackgroundColor(errnonum); // меняем цвет поля на красный
            return;
        }

        try
        {
            den1f = Integer.parseInt(String.valueOf(den1.getText())); // пробуем преобразовать введенное пользователем число
        } catch (NumberFormatException e) // если невозможно преобразовать
        {
            den1.setBackgroundColor(errnonum); // меняем цвет поля на красный
            return;
        }
        try
        {
            den2f = Integer.parseInt(String.valueOf(den2.getText())); // пробуем преобразовать введенное пользователем число
        } catch (NumberFormatException e) // если невозможно преобразовать
        {
            den2.setBackgroundColor(errnonum); // меняем цвет поля на красный
            return;
        }
        if (den1f == 0) // если знаменатель первой дроби равен 0
        {
            den1.setBackgroundColor(errzero); // меняем цвет поля на розовый
            return;
        }
        if (den2f == 0) // если знаменатель второй дроби равен 0
        {
            den2.setBackgroundColor(errzero); // меняем цвет поля на розовый
            return;
        }

        frac1.setNum(num1f);
        frac1.setDen(den1f);
        frac2.setNum(num2f);
        frac2.setDen(den2f);

        try
        {
            ans = Frac.divis(frac1, frac2); // вычисление частного
        }
        catch (RuntimeException e) // если при делении брошена ошибка(делить на 0 нельзя)
        {
            num2.setBackgroundColor(errzero); // меняем цвет поля на розовый
            return;
        }
        TextInputEditText rez = findViewById(R.id.rez); // находит поле для вывода ответа
        rez.setText(ans.toString()); // вывод ответа
    }

    /**
     * Обработчик нажатия кнопки "Перевод в десятичную дробь" для перевода из обыкновенной дроби в десятичную
     * view View-объект кнопки, вызвавшей событие
     */
    public void onClickDec(View view)
    {
        TextInputEditText rez = findViewById(R.id.rez); // находит поле для взятия данных
        if (ans != null) // если не пустое
        {
            rez.setText(String.format(Float.toString(ans.dec()))); // вывод ответа
        }
    }
}