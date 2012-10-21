package com.projects.syncimgviewer;

import java.io.File;
import java.io.FilenameFilter;

public class ImageFileFilter implements FilenameFilter 
{
	public boolean accept(File dir, String name)
	{
		String extImage = "JPG";
		boolean result = name.toUpperCase().endsWith(extImage); 
		return result;
	}
}
