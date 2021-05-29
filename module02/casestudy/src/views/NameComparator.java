package views;

import models.Customer;

import java.util.Comparator;

public class NameComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.compareTo(o2);
    }

}
