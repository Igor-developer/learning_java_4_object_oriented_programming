package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        runTask1();
        runTask2();
    }

    //Задание 1.
    //Повторить мой успех с Транспортным средством и Машиной и Велосипедом
    //Добавить поле бензобака внутри Vehicle и переопределить метод заправки внутри наследников Vehicle.
    //Создать абстрактный метод для заправки. Машина заправляется на + n, велосипед не надо заправлять
    //Создать класс Самолет который будет по-своему реализовывать заправку и полет.
    //Например: заправляется на n*10
    //Добавить всем водителя из прошлого урока.
    //Точно так же расчитывать скорость(скорость * мастерство водителя).
    //Унаследовать водителя от класса Человек (у человека должно быть имя).
    //Дополнить класс Человек полем вес.
    //Добавить класс Грузовик в который можно сажать Пассажиров. Пассажиры унаследовать от Человека.
    //Грузовик – от Транспортного средства.
    //Посадить 1 пассажира и поставить формулу вычисления скорости как скорость-вес пассажира. Устроить гонки.
    private static void runTask1() {
        int distance = 640;

        Truck truck = new Truck(
                "Scania",
                85,
                810);
        truck.setDriver(new Driver("Михаил", 2.17));
        truck.setPassenger(new Passenger("Мария", 66.3));
        truck.fueling();
        truck.runVehicle(distance);
        System.out.println();

        Car car = new Car(
                "BMW",
                125,
                58);
        car.setDriver(new Driver("Дмитрий", 0.4));
        car.fueling();
        car.runVehicle(distance);
        System.out.println();

        Bicycle bicycle = new Bicycle(
                "Bergamont",
                23);
        bicycle.setDriver(new Driver("Александр", 1.8));
        bicycle.fueling();
        bicycle.runVehicle(distance);
        System.out.println();

        Airplane airplane = new Airplane(
                "Boeing 737",
                840,
                26020,
                20.5,
                25);
        airplane.setDriver(new Driver("Руслан", 0.63));
        airplane.fueling();
        airplane.runVehicle(distance);
        System.out.println();
    }

    //Задание 2.
    //День программиста отмечается в 255-й день года (при этом 1 января считается нулевым днем).
    //Требуется написать программу, которая определит дату (месяц и число григорианского календаря),
    //на которую приходится День программиста в заданном году.
    //В григорианском календаре високосным является:
    //год, номер которого делится нацело на 400
    //год, номер которого делится на 4, но не делится на 100
    //Входные данные
    //В единственной строке входного файла INPUT.TXT записано целое число от 1 до 9999 	включительно,
    //которое обозначает номер года нашей эры.
    //Выходные данные
    //В единственную строку выходного файла OUTPUT.TXT нужно вывести дату Дня программиста в формате DD/MM/YYYY,
    //где DD — число, MM — номер месяца (01 — 	январь, 02 — февраль, ..., 12 — декабрь),
    //YYYY — год в десятичной записи.
    private static void runTask2() throws IOException {
        FileReader reader = new FileReader("src/com/company/INPUT.TXT");
        Scanner sc = new Scanner(reader);
        int year = Integer.parseInt(sc.nextLine().trim());
        reader.close();

        //-вариант 1: - решение с помощью через класс java.time
        //и уже известную дату для високосного и невисокосного годов:
        //https://ru.wikipedia.org/wiki/%D0%94%D0%B5%D0%BD%D1%8C_%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%81%D1%82%D0%B0
        String result = "1" + (Year.of(year).isLeap() ? "2" : "3") + "/09/" + String.format("%04d", year);
        System.out.println(result + " - решено через wikipedia.org;");

        //-вариант 2: - решение через класс java.time
        LocalDate local_date = LocalDate.of(year, Month.JANUARY, 1).plusDays(255L);

        result = String.format("%02d", local_date.getDayOfMonth()) + "/"
                + String.format("%02d", local_date.getMonthValue()) + "/"
                + String.format("%04d", year);
        System.out.println(result + " - решено через класс java.time;");

        //-вариант 3: - решение через классы Calendar и GregorianCalendar
        GregorianCalendar calendar = new GregorianCalendar(year, Calendar.JANUARY, 1);
        calendar.add(Calendar.DAY_OF_MONTH, 255);

        result = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH)) + "/"
                + String.format("%02d", calendar.get(Calendar.MONTH) + 1) + "/"
                + String.format("%04d", year);
        System.out.println(result + " - решено через классы Calendar и GregorianCalendar;");

        //-вариант 4: - решение через массивы и циклы
        int[] months = new int[12];
        months[0] = 31;
        months[1] = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? 29 : 28;
        months[2] = 31;
        months[3] = 30;
        months[4] = 31;
        months[5] = 30;
        months[6] = 31;
        months[7] = 31;
        months[8] = 30;
        months[9] = 31;
        months[10] = 30;
        months[11] = 31;

        int month, day;
        for (month = 0, day = 256; month < 12 && day > months[month]; day -= months[month++]) ;

        result = String.format("%02d", day) + "/"
                + String.format("%02d", ++month) + "/"
                + String.format("%04d", year);
        System.out.println(result + " - решено через массивы и циклы.");

        FileWriter writer = new FileWriter("src/com/company/OUTPUT.TXT");
        writer.write(result);
        writer.close();
    }

}