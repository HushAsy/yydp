package org.lf.yydp.etl.imgDownLoad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.lf.yydp.Model.DownLoadModel;
import org.springframework.stereotype.Service;
@Service
public class ImgDownLoad {
	Logger logger = Logger.getLogger(ImgDownLoad.class);
	private List<DownLoadModel> listModel;
	private String tmpDir;
	public void downLoad() throws MalformedURLException{
		ExecutorService pool = Executors.newFixedThreadPool(20);
		logger.info(this.tmpDir+"---download  start!");
		for(DownLoadModel str : listModel){
			pool.submit(new MyThread(str, tmpDir));
		}
		pool.shutdown();
		while (true) {  
			if (pool.isTerminated()) {  
				logger.info(this.tmpDir+"---download  end!");
				break;  
			}  
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
		}
	}
	
	public ImgDownLoad() {
		super();
	}

	public void setListModel(List<DownLoadModel> listModel) {
		this.listModel = listModel;
	}

	public String getTmpDir() {
		return tmpDir;
	}

	public void setTmpDir(String tmpDir) {
		this.tmpDir = tmpDir;
	}

	public ImgDownLoad(List<DownLoadModel> strList, String tmpDir){
		this.listModel = strList;
		this.tmpDir = tmpDir;
	}
	
	public class MyThread extends Thread{
		private DownLoadModel url;
		private String tmpDir;
		
		public MyThread(DownLoadModel url, String tmpDir) throws MalformedURLException{
			this.url =  url;
			this.tmpDir = tmpDir;
		}
		
		@Override
		public void run() {
			dowmLoad();
		}
		
		@SuppressWarnings("static-access")
		public void dowmLoad(){
			HttpURLConnection conn = null;
			try {
				conn = (HttpURLConnection) new URL(url.getUrl()).openConnection();
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			conn.setReadTimeout(5000);
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
			
			
			File tempDir = new File(tmpDir);
			if(!tempDir.exists()){
				tempDir.mkdirs();
			}
			
			File file = new File(tempDir, this.url.getName()+".jpg");
			FileOutputStream fos = null;
			if (file.exists()) {
				logger.info(file.getAbsolutePath()+"---exist!");
			} else {
				try {
					fos = new FileOutputStream(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				byte[] buffer = new byte[1024];
				int length;
				try {
					while ((length = conn.getInputStream().read(buffer)) > 0) {
						fos.write(buffer, 0, length);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					fos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				logger.info(file.getAbsolutePath()+"---success!");
			}
		}
	}
	
}
