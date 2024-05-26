package algorithm.process;


public class Process implements Comparable{

	private int id; //编号
    private String name; // 进程名
    int good;          //优先级
    private time arrive; //到达就绪队列的时间
    private int zx; //执行时间
    private time start; //进入CPU运行开始的时间
    private time finish; //完成时间
    private int zz; //周转时间 = 完成时间 - 到达就绪时间
    private float zzxs; // 带权周转系数 = 周转时间/执行时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public time getArrive() {
        return arrive;
    }

    public void setArrive(time arrive) {
        this.arrive = arrive;
    }

    public int getZx() {
        return zx;
    }

    public void setZx(int zx) {
        this.zx = zx;
    }

    public time getStart() {
        return start;
    }

    public void setStart(time start) {
        this.start = start;
    }

    public time getFinish() {
        return finish;
    }

    public void setFinish(time finish) {
        this.finish = finish;
    }

    public int getZz() {
        return zz;
    }

    public void setZz(int zz) {
        this.zz = zz;
    }

    public float getZzxs() {
        return zzxs;
    }

    public void setZzxs(float zzxs) {
        this.zzxs = zzxs;
    }

    @Override
    public int compareTo(Object o) {
        if( o instanceof Process){
            Process t = (Process) o;
            return (this.arrive.getHour()*60+this.arrive.getMin())-(t.arrive.getHour()*60+t.arrive.getMin());
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", good=" + good +
                ", arrive=" + arrive +
                ", zx=" + zx +
                ", start=" + start +
                ", finish=" + finish +
                ", zz=" + zz +
                ", zzxs=" + zzxs +
                '}';
    }

}


