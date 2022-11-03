package com.liferay.samples.fbo.custom.vulcan.feature;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

@Component(
		property = {
			JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.application.base=/hello)",
			JaxrsWhiteboardConstants.JAX_RS_EXTENSION + "=true",
			JaxrsWhiteboardConstants.JAX_RS_NAME + "=Hello.Custom.Feature"
		},
		scope = ServiceScope.PROTOTYPE, service = Feature.class
	)
public class CustomVulcanFeature implements Feature {

	@Override
	public boolean configure(FeatureContext context) {

		context.register(CustomWebApplicationExceptionMapper.class, 1000);
		
		return true;
		
	}
	
}
