package Options;

class BalanceInquiry extends Withdraw{

    public void BalanceInquiry_Operation() {
        System.out.println("Your current balance is: ₹" + getBalance());
    }
}

