package DesignPattern.Adapter;

/**
 * @author dongfeng
 * @description 适配器--对某一功能进行封装
 * @date 2023-10-16 14:24
 */
public class AdapterPattern {
    public static void main(String[] args) {
        Speaker speaker = new Speaker("小明", "早上好");
        System.out.println(speaker.Speak());
        System.out.println("适配器");
        AdapterTranslator adapterTranslator = new AdapterTranslator(speaker);
        adapterTranslator.Translator();
    }
}
class Speaker{
    private String name;
    private String msg;
    Speaker(String name,String msg){
        this.name=name;
        this.msg=msg;
    }
    public String Speak(){
        return name+":"+msg;
    }
}

interface Translator{
    String Translator();
}

class AdapterTranslator implements Translator{

    private Speaker speaker;
    AdapterTranslator(Speaker speaker){
        this.speaker=speaker;
    }

    @Override
    public String Translator() {
        String speak = speaker.Speak();
        //翻译记录
        System.out.println(speak+"---正在翻译成英文....");
        return speak;
    }
}