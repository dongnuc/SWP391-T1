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
        if (input.length() > length) {
            error = "You must input shorter than 32 characterics";
            return error;
        }
        return input;
    }

    public String checkEmail(String emailInput) {
        Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");
        Matcher m = p.matcher("foobar@gmail.com");
        if (m.find()) {
            return emailInput;
        }
        error = "Input email wrong";
        return error;
    }
    
     public String checkGmail2(String emailInput) {
        // Các đuôi email Gmail hợp lệ
        String[] gmailDomains = {"gmail.com", "gmail.co", "googlemail.com"};
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
        String gmailNew = validation.checkGmail2(gmail);
        System.out.println(gmailNew);
    }

}
