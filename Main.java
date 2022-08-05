public class Main{
    public static void main(String[] args) {
        Customer customer = new Customer("Bilal", 24.4);
        Customer anotheCustomer = new Customer("buju", 4.6);
        anotheCustomer = customer;
        anotheCustomer.setAmount(2.5);
        System.out.println("the cusName : " + customer.getName() + " balance : " + customer.getAmount());
    }

}