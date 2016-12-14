package org.lf.yydp.load;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class FilmLoader extends BaseLoad{
	public FilmLoader(){
		
	}

	public FilmLoader(String url) throws IOException, InterruptedException {
		super(url);
	}

	@Override
	public void extract() {
		
	}
	
}
