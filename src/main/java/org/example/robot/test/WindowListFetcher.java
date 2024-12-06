package org.example.robot.test;

import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.ptr.PointerByReference;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class WindowListFetcher {
    public static void main(String[] args) {
        final List<WinDef.HWND> windowHandles = new ArrayList<>();

        MyUser32.EnumWindowsProc enumProc = new MyUser32.EnumWindowsProc() {
            @Override
            public boolean callback(WinDef.HWND hwnd, PointerByReference lParam) {
                windowHandles.add(hwnd);
                return true; // 继续枚举
            }
        };

        PointerByReference lParam = new PointerByReference();
        MyUser32.INSTANCE.EnumWindows(enumProc, lParam);

        // 打印所有窗口句柄（以十六进制字符串形式）
        for (WinDef.HWND hwnd : windowHandles) {
            System.out.println("Window handle: " + hwnd.toString());
            // 注意：hwnd.toString() 通常返回类似 "Pointer[0xXXXXXXXX]" 的字符串，其中 XXXXXXXX 是句柄的十六进制值
            // 如果您只需要十六进制值部分，可以使用正则表达式或字符串操作来提取它
            // 获取窗口标题长度
            int length = MyUser32.INSTANCE.GetWindowTextLength(hwnd);

            // 分配一个字节数组来存储窗口标题
            byte[] buffer = new byte[length + 1]; // +1 是为了存储空终止符

            // 获取窗口标题
            MyUser32.INSTANCE.GetWindowText(hwnd, buffer, buffer.length);

            // 将字节数组转换为字符串（注意：这里使用了平台默认的字符集，可能需要根据实际情况调整）
            String title = new String(buffer, StandardCharsets.US_ASCII).trim().replace("\0", "");

            System.out.println(title);
        }
    }
}
