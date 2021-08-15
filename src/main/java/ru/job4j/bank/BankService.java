package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User userFind = findByPassport(passport);
        if (userFind != null) {
        List<Account> accounts = users.get(userFind);
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
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * метод исчет счет по номеру паспорта и номеру счета
     * @param passport паспорт клиента счет которого ищем
     * @param requisite номер счета который мы ищем
     * @return банковский счет
     */
    public Account findByRequisite(String passport, String requisite) {
        User userFind = findByPassport(passport);
        if (userFind != null) {
            return users.get(userFind)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
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
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
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
