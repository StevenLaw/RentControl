package RentDB;

import RentControl.Customer;
import RentControl.Employee;
import RentControl.Transaction;
import java.util.Date;
import java.util.List;

public class TransactionDB {

  public boolean addTransaction(Transaction transaction) {
  return false;
  }

  public boolean updateTransaction(Transaction transaction) {
  return false;
  }

  public List getTransaction(Employee employee) {
  return null;
  }

  public List getTransaction(Customer customer) {
  return null;
  }

  public List getTransaction(Date startDate, Date endDate) {
  return null;
  }

  public Transaction getTransaction(int TNo) {
  return null;
  }

}