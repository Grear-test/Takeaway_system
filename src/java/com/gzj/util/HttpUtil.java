package com.gzj.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;



public class HttpUtil {

	public static String upload(HttpServletRequest request, String name, String upload_path)
			throws IOException, ServletException {
		// 文件名
		String fileName = "";

		Part part = request.getPart(name);
		if (part != null) {
			String realName = part.getSubmittedFileName();
			System.out.println(realName+"====realName");

			// ִ���ļ��ϴ�
			if (!realName.equals("")) {
				fileName = FileHelper.generateFileName(realName);
				File file = new File(upload_path, fileName);
				if (!file.exists()) {
					file.createNewFile();
				}
				InputStream in = part.getInputStream();
				FileOutputStream out = new FileOutputStream(file);
				byte[] cache = new byte[256];
				int length = 0;
				while ((length = in.read(cache)) != -1) {
					out.write(cache, 0, length);
				}
				out.flush();
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}

			}

		}

		return fileName;

	}

}
