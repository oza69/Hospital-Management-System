/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This class presents initial options to the user
 */
package hms.presentation;

import hms.presentation.options.Option1;
import hms.presentation.options.Option10;
import hms.presentation.options.Option2;
import hms.presentation.options.Option3;
import hms.presentation.options.Option4;
import hms.presentation.options.Option5;
import hms.presentation.options.Option6;
import hms.presentation.options.Option7;
import hms.presentation.options.Option8;
import hms.presentation.options.Option9;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Presenter {

  public Presenter(Connection connection) {
    boolean running = true;
    int num = 0;
    presentAll();
    while (running) {
      try {
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        if (num > 0 && num <= 10) {
          switch (num) {
            case 1:
              new Option1(scanner, connection);
              break;
            case 2:
              new Option2(scanner, connection);
              break;
            case 3:
              new Option3(scanner, connection);
              break;
            case 4:
              new Option4(scanner, connection);
              break;
            case 5:
              new Option5(scanner, connection);
              break;
            case 6:
              new Option6(scanner, connection);
              break;
            case 7:
              new Option7(scanner, connection);
              break;
            case 8:
              new Option8(scanner, connection);
              break;
            case 9:
              new Option9(scanner, connection);
              break;
            case 10:
              new Option10(scanner, connection);
              break;
            default:
              validInputNotice();
          }
        } else if (num == 0) {
          running = false;
        } else {
          System.out.println("Please select a valid number.");
        }
        presentAll();
      } catch (InputMismatchException | SQLException e) {
        System.out.println("Please select a valid number.");
        presentAll();
      }
    }
    System.out.println("Thank you");
  }

  private void presentAll() {
    System.out.println("        Hello Admin, welcome       ");
    System.out.println("                Menu               ");
    System.out.println("-----------------------------------");
    System.out.println("1. Doctor");
    System.out.println("2. Patient");
    System.out.println("3. Disease");
    System.out.println("4. Payment");
    System.out.println("5. Package and Coupons");
    System.out.println("6. Insurance");
    System.out.println("7. Cases");
    System.out.println("8. Payroll");
    System.out.println("9. Revenue");
    System.out.println("10. HM-Analysis");
    System.out.println("0. Exit");
    System.out.println("-----------------------------------");
    System.out.println("Please choose an option (enter no.):");
  }

  private void validInputNotice() {
    System.out.println("Please select from 0 to 10");
  }
}