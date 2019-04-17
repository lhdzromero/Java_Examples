package pkg.desing.patterns.behavior.strategy;

public class CreditCardStrategy implements PaymentStrategy {
    private String name;
    private String carNumber;
    private String cvv;
    private String dateOfExpiry;

public CreditCardStrategy(String nm, String ccNum, String cvv, String expiryDate){
    this.name = nm;
    this.carNumber = ccNum;
    this.cvv = cvv;
    this.dateOfExpiry = expiryDate;
}

@Override
public void pay(int ammount){
    System.out.println(ammount + " paid with credit/debit card");
}
}
