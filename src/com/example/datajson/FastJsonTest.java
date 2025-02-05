package com.example.datajson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

import com.alibaba.fastjson.JSONObject;
import com.example.basicinfo.Logs;
import com.google.gson.Gson;

import android.test.AndroidTestCase;
import android.util.Log;

public class FastJsonTest extends AndroidTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void fastBean() throws IOException{
		InputStream is = getContext().getAssets().open("json_xx");
		
		Reader reader = new InputStreamReader(is,"UTF-8");
		BufferedReader br = new BufferedReader(reader);
		String str = null;
		StringBuffer sb = new StringBuffer();
		while((str = br.readLine())!= null){
			sb.append(str);
		}
		
		JsonHead Root = JSONObject.parseObject(sb.toString(), JsonHead.class);
		PicSetBean info = Root.getInfo();

		ArrayList<PicUrl> picSet = info.getPicSet();
		
		for (PicUrl picUrl : picSet) {
			String picName = picUrl.getAlbumsName();
			Logs.e("picName--"+picName);
			ArrayList<PicUrlStr> picStr = picUrl.getPicUrlSet();
			for (Iterator iterator = picStr.iterator(); iterator.hasNext();) {
				PicUrlStr string = (PicUrlStr) iterator.next();
				String pic = string.getPicUrl();
				Logs.d("pic--"+pic);
			}
			
		}
	}
	
	public void parseGson(){
		String str = "{\"student\":{\"name\":\"小胡\",\"age\":12,\"id\":\"123\",\"sex\":\"男\"}}";
		Gson json = new Gson();
		JavaBean javaBean = json.fromJson(str, JavaBean.class);
		Student stu = javaBean.getStudent();
		Logs.d("student:"+stu.getName()+","+stu.getAge()+","+stu.getId()+","+stu.getSex());
	}
	
	public void getJsonByGson(){
		Gson json = new Gson();
		JavaBean javaBean = new JavaBean();
		
		Student student = new Student();
		student.setName("小明");
		student.setAge(10);
		student.setId("456");
		student.setSex("男");
		javaBean.setStudent(student);
		String str = json.toJson(javaBean);
		
		Logs.d("str---"+str);
		
	}
}
