package org.jboss.errai.enterprise.jaxrs.client.test;

import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;
import org.jboss.errai.enterprise.client.jaxrs.test.AbstractErraiJaxrsTest;
import org.jboss.errai.enterprise.jaxrs.client.shared.PathParamTestService;
import org.junit.Test;

import com.google.gwt.http.client.Response;

/**
 * @author Christian Sadilek <csadilek@redhat.com>
 */
public class PathParamIntegrationTest extends AbstractErraiJaxrsTest {
  
  @Override
  public String getModuleName() {
    return "org.jboss.errai.enterprise.jaxrs.TestModule";
  }
  
 @Test
  public void testGetWithPathParam() {
    RestClient.create(PathParamTestService.class, 
        new AssertionCallback<Long>("@GET with @PathParam failed", 1l)).getWithPathParam(1l);
  }
 
  @Test
  public void testGetWithMultiplePathParams() {
    RestClient.create(PathParamTestService.class, 
        new AssertionCallback<String>("@GET with @PathParams failed", "1/2")).getWithMultiplePathParams(1l, 2l);
  }
 
  @Test
  public void testGetWithReusedPathParam() {
    RestClient.create(PathParamTestService.class, 
        new AssertionCallback<String>("@GET with @PathParam failed", "1/2/1")).getWithReusedPathParam(1l, 2l);
  }
  
  @Test
  public void testPostWithPathParam() {
    RestClient.create(PathParamTestService.class, 
        new AssertionCallback<Long>("@POST with @PathParam failed", 1l)).postWithPathParam(1l);
  }
  
  @Test
  public void testPutWithPathParam() {
    RestClient.create(PathParamTestService.class, 
        new AssertionCallback<Long>("@PUT with @PathParam failed", 1l)).putWithPathParam(1l);
  }
  
  @Test
  public void testDeleteWithPathParam() {
    RestClient.create(PathParamTestService.class, 
        new AssertionCallback<Long>("@DELETE with @PathParam failed", 1l)).deleteWithPathParam(1l);
  }
  
  @Test
  public void testHeadWithPathParam() {
    RestClient.create(PathParamTestService.class, 
        new AssertionResponseCallback("@HEAD with @PathParam failed", Response.SC_NO_CONTENT)).headWithPathParam(1l);
  }
}