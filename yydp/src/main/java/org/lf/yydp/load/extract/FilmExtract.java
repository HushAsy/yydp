package org.lf.yydp.load.extract;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.lf.yydp.db.pojo.Film;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class FilmExtract {
	private Logger logger = Logger.getLogger(FilmExtract.class);
	private List<Film> listFilm = new ArrayList<Film>();
	private Map<String, String> imgMap =  new HashMap<String, String>();
	private static StringBuilder sb = new StringBuilder();
	private File parseFile = null;
	public FilmExtract(File file) {
		this.parseFile = file;
		imgHref();
		matchFile();
	}
	
	/**
	 * 匹配图片url
	 * @param title
	 * @return
	 */
	private void imgHref(){
		BufferedReader br = null;
		String str = null;
		String pattern1 = "img\\ssrc=.*?\"?(\\bhttp\\b.*?)\".*?alt.*?\"(.*?)\"";
		Pattern p = Pattern.compile(pattern1);
		try {
			br = new BufferedReader(new FileReader(this.parseFile));
			try {
				while((str=br.readLine()) != null){
					Matcher mat = p.matcher(str);
					if(mat.find()){
						imgMap.put(mat.group(2).contains("/")?mat.group(2).split("/")[0].trim():mat.group(2).trim(), mat.group(1));
					}
				}
			} catch (IOException e) {
			}
		} catch (FileNotFoundException e) {
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
			}
		}
	}
	
	public void parse(String str){
		 JSONArray jsonArray = JSONArray.parseArray(str);
		 Film film = null;
		 JSONObject object = null;
		 for(int i=0; i<jsonArray.size(); i++){
			 film = new Film();
			 object = jsonArray.getJSONObject(i);
			 film.setId(object.getInteger("Id"));
			 film.setHref(object.getString("Url"));
			 film.setImg(imgMap.get(object.getString("Title").trim()));
			 film.setStatus("1");
			 listFilm.add(film);
		 }
	}
	
	/**
	 * 匹配film
	 */
	public void matchFile(){
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(parseFile)));
			try {
				String str = null;
				while( (str = br.readLine()) != null){
					sb.append(str);
				}
				String pattern = "<script\\s\\btype\\b=\"\\btext\\b/javascript\">.*?\\bhotplaySvList\\b\\s*?=\\s*?(.*?);?<?/script>";
				Pattern pat = Pattern.compile(pattern);
				Matcher ms = pat.matcher(sb);
				if(ms.find()){
					parse(ms.group(1));
				}
				
			} catch (IOException e) {
				logger.error(parseFile.getAbsolutePath() + " read error!");
			}
		} catch (FileNotFoundException e) {
			logger.error(parseFile.getAbsolutePath() + " extract error!");
		}
	}
	
	
	
	public List<Film> getListFilm() {
		return listFilm;
	}
}
