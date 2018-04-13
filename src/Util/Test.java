package Util;

import Stack.DecodeString;

public class Test {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        DecodeString decodeString = new DecodeString();
        decodeString.decodeString(s);
    }
}
