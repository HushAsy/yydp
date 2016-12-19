package org.lf.yydp.etl.extract;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author Administrator
 */
public abstract class BaseExtractor {
	private static Logger logger = Logger.getLogger(BaseExtractor.class);
	private URL url;
	private static File tmpFile;
	static{
		String fileDir = null;
		InputStream inputStream = BaseExtractor.class.getClassLoader()
				.getResourceAsStream("File.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
			fileDir = p.getProperty("fileDir");
		} catch (IOException e1) {
			logger.error("配置文件读取出错", e1);
		}
		tmpFile = new File(fileDir);
	}
	
	protected File parseFile;
	public BaseExtractor(){
	}
	
	/**
	 * @param url
	 * 根据指定url下载文件
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public BaseExtractor(String url) throws IOException, InterruptedException{
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			logger.info(url+" error!");
		}
		parseFile = new File(tmpFile, new File(this.url.getFile()).getName());
		downLoad(this.url);
	}
	
	@SuppressWarnings("static-access")
	private File downLoad(URL url) throws IOException, InterruptedException{
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
	
	protected abstract void extract();
	
}
