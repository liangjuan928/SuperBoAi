package cn.boai.util;

import java.util.UUID;

public class UUIDHelp {
    public static String GetUUID(){
    	UUID uuid=UUID.randomUUID();
        return uuid.toString();
    }
}
