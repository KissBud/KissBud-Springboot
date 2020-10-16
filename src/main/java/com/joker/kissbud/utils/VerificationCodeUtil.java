package com.joker.kissbud.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerificationCodeUtil {

    /**设置字符*/
    private static final char[] CHARS="1234567890QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
//    private static final char[] CHARS="1234567890".toCharArray();
    /**设置随机数*/
    private static Random RANDOM = new Random();

    /**
     * 获取4位随机数 on 2019/5/17 11:29
     *
     * @return String
     */
    public static String getRandomString(){
        StringBuilder buffer = new StringBuilder();
        //获取随机chars下标
        int index;
        for(int i=0;i<4;i++){
            //获取随机chars下标
            index = RANDOM.nextInt(CHARS.length);
            buffer.append(CHARS[index]);
        }
        return buffer.toString();
    }

    /**
     * 获取随机验证码 on 2020/4/8 12:07
     *
     * @param width 宽
     * @param height 高
     * @param verifyImg 验证码图片
     * @return String
     */
    public static String drawRandomText(int width, int height, BufferedImage verifyImg) {
        Graphics2D graphics = (Graphics2D)verifyImg.getGraphics();
        graphics.setColor(Color.WHITE);
        //设置画笔颜色-验证码背景色
        graphics.fillRect(0, 0, width, height);
        //填充背景
        graphics.setFont(new Font("微软雅黑", Font.BOLD, 40));
        //数字和字母的组合
        String baseNumLetter= "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
        StringBuffer buffer = new StringBuffer();
        int x = 10;
        //旋转原点的 x 坐标
        String ch = "";
        Random random = new Random();
        for(int i = 0;i < 4;i++){
            graphics.setColor(getRandomColor());
            //设置字体旋转角度
            int degree = random.nextInt() % 30;
            //角度小于30度
            int dot = random.nextInt(baseNumLetter.length());
            ch = baseNumLetter.charAt(dot) + "";
            buffer.append(ch);
            //正向旋转
            graphics.rotate(degree * Math.PI / 180, x, 45);
            graphics.drawString(ch, x, 45);
            //反向旋转
            graphics.rotate(-degree * Math.PI / 180, x, 45);
            x += 48;
        }
        //画干扰线
        for (int i = 0; i <6; i++) {
            // 设置随机颜色
            graphics.setColor(getRandomColor());
            // 随机画线
            graphics.drawLine(random.nextInt(width), random.nextInt(height),random.nextInt(width), random.nextInt(height));
        }
        //添加噪点
        for(int i=0;i<30;i++){
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            graphics.setColor(getRandomColor());
            graphics.fillRect(x1, y1, 2,2);
        }
        return buffer.toString();
    }

    /**
     * 随机取色 on 2020/4/8 12:07
     */
    private static Color getRandomColor() {
        Random ran = new Random();
        Color color = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
        return color;
    }

}