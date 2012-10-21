package com.projects.syncimgviewer;

import java.io.*;

/***********************************************************************************
	
	The class gets first image file from folder
	
***********************************************************************************/
public class ImageFileGetter {

	private String folder;
	
	public ImageFileGetter(String _folder)
	{
		folder = _folder;
	}
	
	public File GetImage()
	{		
		File imgDirectory = new File(folder); 
		File[] files = imgDirectory.listFiles();
		File[] imgFiles = imgDirectory.listFiles(new ImageFileFilter());
		
		if (imgFiles == null || imgFiles.length == 0)
			return null;
		
		return imgFiles[0];
	}
}
