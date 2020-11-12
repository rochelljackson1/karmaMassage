package com.uh.rachel.util.reportClasses;
import com.uh.rachel.util.tableClasses.Address;
import com.uh.rachel.util.tableClasses.customerTable;

public class reportAddress {
    customerTable customerPackages;
    Address AddressPackage;


    public reportAddress(customerTable customerPackages, Address AddressPackage) {
        this.customerPackages = customerPackages;
        this.AddressPackage = AddressPackage;

    }



    public customerTable getCustomerPackages() {
        return customerPackages;
    }

    public void setCustomerPackages(customerTable customerPackages) {
        this.customerPackages = customerPackages;
    }

    public Address getAddressPackage() {
        return AddressPackage;
    }

    public void setAddressPackage(Address AddressPackage) {
        this.AddressPackage = AddressPackage;
    }

}