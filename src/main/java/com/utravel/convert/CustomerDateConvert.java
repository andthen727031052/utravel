package com.utravel.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
//实现针对日期的全局转换
//必须实现Convert接口 第一个类型 表示要转换的类型 第二个表示转换成的类型
public class CustomerDateConvert implements Converter<String, Date>{
	//数组中设置支持的转换格式
	SimpleDateFormat[] sdfs = new SimpleDateFormat[] {
			new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("yyyyMMdd"),
			new SimpleDateFormat("yyyy/MM/dd")
			
	};
	@Override
	public Date convert(String source) {
		// TODO Auto-generated method stub
		if (source==null || source.equals("")) {
			return null;
		}
		for (SimpleDateFormat sdf : sdfs) {
			try {
				return sdf.parse(source);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				continue;
			}
		}
		return null;
	}

}
