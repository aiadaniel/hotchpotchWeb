package com.platform.action;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.util.Random;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.platform.utils.SecurityCode;
import com.platform.utils.SecurityImage;

public class VerifyCodeAction extends ActionSupport {

	public static final String VERIFY_CODE = "verify_code";

	/**
	 * 
	 */
	private static final long serialVersionUID = -5346837859217548978L;

	private ByteArrayInputStream inputStream;
	private int width;
	private int height;
	private int fontSize;
	private int codeLength;

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public int getCodeLength() {
		return codeLength;
	}

	public void setCodeLength(int codeLength) {
		this.codeLength = codeLength;
	}

	public String execute() throws Exception {
		// width = 60;
		// height = 20;
		// fontSize = 18;
		// codeLength = 4;
		// BufferedImage bimage = new BufferedImage(width, height, 1);
		// Graphics g = bimage.getGraphics();
		// Random random = new Random();
		// g.setColor(getRandomColor(random, 200, 255));
		// g.fillRect(0, 0, width, height);
		// g.setFont(new Font("Times New Roman", 0, fontSize));
		// g.setColor(getRandomColor(random, 160, 200));
		// for (int i = 0; i < 155; i++) {
		// int x = random.nextInt(width);
		// int y = random.nextInt(height);
		// int xl = random.nextInt(12);
		// int yl = random.nextInt(12);
		// g.drawLine(x, y, x + xl, y + yl);
		// }
		//
		// StringBuffer str = new StringBuffer();
		// for (int i = 0; i < codeLength; i++) {
		// String randomStr = String.valueOf(random.nextInt(10));
		// str.append(randomStr);
		// g.setColor(new Color(20 + random.nextInt(110), 20 + random
		// .nextInt(110), 20 + random.nextInt(110)));
		// int x = (width / codeLength - 1) * i
		// + random.nextInt(width / (codeLength * 2));
		// int y = random.nextInt(height - fontSize) + fontSize;
		// g.drawString(randomStr, x, y);
		// }
		//
		// ActionContext.getContext().getSession()
		// .put(VERIFY_CODE, str.toString());//put the verify code to session
		// g.dispose();
		// ByteArrayOutputStream output = new ByteArrayOutputStream();
		// ImageOutputStream iout = ImageIO.createImageOutputStream(output);
		// ImageIO.write(bimage, "JPEG", iout);
		// iout.close();
		// output.close();
		// ByteArrayInputStream in = new
		// ByteArrayInputStream(output.toByteArray());
		// setInputStream(in);

		// 试试另一种方法
		// 如果开启Hard模式，可以不区分大小写
		// String securityCode =
		// SecurityCode.getSecurityCode(4,SecurityCodeLevel.Hard,false).toLowerCase();

		// 获取默认难度和长度的验证码
		String securityCode = SecurityCode.getSecurityCode();
		inputStream = SecurityImage.getImageAsInputStream(securityCode);
		
		ActionContext.getContext().getSession().put(VERIFY_CODE, securityCode);//put the verify code to session

		return SUCCESS;
	}

	@SuppressWarnings("unused")
	private Color getRandomColor(Random random, int fc, int bc) {
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

}
