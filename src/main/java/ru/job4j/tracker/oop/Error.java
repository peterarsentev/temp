package ru.job4j.tracker.oop;

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
        System.out.println("Ошибка активна: " + active);
        System.out.println("Номер ошибки: " + status);
        System.out.println("Сообщение об ошибке: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error errorTrue = new Error(true, 567, "Ошибка вывода.");
        Error errorFalse = new Error(false, 334, "Ошибка инициализации.");
        error.printInfo();
        errorTrue.printInfo();
        errorFalse.printInfo();
    }
}
