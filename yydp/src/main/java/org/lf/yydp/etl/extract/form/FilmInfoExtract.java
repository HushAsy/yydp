package org.lf.yydp.etl.extract.form;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.lf.yydp.db.pojo.Actor_Film;
import org.lf.yydp.db.pojo.FilmInfo;

import com.sun.tools.example.debug.expr.ParseException;

public class FilmInfoExtract extends BaseExtract<FilmInfo>{
	
	private FilmInfo film_info;
	List<Actor_Film> actor_Films;
	public FilmInfoExtract(File parseFile) {
		super(parseFile);
	}

	@Override
	protected void extract() {
		try {
			parse();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private void parse() throws ParseException {
		int f_id = 0;
		String targetregex1 = ".*<a href=\".*/(\\d++)/.*/\" title=\"(.*?)(?=\").*<img src=\"(.*?)(?=\")(.*)<dl class=\"info_l\">(.*?)</a>.*剧情：</h4>.*?<p class=\"mt6 lh18\">(.*?)</p>";
		actor_Films = new ArrayList<Actor_Film>();
		film_info = new FilmInfo();
		Pattern p = Pattern.compile(targetregex1);
		BufferedReader br = null;
		String bath = null;
		try {
			br = new BufferedReader(new FileReader(this.parseFile));
			String line = null;
			while ((line = br.readLine()) != null) {
				bath += line;
			}
		} catch (Exception e) {
		}
		Matcher m = p.matcher(bath);
			if (m.find()) {
				f_id=Integer.parseInt(m.group(1));
				film_info.setfId(f_id);
				film_info.setLocalbigimage("temp\\bigimg\\"+f_id+".jpg");
				film_info.setfName(m.group(2));
				film_info.setBigimage(m.group(3));
				String time=m.group(4);
				String regexName=".*<span property=\"v:runtime\" content=\"(.*?)(?=\")";
				Pattern patternM=Pattern.compile(regexName);
				Matcher mName=patternM.matcher(time);
				if(mName.find()){
					time=mName.group(1);
					film_info.setfDuration(time);
				}
				
				String director=m.group(5);
				String regexD=".*<strong>导演：</strong>.*?rel=\"v:directedBy\">(.*)";
				Pattern patternD=Pattern.compile(regexD);
				Matcher mD=patternD.matcher(director);
				if(mD.find()){
					director=mD.group(1);
					film_info.setfDirector(director);
				}
				
				film_info.setfSummary(m.group(6));
			}
		

		// 匹配类型
		String type = "";
		String regex1 = "pan=\"M14_Movie_Overview_MovieTypeAndRuntimeAndVersion\">(.*?)<a href=\"http://movie.mtime.com/\\d++/details.html#releasedate\" property=\"v:initialReleaseDate\" content=\"(.*?)\">.*?</a>(.*?)</div>";
		Pattern p1 = Pattern.compile(regex1);
		Matcher m1 = p1.matcher(bath);
		if (m1.find()) {
			type = m1.group(1);
			film_info.setfOntime(m1.group(2));
			film_info.setfCountry(m1.group(3));
		}
		String[] types = type.split("</a>");
		String regex2 = ".*property=\"v:genre\">(.*)";
		Pattern p2 = Pattern.compile(regex2);
		String filmType=null;
		for (int i = 0; i < types.length; i++) {
			Matcher matcher = p2.matcher(types[i]);
			if (matcher.find()) {
				types[i] = matcher.group(1).trim();
				filmType+=types[i]+"/";
			}
		}
		
		film_info.setfType(filmType.replace("null", ""));
		// 匹配主演
		String regex3 = ".*主演：</h4>(.*?)pan=\"M14_Movie_Overview_Actor_More\">";
		Pattern p3 = Pattern.compile(regex3);
		Matcher m3 = p3.matcher(bath);
		String[] actors = new String[]{};
		if (m3.find()) {
			actors = m3.group(1).split("</dl>");
		}
		String regex5 = "href=\"?.*?\".*?\\btitle\\b?=\"?(.*?)\"?><\\bimg src=\"(.*?)(?=\").*?<p.*pan=\"M14_Movie_Overview_Actor_\\d\">(.*?)(?=</p>)";
		Pattern p4 = Pattern.compile(regex5);
		String fa="";
		Actor_Film actor_Film=null ;
		for (int i = 0; i < actors.length; i++) {
			Matcher mat = p4.matcher(actors[i]);
			if (mat.find()) {
				actor_Film=new Actor_Film();
				fa+=mat.group(1)+"/t";
				actor_Film.setfId(f_id);
				actor_Film.setPicture(mat.group(2));
				actor_Film.setActorname(mat.group(1));
				actor_Film.setLocalpathimg("temp\\actorimg\\"+mat.group(1)+".jpg");
				String role=mat.group(3);
				String regexName="<a .*?>(.*)</a>";
				Pattern patternM=Pattern.compile(regexName);
				Matcher mName=patternM.matcher(role);
				if(mName.find()){
					role=mName.group(1);
				}
				actor_Film.setRole(role.replace("饰&nbsp;", ""));
				actor_Films.add(actor_Film);
			}
		}
     film_info.setfActor(fa.replace("null", ""));
//     filmInfoMapper.insert(film_info);
//		for (int i = 0; i <actor_Films.size(); i++) {
//			actor_FilmMapper.insertSelective(actor_Films.get(i));
//		}
	}

	public FilmInfo getFilm_info() {
		return film_info;
	}

	public List<Actor_Film> getActor_Films() {
		return actor_Films;
	}
}
