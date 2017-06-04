package com.xiaoweiyunchuang.microcloud.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 业务异常
 * 
 * @author zhongyibiao
 *
 */
public class BusinessException extends RuntimeException {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 
	 */
	private static final long serialVersionUID = -401986520984643113L;

	public BusinessException(String message) {
		super(message);
		logger.info(message);
	}

	public BusinessException(String message, Throwable e) {
		super(message, e);
		logger.info(message, e);
	}
}