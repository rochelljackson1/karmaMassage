package com.uh.rachel.util.reportClasses;
import com.uh.rachel.util.tableClasses.Address;
import com.uh.rachel.util.tableClasses.customerTable;

public class validEmail {
    customerTable customerPackages;
    Address AddressPackage;


    public validEmail(customerTable customerPackages, Address AddressPackage) {
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