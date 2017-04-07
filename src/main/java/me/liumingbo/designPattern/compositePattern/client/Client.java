package me.liumingbo.designPattern.compositePattern.client;

import me.liumingbo.designPattern.compositePattern.organization.Company;
import me.liumingbo.designPattern.compositePattern.organization.Department;
import me.liumingbo.designPattern.compositePattern.organization.Organization;

/**
 * Created by bjliumingbo on 2017/4/7.
 */
public class Client {
    public static void main(String[] args) {
        Organization shCompany = new Company("shCompany");

        Organization shHR = new Department("shHR");
        shCompany.addOrg(shHR);

        Organization shAdmin = new Department("shAdmin");
        shCompany.addOrg(shAdmin);

        Organization shFinance = new Department("shFinance");
        shCompany.addOrg(shFinance);

        Organization bjCompany = new Company("bjCompany");

        Organization bjHR = new Department("bjHR");
        bjCompany.addOrg(bjHR);

        Organization bjAdmin = new Department("bjAdmin");
        bjCompany.addOrg(bjAdmin);

        Organization bjFinance = new Department("bjFinance");
        bjCompany.addOrg(bjFinance);

        Organization company = new Company("company");
        Organization hr = new Department("hr");
        company.addOrg(hr);
        Organization admin = new Department("admin");
        company.addOrg(admin);
        Organization finance = new Department("finance");
        company.addOrg(finance);

        company.addOrg(shCompany);
        company.addOrg(bjCompany);

        company.inform("Cheers");
    }
}
