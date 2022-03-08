package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Сообщение: " + this.message);
        System.out.println("Активна: " + this.active);
        System.out.println("Статус: " + this.status);
    }

    public static void main(String[] args) {
        Error error01 = new Error();
        error01.printInfo();
        Error error02 = new Error(true, 101, "Ошибка соединения");
        error02.printInfo();
        Error error03 = new Error(true, 201, "Ошибка передачи");
        error03.printInfo();
        Error error04 = new Error(false, 102, "Щшибка закрытия соединения");
        error04.printInfo();
    }
}
