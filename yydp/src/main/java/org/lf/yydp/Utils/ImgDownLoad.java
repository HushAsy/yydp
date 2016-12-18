package org.lf.yydp.Utils;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

public class ImgDownLoad {
	private Logger logger = Logger.getLogger(ImgDownLoad.class);
	private List<String> listStr;
	private String tmpDir;
	public void downLoad() throws MalformedURLException{
		ExecutorService pool = Executors.newFixedThreadPool(20);
		for(String str : listStr){
			pool.submit(new MyThread(str, tmpDir));
		}
		pool.shutdown();
		
	}
	
	public ImgDownLoad(List<String> strList, String tmpDir){
		this.listStr = strList;
		this.tmpDir = tmpDir;
	}
	
	public class MyThread extends Thread{
		private String url;
		private String tmpDir;
		
		public MyThread(String url, String tmpDir) throws MalformedURLException{
			this.url =  url;
			this.tmpDir = tmpDir;
		}
		
		@Override
		public void run() {
			try {
				dowmLoad();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"正在执行..."); 
		}
		
		public void dowmLoad() throws IOException{
			DataInputStream dis = new DataInputStream(new URL(this.url).openStream());
			File tempDir = new File(tmpDir);
			if(!tempDir.exists()){
				tempDir.mkdirs();
			}
			
			File file = new File(tempDir,url.substring(url.lastIndexOf(".")-1, url.length()));
			System.out.println(file.getAbsolutePath());
			if (file.exists()) {
				logger.info(file.getAbsolutePath() + "文件已经存在！");
			} else {
				FileOutputStream fos = new FileOutputStream(file);
				byte[] buffer = new byte[1024];
				int length;
				while ((length = dis.read(buffer)) > 0) {
					fos.write(buffer, 0, length);
				}
				logger.info(file.getAbsolutePath() + "下载完成！");
				fos.flush();
				dis.close();
				fos.close();
			}
		}
	}
}
