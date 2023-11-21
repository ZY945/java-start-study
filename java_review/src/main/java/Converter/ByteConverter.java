package Converter;

/**
 * @author 张洋
 * @description TODO
 * @date 2023-10-16 15:41
 */
public class ByteConverter {

    public static String byteToHexString(byte[] bytes){
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hexString = Integer.toHexString(bytes[i]);
            if(hexString.length()>3){
                buffer.append(hexString.substring(6));
            }else {
                if(hexString.length()<2){
                    buffer.append("0").append(hexString);
                }else{
                    buffer.append(hexString);
                }
            }
        }
        return buffer.toString();
    }
}
