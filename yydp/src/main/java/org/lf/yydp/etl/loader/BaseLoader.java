package org.lf.yydp.etl.loader;

import org.lf.yydp.etl.extract.BaseExtractor;

public abstract class BaseLoader {
	public abstract void load(String url);
	public abstract void downImg();
}
