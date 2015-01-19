package net.aboutchurch.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.remoting.httpinvoker.CommonsHttpInvokerRequestExecutor;
import org.springframework.remoting.httpinvoker.HttpInvokerClientConfiguration;
import org.springframework.remoting.support.RemoteInvocationResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class AboutChurchHttpInvokerRequestExecutor extends CommonsHttpInvokerRequestExecutor{
	
	@Override
	protected RemoteInvocationResult doExecuteRequest(
			HttpInvokerClientConfiguration config, ByteArrayOutputStream baos)
			throws IOException, ClassNotFoundException {

		PostMethod postMethod = createPostMethod(config);
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		
		postMethod.setQueryString(attr.getRequest().getServerName());
		
		try {
			setRequestBody(config, postMethod, baos);
			executePostMethod(config, getHttpClient(), postMethod);
			validateResponse(config, postMethod);
			InputStream responseBody = getResponseBody(config, postMethod);
			return readRemoteInvocationResult(responseBody, config.getCodebaseUrl());
		}
		finally {
			// Need to explicitly release because it might be pooled.
			postMethod.releaseConnection();
		}
	}

}
