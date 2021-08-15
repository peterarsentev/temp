package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковского сервиса
 * по добавлению, поиску и переводу
 * @author MAKSIM
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение клиентов банка осуществляется в коллекции типа HashMap
     * где в качестве ключа используется клиент (User) а в качестве значения
     * коллекция ArrayList с парами - номер счет и баланс
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод позволяет добавить клиента в систему
     * @param user новый клиент которого необходимо добавить в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * метод повзоляет добавить к существующему клиенту
     * банковский счет
     * @param passport номер паспорта клиента которому нужно добавить счет
     * @param account банковский счет который нужно добавить клиенту
     */
    public void addAccount(String passport, Account account) {
        Optional<User> userFind = findByPassport(passport);
        if (userFind.isPresent()) {
        List<Account> accounts = users.get(userFind.get());
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
        }
    }

    /**
     * метод ищет клиента по номеру паспорта
     * @param passport номер паспорта искомого клиента
     * @return найденного клиента
     */
    public Optional<User> findByPassport(String passport) {
        Optional<User> userOptional = users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
        return userOptional;
    }

    /**
     * метод исчет счет по номеру паспорта и номеру счета
     * @param passport паспорт клиента счет которого ищем
     * @param requisite номер счета который мы ищем
     * @return банковский счет
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> userFind = findByPassport(passport);
        return userFind.flatMap(user -> users.get(user)
                .stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * метод переводит деньги с одного счета на другой
     * @param srcPassport номер паспорта клиента у коого переводят
     * @param srcRequisite номер счета с которого переводят
     * @param destPassport номер паспорта клиента кому переводят
     * @param destRequisite номер счета на который переводят
     * @param amount сумма перевода
     * @return если перевод совершен true если перевод не удался то false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAcc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc.isPresent() && destAcc.isPresent() && srcAcc.get().getBalance() >= amount) {
            srcAcc.get().setBalance(srcAcc.get().getBalance() - amount);
            destAcc.get().setBalance(destAcc.get().getBalance() + amount);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new Account("3fdsbb9", 140));
        int index = accounts.indexOf(new Account(requisite, -1));
        Account find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());
    }
}
