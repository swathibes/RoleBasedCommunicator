package com.rbc.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public static Properties pro;

	public ReadConfig() {
		File src = new File("./Configurations\\config.properties");

		try {
			FileInputStream Fis = new FileInputStream(src);
			pro = new Properties();
			try {
				pro.load(Fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;

	}

	public String getUserName() {
		String username = pro.getProperty("UserName");
		return username;

	}

	public String getPassword() {
		String password = pro.getProperty("Password");
		return password;

	}

	public String getEdgePath() {
		String edgepath = pro.getProperty("edgepath");
		return edgepath;

	}

}
