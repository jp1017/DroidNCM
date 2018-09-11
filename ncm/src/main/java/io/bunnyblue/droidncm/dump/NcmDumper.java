package io.bunnyblue.droidncm.dump;

public class NcmDumper {
    static {
        System.loadLibrary("ncm");
    }

    @SuppressWarnings("JniMissingFunction")
    public static native String ncpDump(String ncmFilePath);
}
