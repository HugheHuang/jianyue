/**  
* @title: GetArticleServlet.java
* @package action
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月17日 上午11:12:57
* @version V1.0  
*/ 
package action;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sun.tracing.dtrace.ArgsAttributes;

import model.Tags;
import util.JsonUtil;
import util.PythonUtil;

public class GetArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String json = req.getParameter("json");
	Tags tags = (Tags) JsonUtil.json2obj(json, Tags.class);
	StringBuilder args= new StringBuilder();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
	System.out.println(tags);
	List<String> tList = tags.getTag();
	int len = tList.size();
	for(int i = 0;i < len;i++) {
	    String string = tList.get(i);
	    if(i==0)
		args.append(string);
	    else
		args.append(" "+string);
	}
	System.out.println(args);
	String classPath = this.getClass().getResource("/").getPath();

	//System.out.println("类加载根路径:" + classPath);
	String classPathFormat=classPath.substring(1,classPath.length());
	String result=PythonUtil.execPy("python3",classPathFormat+"choosearticle.py",args.toString());
	System.out.println(result);
	resp.getWriter().write(result);
	//req.setAttribute( "result",result); 
        //req.getRequestDispatcher( "android.jsp").forward(req,resp); 
    }
    
}
