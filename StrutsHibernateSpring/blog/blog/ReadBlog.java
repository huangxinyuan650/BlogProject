package blog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadBlog {
	/*
	 * 读取xml形式的文章
	 * 这里就是xml的解析器了
	 */
	private String blogContextPath;
	public String getBlogContextPath() {
		return blogContextPath;
	}
	public void setBlogContextPath(String blogContextPath) {
		this.blogContextPath = blogContextPath;
	}
	public ReadBlog(String blogContextPath){
		setBlogContextPath(blogContextPath);
	}
	
	public String readBlogDetail(){
		String blogContext = null;
		File file = new File(blogContextPath);
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		String temp = null;
		try {
			while((temp = br.readLine())!=null){
				blogContext += temp + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return blogContext;
	}
}
