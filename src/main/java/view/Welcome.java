package view;

import Service.GenerateOTP;
import Service.SendOTP;
import Service.UserService;
import dao.userDAO;
import model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class Welcome {
    public void WelcomeScreen() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to File Hider Home Page");
        System.out.println("$ELECT \n1 -> {**Login**}\n2 -> {**Signup**} \n3 -> {**Exit**}");
        int choice = 0;
        try {
            choice = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (choice) {
            case 1 -> login();
            case 2 -> signUp();
            case 3 -> System.exit(0);
        }


    }

    private void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the email ");
        String email = sc.nextLine();
        try {
            if (userDAO.isExists(email)) {
                String genOTP = GenerateOTP.getOTP();
                SendOTP.sendOTP(email, genOTP);
                System.out.println("Enter the OTP");
                String user_otp = sc.nextLine();
                if (user_otp.equals(genOTP)) {
                new Userview(email).home();
                } else {
                    System.out.println("WRONG OTP");
                }
            } else {
                System.out.println("USER DOESN'T EXISTS");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void signUp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter the email");
        String email = sc.nextLine();
        String genOTP = GenerateOTP.getOTP();
        SendOTP.sendOTP(email, genOTP);
        System.out.println("Enter the OTP");
        String user_otp = sc.nextLine();
        if (user_otp.equals(genOTP)) {
            User user = new User(name, email);
            int response = UserService.saveUser(user);
            switch (response) {
                case 0 -> System.out.println("User Registered");
                case 1 -> System.out.println("User already exists");
            }
        } else {
            System.out.println("WRONG OTP");
        }
    }
}
