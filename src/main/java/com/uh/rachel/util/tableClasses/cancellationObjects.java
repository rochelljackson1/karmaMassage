package com.uh.rachel.util.tableClasses;

public class cancellationObjects {

    customerTable customer;
    appointmentsTable table;

    public cancellationObjects(customerTable customer, appointmentsTable table) {
        this.customer = customer;
        this.table = table;
    }

    public customerTable getCustomer() {
        return customer;
    }

    public void setCustomer(customerTable customer) {
        this.customer = customer;
    }

    public appointmentsTable getTable() {
        return table;
    }

    public void setTable(appointmentsTable table) {
        this.table = table;
    }
}
