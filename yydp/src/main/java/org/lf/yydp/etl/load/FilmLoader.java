package org.lf.yydp.etl.load;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class FilmLoader extends BaseLoad{
	public FilmLoader(){
		
	}

	public FilmLoader(String url, String fileName) throws IOException, InterruptedException {
		super(url, fileName);
	}

	@Override
	public void extract() {
		
	}
	
}
