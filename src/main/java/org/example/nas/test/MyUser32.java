package org.example.nas.test;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

// 定义一个接口来映射User32.dll中的函数（这里直接使用JNA提供的User32接口也可以）
public interface MyUser32 extends StdCallLibrary {
    MyUser32 INSTANCE = (MyUser32) Native.load((System.getProperty("os.name").toLowerCase().contains("win") ? "user32" : "User32"), MyUser32.class, W32APIOptions.DEFAULT_OPTIONS);

    // 声明EnumWindows函数
    boolean EnumWindows(EnumWindowsProc lpEnumFunc, PointerByReference lParam);

    // 声明GetWindowText函数
    int GetWindowText(WinDef.HWND hWnd, byte[] lpString, int nMaxCount);

    // 声明GetWindowTextLength函数
    int GetWindowTextLength(WinDef.HWND hWnd);

    // 声明EnumWindows回调函数的接口
    interface EnumWindowsProc extends StdCallCallback {
        boolean callback(WinDef.HWND hwnd, PointerByReference lParam);
    }
}