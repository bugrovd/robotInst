package client;

import client.setting.Account;
import client.setting.ConfigReader;

import javax.xml.transform.TransformerException;

public class Main {

    public static void main(String[] args) throws TransformerException {
	   ConfigReader config = new ConfigReader();
        Account dima = new Account("123","14e13131","Dima","Dima Bugrov");
        config.addAccount(dima);
        /*ArrayList<Account> list = config.getAccounts();
        for (int i=0;i<list.size();i++) {
            System.out.println(list.get(i).getUserName());
        }*/
    }
}
