package org.lf.yydp.load;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

/**
 * 
 * @author Administrator
 *
 */
public abstract class BaseLoad {
	private URL url;
	private static File tmpFile = new File("temp");
	protected File parseFile;
	private Logger logger = Logger.getLogger(BaseLoad.class);
	
	public BaseLoad(){
		
	}
	
	public BaseLoad(String url, String fileName) throws IOException, InterruptedException{
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			logger.info(url+" error!");
		}
		
		parseFile = new File(getPathName(tmpFile)+File.separator+fileName);
		if(parseFile.exists()){
			logger.info(parseFile.getAbsoluteFile()+" is extist!");
		}else{
			downLoad(this.url, fileName);
		}
	}
	
	@SuppressWarnings("static-access")
	private File downLoad(URL url, String fileName) throws IOException, InterruptedException{
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 沉睡500ms后开始下载
		try {
			Thread.currentThread().sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 设置超时间为3秒
		 conn.setConnectTimeout(60 * 1000);
		// 防止屏蔽程序抓取而返回403错误
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		
		InputStream ins = conn.getInputStream();
		byte[] data = readInputStream(ins);
		
		if(!tmpFile.exists()){
			tmpFile.mkdirs();
		}
		
		parseFile = new File(getPathName(tmpFile)+File.separator+fileName);
		FileOutputStream fos = new FileOutputStream(parseFile);
		fos.write(data);
		logger.info("File downLoad success: "+parseFile.getAbsolutePath());
		
		/**
		 * 关闭输入、输出流
		 */
		fos.close();
		ins.close();
		
		return parseFile;
	}
	
	/**
	 * 从输入流中获取字节数组
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	private byte[] readInputStream(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}
	
	/**
	 * 获得当前文件夹的名称
	 * @param file
	 * @return
	 */
	private String getPathName(File file){
		return file.getName();
	}
	
	public File getParseFile() {
		return parseFile;
	}
	
	public void setParseFile(File parseFile) {
		this.parseFile = parseFile;
	}
	
	public abstract void extract();
	
	
}
