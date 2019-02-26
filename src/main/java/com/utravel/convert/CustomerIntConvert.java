package com.utravel.convert;

import org.springframework.core.convert.converter.Converter;

public class CustomerIntConvert implements Converter<String, Integer>{

	@Override
	public Integer convert(String source) {
		// TODO Auto-generated method stub
		if (source == null || source.equals("")) {
			return 0;
		}
		
		try {
			return Integer.parseInt(source);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return 0;
		}
	}

}
