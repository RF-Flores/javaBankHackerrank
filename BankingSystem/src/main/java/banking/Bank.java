package banking;

import java.util.*;

/**
 * The Bank implementation.
 */
public class Bank implements BankInterface {
    private final LinkedHashMap<Long, Account> accounts = new LinkedHashMap<>();

    public Bank() {
    }

    private Account getAccount(Long accountNumber) {
        //should it return null?
        return accounts.get(accountNumber);
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        long accountNumber = generateAccountNumber();
        CommercialAccount newCommAccount = new CommercialAccount(company,accountNumber,pin,startingDeposit);
        accounts.put(accountNumber,newCommAccount);
        return accountNumber;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        long accountNumber = generateAccountNumber();
        ConsumerAccount newConsumerAccount = new ConsumerAccount(person,accountNumber,pin,startingDeposit);
        accounts.put(accountNumber,newConsumerAccount);
        return accountNumber;
    }

    public double getBalance(Long accountNumber) {
        Account account = getAccount(accountNumber);
        return account == null ? 0 : account.getBalance(); //should it return 0?
    }

    public void credit(Long accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if(account == null) return;
        account.creditAccount(amount);
    }

    public boolean debit(Long accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if(account == null) return false;
        return account.debitAccount(amount);
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        Account account = getAccount(accountNumber);
        if(account == null) return false;
        return account.validatePin(pin);
    }
    
    public void addAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        Account account = getAccount(accountNumber);
        if(account == null && account.getClass() == CommercialAccount.class) return;
        CommercialAccount commercialAccount = (CommercialAccount) account;
        commercialAccount.addAuthorizedUser(authorizedPerson);
    }

    public boolean checkAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        Account account = getAccount(accountNumber);
        if(account == null && account.getClass() == CommercialAccount.class) return false;
        CommercialAccount commercialAccount = (CommercialAccount) account;
        return commercialAccount.isAuthorizedUser(authorizedPerson);
    }

    public Map<String, Double> getAverageBalanceReport() {
        return new HashMap<>();
    }

    private Long generateAccountNumber() {
        if(accounts.isEmpty()) return 1L;
        return accounts.entrySet().stream()
                .reduce((first,second) -> second)
                .orElse(null)
                .getValue()
                .getAccountNumber() +1;
    }
}
