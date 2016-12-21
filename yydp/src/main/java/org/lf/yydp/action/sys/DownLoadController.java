package org.lf.yydp.action.sys;

import java.io.File;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.lf.yydp.service.sys.DownLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sys")
public class DownLoadController {
	Logger logger = Logger.getLogger(DownLoadController.class);
	@Autowired
	private DownLoadService downService;
	
	@RequestMapping("downLoad.do")
	@ResponseBody
	public String isDownLoadSuccess(HttpServletRequest request) throws MalformedURLException{
		String str = request.getSession().getServletContext().getRealPath("/")+"images"+File.separator;
		logger.info("--------------开始下载文件！-----------------");
		downService.downFilmFile("http://theater.mtime.com/China_Hubei_Province_Wuhan/");
		logger.info("--------------开始下载图片！-----------------");
		downService.downImg(str+"film", str+"filmInfo", str+"actor");
		logger.info("--------------全部下载完成！-----------------");
		return "success";
	}
}
