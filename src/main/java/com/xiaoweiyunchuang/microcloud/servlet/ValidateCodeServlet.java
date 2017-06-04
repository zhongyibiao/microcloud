package com.xiaoweiyunchuang.microcloud.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.xiaoweiyunchuang.microcloud.common.NetworkUtil;

@WebServlet(urlPatterns = "/validatecodeServlet")
public class ValidateCodeServlet extends HttpServlet {
	/**  
	*   
	*/
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int width = 60;
		int height = 32;
		// create the image
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		// set the background color
		g.setColor(new Color(0xDCDCDC));
		g.fillRect(0, 0, width, height);
		// draw the border
		g.setColor(Color.black);
		g.drawRect(0, 0, width - 1, height - 1);
		// create a random instance to generate the codes
		Random rdm = new Random();
		String hash1 = Integer.toHexString(rdm.nextInt());
		System.out.print(hash1);
		// make some confusion
		for (int i = 0; i < 50; i++) {
			int x = rdm.nextInt(width);
			int y = rdm.nextInt(height);
			g.drawOval(x, y, 0, 0);
		}
		// generate a random code
		String capstr = hash1.substring(0, 4);

		String username = req.getParameter("username");
		if(StringUtils.isEmpty(username)){

			String ip = null;
			try {
				ip = NetworkUtil.getIpAddr(req);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			if(StringUtils.isNotBlank(ip)){
				resp.setContentType("image/jpeg");
				stringRedisTemplate.opsForValue().set(ip, capstr);
			}else{
				capstr="点击";
				resp.setHeader("Content-type", "textml;charset=UTF-8");
				resp.setCharacterEncoding("UTF-8");
			}
		}else{
			// 输出图片
			resp.setContentType("image/jpeg");
			stringRedisTemplate.opsForValue().set(username, capstr);
		}

		g.setColor(new Color(0, 100, 0));
		g.setFont(new Font("宋体", Font.BOLD, 24));
		g.drawString(capstr, 8, 24);
		g.dispose();
		
		OutputStream strm = resp.getOutputStream();
		ImageIO.write(image, "jpeg", strm);
		strm.close();

	}
}
