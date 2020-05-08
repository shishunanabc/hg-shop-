package com.shishunan.hgshop.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Configuration
@PropertySource("classpath:hgshop.properties")
public class FileUtils {
		//存放图片的路径
		static String rootPath;
		
		//windows存放图片的路径
		static String winRootPath;
		
		//linux存放图片的路径
		static String linuxRootPath;
		
		//当前的操作系统
		static String currentOs="";
		
		
		
		static {
			String os = System.getProperty("os.name").toLowerCase();  
			
			//linux 
			if(os.indexOf("linux")>=0 ) {
				currentOs="linux";
			}
			//windows 
			if(os.indexOf("windows")>=0 ) {
				currentOs="windows";
			}
		}
		
		public static String getRootPath() {
			return rootPath;
		}


		/**
		 * 保存文件的具体位置
		 * @param rootPath
		 */
		@Value("${win.pic.savepath}")
		public void setWinRootPath(String rootPath) {
			if(currentOs.equals("windows")) {
				winRootPath=rootPath;
				FileUtils.rootPath=rootPath;
				createPath();
			}
			
			
		}
		
		@Value("${linux.pic.savepath}")
		public void setLinuxRootPath(String rootPath) {
			if(currentOs.equals("linux")) {
				linuxRootPath=rootPath;
				FileUtils.rootPath=rootPath;
				createPath();
			}
		}
		
		/**
		 * 创建目录
		 */
		static private void createPath() {
			//不存在则创建该目录
				File file = new File(FileUtils.rootPath);
				if(!file.exists()) {
					file.mkdirs();
				}
		}


		/**
		 * 
		 * @param response
		 * @param file
		 * @throws FileNotFoundException 
		 */
		public static void downLoad(HttpServletResponse response, String filename) throws FileNotFoundException {
			 /* // 下载本地文件
		    String fileName = "Operator.doc".toString(); // 文件的默认保存名
	*/	    // 读到流中
		    InputStream inStream = new FileInputStream(rootPath+ "/"+ filename);// 文件的存放路径
		    // 设置输出的格式
		    response.reset();
		    response.setContentType("bin");
		    response.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
		   
		    // 循环取出流中的数据
		    byte[] b = new byte[1024];
		    int len;
		    try {
		      while ((len = inStream.read(b)) > 0)
		        response.getOutputStream().write(b, 0, len);
		      inStream.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		
		}
		
		
		/**
		 *  上传文件
		 * @param file
		 * @return
		 * @throws IllegalStateException
		 * @throws IOException
		 */
		public static String processFile(MultipartFile file) throws IllegalStateException, IOException {

			// 原来的文件名称
			System.out.println("file.isEmpty() :" + file.isEmpty()  );
			System.out.println("file.name :" + file.getOriginalFilename());
			
			if(file.isEmpty()||"".equals(file.getOriginalFilename()) || file.getOriginalFilename().lastIndexOf('.')<0 ) {
				return "";
			}
				
			String originName = file.getOriginalFilename();
			String suffixName = originName.substring(originName.lastIndexOf('.'));
			SimpleDateFormat sdf=  new SimpleDateFormat("yyyyMMdd");
			String path = rootPath + "/" + sdf.format(new Date());
			File pathFile = new File(path);
			if(!pathFile.exists()) {
				pathFile.mkdir();
			}
			String destFileName = 		path + "/" +  UUID.randomUUID().toString() + suffixName;
			File distFile = new File( destFileName);
			file.transferTo(distFile);//文件另存到这个目录下边
			return destFileName.substring(rootPath.length()+1);
			
			
		}
}
