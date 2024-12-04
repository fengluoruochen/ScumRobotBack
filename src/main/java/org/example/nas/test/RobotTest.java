package org.example.nas.test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RobotTest {

    public static void main(String[] args) throws AWTException, InterruptedException {

        Thread.sleep(3000);

        // 创建Robot对象
        Robot robot = new Robot();

        // 获取默认工具包
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // 获取屏幕分辨率
        Dimension screenSize = toolkit.getScreenSize();
        // 将鼠标移动到窗口中间
        robot.mouseMove((int) screenSize.getWidth() / 2, (int) screenSize.getHeight() / 2);

        // 点击鼠标左键
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_T);

        // 要输入的文本
        String text = "Hello, world!";

        // 遍历文本中的每个字符
        for (char c : text.toCharArray()) {
            // 转换为对应的虚拟键码（这部分需要处理大写字母、特殊字符等）
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);

            // 按下并释放按键
            if (keyCode != 0) { // 排除无法转换的字符
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);

                // 为了模拟人类输入速度，可以添加短暂的延迟
                robot.delay(50); // 50毫秒延迟
            }
        }
    }
/* // 获取窗口句柄
        HWND hwnd = User32.INSTANCE.FindWindow(null, "SCUM");

        if (hwnd == null) {
            System.out.println("窗口未找到");
        } else {
            System.out.println("窗口句柄: " + hwnd);
        }


       *//* // 获取窗口位置
        User32.RECT rect = new User32.RECT();
        User32.INSTANCE.GetWindowRect(hwnd, rect);

        // 创建Robot对象
        Robot robot = new Robot();

        // 将鼠标移动到窗口中间
        int centerX = rect.left + (rect.right - rect.left) / 2;
        int centerY = rect.top + (rect.bottom - rect.top) / 2;
        robot.mouseMove(centerX, centerY);

        // 点击鼠标左键
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot.keyPress(KeyEvent.VK_T);*/
}
