/*******************************************************************************
 * Copyright (c) 2017 IBM Corp.
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
 *******************************************************************************/ 
package wasdev.sample.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import com.google.gson.Gson;

import com.ibm.bluemixmqtt.AppTest;
import com.ibm.bluemixmqtt.AppTestFactory;

@ApplicationPath("api")
@Path("/devicetalkback")
public class DeviceTalkBackAPI extends Application {
	
	final AppTest appTest = AppTestFactory.getInstance();

    /**
     * Tells the device to reset its count.
     * Note that this API is for example purposes only.
     * 
     * REST API example:
     * <code>
     * POST http://localhost:9080/GetStartedJava/api/devicetalkback
     * <code>
     * POST Body:
     * <code>
     * {
     *   "reset":true
     * }
     * </code>
     * Response:
     * <code>
     * "success"
     * </code>
     * @param request a dummy request body
     * @return the string "success"
     */
    @POST
    @Produces("application/text")
    @Consumes("application/json")
    public String newToDo(Map<String,Boolean> request) {
      if(appTest == null) {
    	  return String.format("Nope, store was null");
      }
      appTest.sendReset();
      return String.format("success");

    }

}
