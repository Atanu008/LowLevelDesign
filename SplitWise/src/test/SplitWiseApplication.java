package test;

import com.splitwise.group.Group;
import com.splitwise.models.ExpenseType;
import com.splitwise.models.User;
import com.splitwise.models.split.EqualSplit;
import com.splitwise.models.split.ExactSplit;
import com.splitwise.models.split.PercentSplit;
import com.splitwise.models.split.Split;
import com.splitwise.service.SplitWiseService;
import com.splitwise.service.UserService;

import java.util.*;

public class SplitWiseApplication {

    public static void main(String[] args) {

        // Sample Users
        User user1 = new User(1, "user1","user1@gmail.com","67853989379");
        User user2 = new User(2, "user2","user2@gmail.com","67853989379");
        User user3 = new User(3, "user3","user3@gmail.com","67853989379");
        User user4 = new User(4, "user4","user4@gmail.com","67853989379");

        Group group = new Group();
        UserService userService = new UserService(group);
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);

        SplitWiseService splitwiseService = new SplitWiseService(group);
        //Expense - Equal Split
        String userName = "user1";
        double amountSpend = 60.0;
        int totalMembers = 3;
        List<Split> splits = new ArrayList<>();
        for(int i=0;i<totalMembers;i++){
            splits.add(new EqualSplit(userService.getUser("user"+(i+1))));
        }
        splitwiseService.addExpense("EqualExpense-GoaFlight",ExpenseType.EQUAL,amountSpend,userName,splits);
        System.out.println("EQUAL SPLIT -  USERS BALANCE SHEET");
        for(int i=1;i<=4;i++){
            System.out.println("-------"+"user"+i+"-------");
            splitwiseService.showBalance("user"+i);
        }
        System.out.println();
        System.out.println("-----All User Balance sheet -----");
        // Show all Balance
        splitwiseService.showBalances();
        System.out.println();

        //Expense - Exact Split

        userName = "user4";
        amountSpend = 0;
        splits = new ArrayList<>();
        double initialAmount =20.0;
        for(int i=1;i<=totalMembers;i++){
            double exactAmount = initialAmount*i;
            amountSpend+=exactAmount;
            splits.add(new ExactSplit(userService.getUser("user"+(i+1)),exactAmount));
        }
        splitwiseService.addExpense("ExactExpense-CabTicket",ExpenseType.EXACT,amountSpend,userName,splits);
        System.out.println("EXACT SPLIT -  USERS BALANCE SHEET");
        for(int i=1;i<=4;i++){
            System.out.println("-------"+"user"+i+"-------");
            splitwiseService.showBalance("user"+i);
        }
        System.out.println();
        System.out.println("-----All User Balance sheet -----");
        // Show all Balance
        splitwiseService.showBalances();
        System.out.println();
        //Expense - Percent Split
        userName = "user2";
        amountSpend = 500;
        splits = new ArrayList<>();
        splits.add(new PercentSplit(userService.getUser("user1"),10));
        splits.add(new PercentSplit(userService.getUser("user2"),25));
        splits.add(new PercentSplit(userService.getUser("user3"),45));
        splits.add(new PercentSplit(userService.getUser("user4"),20));
        splitwiseService.addExpense("PercentExpense-Dinner",ExpenseType.PERCENTAGE,amountSpend,userName,splits);
        //Show Individual Balance
        System.out.println();
        System.out.println("FINAL USERS BALANCE SHEET");
        for(int i=1;i<=4;i++){
            System.out.println("-------"+"user"+i+"-------");
            splitwiseService.showBalance("user"+i);
        }
        System.out.println();
        System.out.println("-----All User Balance sheet -----");
        // Show all Balance
        splitwiseService.showBalances();

    }

}
