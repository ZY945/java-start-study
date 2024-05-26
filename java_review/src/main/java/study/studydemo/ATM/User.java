package study.studydemo.ATM;

/**
 * @author 伍六七
 * @date 2022/9/12 16:03
 */
public class User {
    private String cardId;
    private String userName; // 用户名
    private String passWord; // 密码
    private double money; // 账户余额
    private double quotaMoney; // 每次取现额度
    private int status;// 权限0管理1普通用户

    public User(String cardId, String userName, String passWord) {
        this.cardId = cardId;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getQuotaMoney() {
        return quotaMoney;
    }

    public void setQuotaMoney(double quotaMoney) {
        this.quotaMoney = quotaMoney;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User() {
    }

    public User(String cardId, String userName, String passWord, double money, double quotaMoney, int status) {
        this.cardId = cardId;
        this.userName = userName;
        this.passWord = passWord;
        this.money = money;
        this.quotaMoney = quotaMoney;
        this.status = status;
    }
}
