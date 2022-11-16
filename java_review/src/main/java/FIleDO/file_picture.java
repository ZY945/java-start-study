package FIleDO;

import java.io.File;
import java.util.UUID;

/**
 * @author 伍六七
 * @date 2022/8/26 20:50
 */
public class file_picture {
    public static void main(String[] args) {
        rename("F:\\pic");
    }

    /**\
     * 统一修改图片命名
     * @param path
     */
    public static void rename(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        int i = 0;
        for(File file1:files){
            if(!file1.isDirectory()){
                file1.renameTo(new File(path+"\\"+i+".jpg"));
                i++;
            }
            System.out.println("执行成功");
        }
    }

    /**
     * 获得不重复的文件名-32位
     * @return
     */
    public static String getUUIDString(){
        String s = UUID.randomUUID().toString().replace("-","");
        return s;
    }
}
