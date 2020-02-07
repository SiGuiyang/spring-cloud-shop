package quick.pager.shop.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 验证码生成器
 *
 * @author siguiyang
 * @version 3.0
 */
public class VerifyCodeUtils {
    /**
     * 图片的宽度
     */
    private int width = 120;
    /**
     * 图片的高度
     */
    private int height = 40;
    /**
     * 验证码字符个数
     */
    private int codeCount = 4;
    /**
     * 验证码
     */
    private String code = null;
    /**
     * 验证码图片Buffer
     */
    private BufferedImage buffImg = null;

    private char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'M', 'N', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9'};
    /**
     * 生成随机数
     */
    private Random random = new Random();

    public VerifyCodeUtils() {
        this.createCode();
    }

    /**
     * @param width  图片宽
     * @param height 图片高
     */
    public VerifyCodeUtils(int width, int height) {
        this.width = width;
        this.height = height;
        this.createCode();
    }

    /**
     * @param width     图片宽
     * @param height    图片高
     * @param codeCount 字符个数
     */
    public VerifyCodeUtils(int width, int height, int codeCount) {
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        this.createCode();
    }

    public void createCode() {
        int codeX = 0;
        int fontHeight = 0;
        // 字体的高度
        fontHeight = height - 5;
        // 每个字符的宽度
        codeX = width / (codeCount + 3);

        // 图像buffer
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();

        // 将图像填充为白色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // 创建字体
        ImgFontByte imgFont = new ImgFontByte();
        Font font = imgFont.getFont(fontHeight);
        g.setFont(font);

        StringBuffer randomCode = new StringBuffer();
        // 随机产生验证码字符
        for (int i = 0; i < codeCount; i++) {
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            // 设置字体颜色
            g.setColor(getRandomColor());
            // 设置字体位置
            g.drawString(strRand, (i + 1) * codeX, getRandomNumber(height / 2) + 25);
            randomCode.append(strRand);
        }
        code = randomCode.toString();
    }

    /**
     * 获取随机颜色
     */
    private Color getRandomColor() {
        int r = getRandomNumber(255);
        int g = getRandomNumber(255);
        int b = getRandomNumber(255);
        return new Color(r, g, b);
    }

    /**
     * 获取随机数
     */
    private int getRandomNumber(int number) {
        return random.nextInt(number);
    }

    public void write(String path) throws IOException {
        OutputStream out = new FileOutputStream(path);
        this.write(out);
        out.flush();
        out.close();
    }

    public void write(OutputStream sos) throws IOException {
        ImageIO.write(buffImg, "png", sos);
    }

    public BufferedImage getBuffImg() {
        return buffImg;
    }

    public String getCode() {
        return code;
    }

    /**
     * 字体样式类
     */
    static class ImgFontByte {

        public Font getFont(int fontHeight) {

            return new Font("Arial", Font.PLAIN, fontHeight);
        }

        private byte[] hex2byte(String str) {
            if (str == null || str.isEmpty()) {
                return null;
            }
            str = str.trim();
            int len = str.length();
            byte[] b = new byte[len / 2];
            try {
                for (int i = 0; i < str.length(); i += 2) {
                    b[i / 2] = (byte) Integer.decode("0x" + str.substring(i, i + 2)).intValue();
                }
                return b;
            } catch (Exception e) {
                return null;
            }
        }

    }
}
