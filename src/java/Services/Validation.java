/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Validation {

    public String error = "";

    public String checkLength(String input, int length) {
        if (input.isBlank()) {
            return "You must input here";
        }else if(input.length() > length) {
            error = "You must input shorter than 32 characterics";
            return error;
        }

        return input;
    }

    public String checkPhoneNumber(String phoneNumberInput) {
        if (phoneNumberInput.isEmpty()) {
            return phoneNumberInput;
        }
// Biểu thức chính quy cho số điện thoại
        String regex = "^\\+?\\d{1,3}?[-.\\s]?\\(?\\d{1,4}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumberInput);

        if (matcher.matches()) {
            return phoneNumberInput;
        } else {
            return "Số điện thoại không hợp lệ";
        }
    }

    public String checkGmail2(String emailInput) {
        // Các đuôi email Gmail hợp lệ
        if (emailInput.isEmpty()) {
            return "You must input here";
        }
        String[] gmailDomains = {"gmail.com", "gmail.co", "googlemail.com","yahoo.com"};
        // Tạo biểu thức chính quy từ các đuôi email
        String domainRegex = String.join("|", gmailDomains);
        String regex = "^[a-zA-Z0-9._%+-]+@(" + domainRegex + ")$";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(emailInput);

        if (matcher.matches()) {
            return emailInput;
        } else {
            return "Input email wrong";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Validation validation = new Validation();
        String gmail = sc.nextLine();
        String gmailNew = validation.checkPhoneNumber(gmail);
        System.out.println(gmailNew);
    }

}
