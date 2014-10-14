package net.wesleynascimento.twpt.components;

import java.awt.Image;
import java.awt.Window;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URI;

public class Compatibility {
	public static void browse(URI uri) {
		try {
			Object o = Class.forName("java.awt.Desktop")
					.getMethod("getDesktop", new Class[0])
					.invoke(null, new Object[0]);
			o.getClass().getMethod("browse", new Class[] { URI.class })
					.invoke(o, new Object[] { uri });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void open(File file) {
		try {
			Object o = Class.forName("java.awt.Desktop")
					.getMethod("getDesktop", new Class[0])
					.invoke(null, new Object[0]);
			o.getClass().getMethod("open", new Class[] { File.class })
					.invoke(o, new Object[] { file });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setIconImage(Window window, Image image) {
		try {
			Class[] params = { Image.class };
			Method setIconImage = Window.class
					.getMethod("setIconImage", params);
			setIconImage.invoke(window, new Object[] { image });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean setExecutable(File file, boolean executable,
			boolean owner) {
		try {
			Class[] params = { Boolean.TYPE, Boolean.TYPE };
			Method setExecutable = File.class
					.getMethod("setExecutable", params);
			return ((Boolean) setExecutable.invoke(
					file,
					new Object[] { Boolean.valueOf(executable),
							Boolean.valueOf(owner) })).booleanValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}