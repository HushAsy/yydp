package org.lf.yydp.action;

import java.util.List;

import org.lf.yydp.db.pojo.FilmInfo;
import org.lf.yydp.service.film.FilmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("film")
public class FilmInfoController {
	@Autowired
	private FilmInfoService filmInfoService;
	
	@RequestMapping("infoList.do")
	@ResponseBody
	@Transactional(rollbackFor=Exception.class)
	public List<FilmInfo> getFilmInfoList(){
		return filmInfoService.getFilmInfoList();
	}
	
	@RequestMapping("filmInfo.do")
	public String getFilmInfo(){
		return "jsp/filmInfo";
	}
	
}
