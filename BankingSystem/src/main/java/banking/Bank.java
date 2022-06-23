package banking;

import java.util.*;

/**
 * The Bank implementation.
 */
public class Bank implements BankInterface {
    private LinkedHashMap<Long, Account> accounts;

    public Bank() {
    }

    private Account getAccount(Long accountNumber) {
        //should it return null?
        return accounts.get(accountNumber);
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        Long accountNumber = new Random().nextLong();

        return -1L;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        // TODO: complete the method
        return -1L;
    }

    public double getBalance(Long accountNumber) {
        // TODO: complete the method
        return -1;
    }

    public void credit(Long accountNumber, double amount) {
        // TODO: complete the method
    }

    public boolean debit(Long accountNumber, double amount) {
        // TODO: complete the method
        return false;
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        // TODO: complete the method
        return false;
    }
    
    public void addAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        // TODO: complete the method
    }

    public boolean checkAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        // TODO: complete the method
        return false;
    }

    public Map<String, Double> getAverageBalanceReport() {
        // TODO: complete the method
        return new HashMap<>();
    }
}
