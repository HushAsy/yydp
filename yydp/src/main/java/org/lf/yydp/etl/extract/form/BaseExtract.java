package org.lf.yydp.etl.extract.form;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseExtract<T> {
	protected List<T> listModel = new ArrayList<T>();
	protected File parseFile;
	public BaseExtract(File parseFile) {
		this.parseFile = parseFile;
		extract();
	}
	
	public  List<T> getListModel() {
		return listModel;
	}
	
	protected abstract void extract();

}
