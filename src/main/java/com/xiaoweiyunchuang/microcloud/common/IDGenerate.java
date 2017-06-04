package com.xiaoweiyunchuang.microcloud.common;

import org.apache.commons.lang3.RandomUtils;

public class IDGenerate {

	/**
	 * 
	 * 18位主键
	 * 
	 */
	public static String getId() {
		IdWorker idWorker = new IdWorker(RandomUtils.nextLong(10, 30), RandomUtils.nextLong(10, 30));
		return idWorker.getId();
	}


}