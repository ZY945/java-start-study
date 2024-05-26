package study.studydemo.ATM;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 伍六七
 * @date 2022/9/12 16:03
 */
public class ATMSystem {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("1","admin","admin",1,1,0));
        login(users);
    }
    private static void showATM(){
        System.out.println("---------ATM系统--------");
        System.out.println("用户登录");
    }
    private static void showATMByAdmin(){
        System.out.println("---------ATM系统--------");
        System.out.println("0.退出系统");
        System.out.println("1.用户开户");
        System.out.println("2.用户注销");
        System.out.println("3.查看所有用户");

    }
    private static void showATMByUser(){
        System.out.println("---------ATM系统--------");
        System.out.println("0.退出系统");
        System.out.println("1.用户取存金额");
    }
    private static void login(ArrayList<User> users){
        showATM();
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        boolean st = false;
        System.out.println("输入用户名");
        String username = scanner.next();
        System.out.println("输入密码");
        String password = scanner.next();
        for(User u : users){
            if(u.getUserName().equals(username)&&u.getPassWord().equals(password)){
                st = true;
                user=u;
            }
        }
        if(user.getStatus()==0){
            while(st){
                showATMByAdmin();
                int i = scanner.nextInt();
                switch(i){
                    case 0:
                        st = false;
                    case 1:
                        System.out.println("新增");
                        insertUser(users);
                        break;
                    case 2:
                        System.out.println("删除");
                        deleteUser(users);
                        break;
                    case 3:
                        System.out.println("获取");
                        getUser(users);
                        break;
                    default:
                        System.out.println("重新输入");
                }
            }
        }else if(user.getStatus()==1){
            while(st){
                showATMByUser();
                int i = scanner.nextInt();
                switch(i){
                    case 0:
                        st = false;
                        break;
                    case 1:
                        updateUser(users);
                        break;
                }
                getUser(users);
            }
        }
    }
    private static void insertUser(ArrayList<User> users){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入卡号");
        String id = scanner.next();
        System.out.println("输入用户名");
        String username = scanner.next();
        System.out.println("输入密码");
        String password = scanner.next();
        User user = new User(id, username, password, 0, 0, 1);
        users.add(user);
        System.out.println("添加成功");
    }
    private static void deleteUser(ArrayList<User> users){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入卡号");
        String id = scanner.next();
        System.out.println("输入用户名");
        String username = scanner.next();
        System.out.println("输入密码");
        String password = scanner.next();
        for (User u : users){
            if(u.getCardId().equals(id)&&u.getUserName().equals(username)&&u.getPassWord().equals(password)){
                users.remove(u);
                System.out.println("注销成功成功");
            }
        }
    }
    private static void updateUser(ArrayList<User> users){}
    private static void getUser(ArrayList<User> users){
        for (User u : users){
            System.out.println(u.getCardId()+"  " + u.getUserName() + "  "+ u.getMoney()+"  "+ u.getQuotaMoney()+"  ");
        }
    }
}
