package algorithm.process;
public class time {
    private int hour;
    private int min;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void initTime(String t){
        this.hour = Integer.parseInt(t.split(":")[0]);
        this.min = Integer.parseInt(t.split(":")[1]);
    }

    public static int sub(String s,String f){
        return Integer.parseInt(f.split(":")[0])*60+Integer.parseInt(f.split(":")[1])
                -Integer.parseInt(s.split(":")[0])*60-Integer.parseInt(s.split(":")[1]);
    }

    @Override
    public String toString() {
        if(min < 10){
            return hour+":0"+min;
        }else{
            return hour+":"+min;
        }
    }
}

