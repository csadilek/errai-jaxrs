/*
 * Copyright 2011 JBoss, by Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.errai.enterprise.jaxrs.client.test;

import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;
import org.jboss.errai.enterprise.client.jaxrs.test.AbstractErraiJaxrsTest;
import org.jboss.errai.enterprise.jaxrs.client.shared.HeaderParamTestService;
import org.junit.Test;

import com.google.gwt.http.client.Response;

/**
 * Testing header parameters.
 * 
 * @author Christian Sadilek <csadilek@redhat.com>
 */
public class HeaderParamIntegrationTest extends AbstractErraiJaxrsTest {

  @Override
  public String getModuleName() {
    return "org.jboss.errai.enterprise.jaxrs.TestModule";
  }

  @Test
  public void testGetWithHeaderParam() {
    RestClient.create(HeaderParamTestService.class,
        new AssertionCallback<String>("@GET with @HeaderParam failed", "1")).getWithHeaderParam("1");
  }

  @Test
  public void testGetWithMultipleHeaderParams() {
    RestClient.create(HeaderParamTestService.class,
        new AssertionCallback<String>("@GET with @HeaderParams failed", "1/2.0")).getWithMultipleHeaderParams("1", 2.0f);
  }

  @Test
  public void testPostWithHeaderParam() {
    RestClient.create(HeaderParamTestService.class,
        new AssertionCallback<String>("@POST with @HeaderParam failed", "1")).postWithHeaderParam("1");
  }

  @Test
  public void testPutWithHeaderParam() {
    RestClient.create(HeaderParamTestService.class,
        new AssertionCallback<String>("@PUT with @HeaderParam failed", "1")).putWithHeaderParam("1");
  }

  @Test
  public void testDeleteWithHeaderParam() {
    RestClient.create(HeaderParamTestService.class,
        new AssertionCallback<String>("@DELETE with @HeaderParam failed", "1")).deleteWithHeaderParam("1");
  }

  @Test
  public void testHeadWithHeaderParam() {
    RestClient.create(HeaderParamTestService.class, 
        new AssertionResponseCallback("@HEAD with @HeaderParam failed", Response.SC_NO_CONTENT))
        .headWithHeaderParam("1");
  }
}