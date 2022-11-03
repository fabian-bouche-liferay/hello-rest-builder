package com.liferay.samples.fbo.custom.vulcan.feature;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class CustomWebApplicationExceptionMapper extends BaseExceptionMapper<WebApplicationException> {

	@Override
	protected Problem getProblem(
		WebApplicationException webApplicationException) {

		_log.error(webApplicationException);

		Response response = webApplicationException.getResponse();

		return new Problem(
			Response.Status.fromStatusCode(response.getStatus()),
			webApplicationException.getMessage());
	}

	private static final Log _log = LogFactoryUtil.getLog(
			CustomWebApplicationExceptionMapper.class);
	
	@Override
	protected boolean isSanitize() {
		return false;
	}

}
