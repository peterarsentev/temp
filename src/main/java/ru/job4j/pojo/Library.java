package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book duma = new Book("Three Musketeers", 1057);
        Book vern = new Book("Mysterious Island", 931);
        Book conan = new Book("Mysterious world", 857);
        Book code = new Book("Clean code", 134);
        Book[] arrayBook = new Book[4];
        arrayBook[0] = duma;
        arrayBook[1] = vern;
        arrayBook[2] = conan;
        arrayBook[3] = code;
        for (int i = 0; i < arrayBook.length; i++) {
            System.out.println(arrayBook[i].getName() + " - " + arrayBook[i].getPages());
        }
        System.out.println("Replace book 0 and 3.");
        Book book = new Book();
        book = arrayBook[0];
        arrayBook[0] = arrayBook[3];
        arrayBook[3] = book;
        for (int i = 0; i < arrayBook.length; i++) {
            System.out.println(arrayBook[i].getName() + " - " + arrayBook[i].getPages());
        }
        System.out.println("Find book name \" Clean code\".");
        for (int i = 0; i < arrayBook.length; i++) {
            if ("Clean code".equals(arrayBook[i].getName())) {
                System.out.println(arrayBook[i].getName() + " - " + arrayBook[i].getPages());
            }
        }
    }

}
