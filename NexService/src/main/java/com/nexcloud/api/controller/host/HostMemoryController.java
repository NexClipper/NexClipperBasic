/*
* Copyright 2019 NexCloud Co.,Ltd.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.nexcloud.api.controller.host;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nexcloud.api.service.host.HostMemoryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/v1/cluster/{clusterId}/host/{hostIp}")
public class HostMemoryController {
	static final Logger logger = LoggerFactory.getLogger(HostMemoryController.class);
	
	@Autowired
	private HostMemoryService hostMemoryService;
	
	@RequestMapping(value="/memory/actual/free", method=RequestMethod.GET)
	@ApiOperation(value="Host actual free memory byte", httpMethod="GET", notes="Host actual free memory byte")
	@ApiImplicitParams({
		@ApiImplicitParam(
	            name = "hostIp", 
	            value = "Host IP (ex) 192.168.0.162", 
	            required = true, 
	            dataType = "string", 
	            paramType = "path"
	    ),
		@ApiImplicitParam(
	            name = "startTime", 
	            value = "조회 기간(ex) 1h: 현재부터 한시간전, 1d: 현재부터 하루전..", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),
		@ApiImplicitParam(
	            name = "time", 
	            value = "시간별 평균값(ex) 1s:조회가간중 1초간 평균값, 5s:조회기간중 5초간 평균값", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),@ApiImplicitParam(
	            name = "limit", 
	            value = "조회 건수 (ex) 1000 : 1천건까지조회", 
	            required = true, 
	            dataType = "int", 
	            paramType = "query"
	    )
	})
	@ApiResponses(value={
			@ApiResponse( code=200, message="SUCCESS"),
			@ApiResponse( code=500, message="Internal Server Error")
	})
	public String getActualFreeMemory(@PathVariable(value="clusterId", required=false) String clusterId,
			 @PathVariable(value="hostIp", required=true) String hostIp
			,@RequestParam(value="startTime", required=false, defaultValue="1h") String startTime
			,@RequestParam(value="time", required=false, defaultValue="5s") String time
			,@RequestParam(value="limit", required=false, defaultValue="1000") int limit
	) {
		return hostMemoryService.getActualFreeMemory(clusterId, hostIp, startTime, time, limit);
	}
	
	@RequestMapping(value="/memory/actual/used", method=RequestMethod.GET)
	@ApiOperation(value="Host actual used memory byte", httpMethod="GET", notes="Host actual used memory byte")
	@ApiImplicitParams({
		@ApiImplicitParam(
	            name = "hostIp", 
	            value = "Host IP (ex) 192.168.0.162", 
	            required = true, 
	            dataType = "string", 
	            paramType = "path"
	    ),
		@ApiImplicitParam(
	            name = "startTime", 
	            value = "조회 기간(ex) 1h: 현재부터 한시간전, 1d: 현재부터 하루전..", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),
		@ApiImplicitParam(
	            name = "time", 
	            value = "시간별 평균값(ex) 1s:조회가간중 1초간 평균값, 5s:조회기간중 5초간 평균값", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),@ApiImplicitParam(
	            name = "limit", 
	            value = "조회 건수 (ex) 1000 : 1천건까지조회", 
	            required = true, 
	            dataType = "int", 
	            paramType = "query"
	    )
	})
	@ApiResponses(value={
			@ApiResponse( code=200, message="SUCCESS"),
			@ApiResponse( code=500, message="Internal Server Error")
	})
	public String getActualUsedMemory(@PathVariable(value="clusterId", required=false) String clusterId,
			 @PathVariable(value="hostIp", required=true) String hostIp
			,@RequestParam(value="startTime", required=false, defaultValue="1h") String startTime
			,@RequestParam(value="time", required=false, defaultValue="5s") String time
			,@RequestParam(value="limit", required=false, defaultValue="1000") int limit
	) {
		return hostMemoryService.getActualUsedMemory(clusterId, hostIp, startTime, time, limit);
	}
	
	@RequestMapping(value="/memory/free/byte", method=RequestMethod.GET)
	@ApiOperation(value="Host free memory byte", httpMethod="GET", notes="Host free memory byte")
	@ApiImplicitParams({
		@ApiImplicitParam(
	            name = "hostIp", 
	            value = "Host IP (ex) 192.168.0.162", 
	            required = true, 
	            dataType = "string", 
	            paramType = "path"
	    ),
		@ApiImplicitParam(
	            name = "startTime", 
	            value = "조회 기간(ex) 1h: 현재부터 한시간전, 1d: 현재부터 하루전..", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),
		@ApiImplicitParam(
	            name = "time", 
	            value = "시간별 평균값(ex) 1s:조회가간중 1초간 평균값, 5s:조회기간중 5초간 평균값", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),@ApiImplicitParam(
	            name = "limit", 
	            value = "조회 건수 (ex) 1000 : 1천건까지조회", 
	            required = true, 
	            dataType = "int", 
	            paramType = "query"
	    )
	})
	@ApiResponses(value={
			@ApiResponse( code=200, message="SUCCESS"),
			@ApiResponse( code=500, message="Internal Server Error")
	})
	public String getFreeMemory(@PathVariable(value="clusterId", required=false) String clusterId,
			 @PathVariable(value="hostIp", required=true) String hostIp
			,@RequestParam(value="startTime", required=false, defaultValue="1h") String startTime
			,@RequestParam(value="time", required=false, defaultValue="5s") String time
			,@RequestParam(value="limit", required=false, defaultValue="1000") int limit
	) {
		return hostMemoryService.getFreeMemory(clusterId, hostIp, startTime, time, limit);
	}
	
	@RequestMapping(value="/memory/free/percent", method=RequestMethod.GET)
	@ApiOperation(value="Host free memory percent", httpMethod="GET", notes="Host free memory percent")
	@ApiImplicitParams({
		@ApiImplicitParam(
	            name = "hostIp", 
	            value = "Host IP (ex) 192.168.0.162", 
	            required = true, 
	            dataType = "string", 
	            paramType = "path"
	    ),
		@ApiImplicitParam(
	            name = "startTime", 
	            value = "조회 기간(ex) 1h: 현재부터 한시간전, 1d: 현재부터 하루전..", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),
		@ApiImplicitParam(
	            name = "time", 
	            value = "시간별 평균값(ex) 1s:조회가간중 1초간 평균값, 5s:조회기간중 5초간 평균값", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),@ApiImplicitParam(
	            name = "limit", 
	            value = "조회 건수 (ex) 1000 : 1천건까지조회", 
	            required = true, 
	            dataType = "int", 
	            paramType = "query"
	    )
	})
	@ApiResponses(value={
			@ApiResponse( code=200, message="SUCCESS"),
			@ApiResponse( code=500, message="Internal Server Error")
	})
	public String getFreePercentMemory(@PathVariable(value="clusterId", required=false) String clusterId,
			 @PathVariable(value="hostIp", required=true) String hostIp
			,@RequestParam(value="startTime", required=false, defaultValue="1h") String startTime
			,@RequestParam(value="time", required=false, defaultValue="5s") String time
			,@RequestParam(value="limit", required=false, defaultValue="1000") int limit
	) {
		return hostMemoryService.getFreePercentMemory(clusterId, hostIp, startTime, time, limit);
	}
	
	@RequestMapping(value="/memory/used/byte", method=RequestMethod.GET)
	@ApiOperation(value="Host used memory byte", httpMethod="GET", notes="Host used memory byte")
	@ApiImplicitParams({
		@ApiImplicitParam(
	            name = "hostIp", 
	            value = "Host IP (ex) 192.168.0.162", 
	            required = true, 
	            dataType = "string", 
	            paramType = "path"
	    ),
		@ApiImplicitParam(
	            name = "startTime", 
	            value = "조회 기간(ex) 1h: 현재부터 한시간전, 1d: 현재부터 하루전..", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),
		@ApiImplicitParam(
	            name = "time", 
	            value = "시간별 평균값(ex) 1s:조회가간중 1초간 평균값, 5s:조회기간중 5초간 평균값", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),@ApiImplicitParam(
	            name = "limit", 
	            value = "조회 건수 (ex) 1000 : 1천건까지조회", 
	            required = true, 
	            dataType = "int", 
	            paramType = "query"
	    )
	})
	@ApiResponses(value={
			@ApiResponse( code=200, message="SUCCESS"),
			@ApiResponse( code=500, message="Internal Server Error")
	})
	public String getUsedMemory(@PathVariable(value="clusterId", required=false) String clusterId,
			 @PathVariable(value="hostIp", required=true) String hostIp
			,@RequestParam(value="startTime", required=false, defaultValue="1h") String startTime
			,@RequestParam(value="time", required=false, defaultValue="5s") String time
			,@RequestParam(value="limit", required=false, defaultValue="1000") int limit
	) {
		return hostMemoryService.getUsedMemory(clusterId, hostIp, startTime, time, limit);
	}
	
	@RequestMapping(value="/memory/used/percent", method=RequestMethod.GET)
	@ApiOperation(value="Host used memory percent", httpMethod="GET", notes="Host used memory percent")
	@ApiImplicitParams({
		@ApiImplicitParam(
	            name = "hostIp", 
	            value = "Host IP (ex) 192.168.0.162", 
	            required = true, 
	            dataType = "string", 
	            paramType = "path"
	    ),
		@ApiImplicitParam(
	            name = "startTime", 
	            value = "조회 기간(ex) 1h: 현재부터 한시간전, 1d: 현재부터 하루전..", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),
		@ApiImplicitParam(
	            name = "time", 
	            value = "시간별 평균값(ex) 1s:조회가간중 1초간 평균값, 5s:조회기간중 5초간 평균값", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),@ApiImplicitParam(
	            name = "limit", 
	            value = "조회 건수 (ex) 1000 : 1천건까지조회", 
	            required = true, 
	            dataType = "int", 
	            paramType = "query"
	    )
	})
	@ApiResponses(value={
			@ApiResponse( code=200, message="SUCCESS"),
			@ApiResponse( code=500, message="Internal Server Error")
	})
	public String getUsedPercentMemory(@PathVariable(value="clusterId", required=false) String clusterId,
			 @PathVariable(value="hostIp", required=true) String hostIp
			,@RequestParam(value="startTime", required=false, defaultValue="1h") String startTime
			,@RequestParam(value="time", required=false, defaultValue="5s") String time
			,@RequestParam(value="limit", required=false, defaultValue="1000") int limit
	) {
		return hostMemoryService.getUsedPercentMemory(clusterId, hostIp, startTime, time, limit);
	}
	
	@RequestMapping(value="/memory/total/byte", method=RequestMethod.GET)
	@ApiOperation(value="Host total memory byte", httpMethod="GET", notes="Host total memory byte")
	@ApiImplicitParams({
		@ApiImplicitParam(
	            name = "hostIp", 
	            value = "Host IP (ex) 192.168.0.162", 
	            required = true, 
	            dataType = "string", 
	            paramType = "path"
	    ),
		@ApiImplicitParam(
	            name = "startTime", 
	            value = "조회 기간(ex) 1h: 현재부터 한시간전, 1d: 현재부터 하루전..", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),
		@ApiImplicitParam(
	            name = "time", 
	            value = "시간별 평균값(ex) 1s:조회가간중 1초간 평균값, 5s:조회기간중 5초간 평균값", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),@ApiImplicitParam(
	            name = "limit", 
	            value = "조회 건수 (ex) 1000 : 1천건까지조회", 
	            required = true, 
	            dataType = "int", 
	            paramType = "query"
	    )
	})
	@ApiResponses(value={
			@ApiResponse( code=200, message="SUCCESS"),
			@ApiResponse( code=500, message="Internal Server Error")
	})
	public String getTotalMemory(@PathVariable(value="clusterId", required=false) String clusterId,
			 @PathVariable(value="hostIp", required=true) String hostIp
			,@RequestParam(value="startTime", required=false, defaultValue="1h") String startTime
			,@RequestParam(value="time", required=false, defaultValue="5s") String time
			,@RequestParam(value="limit", required=false, defaultValue="1000") int limit
	) {
		return hostMemoryService.getTotalMemory(clusterId, hostIp, startTime, time, limit);
	}
	
	/////
	@RequestMapping(value="/swap/free/byte", method=RequestMethod.GET)
	@ApiOperation(value="Host swap free memory byte", httpMethod="GET", notes="Host swap free memory byte")
	@ApiImplicitParams({
		@ApiImplicitParam(
	            name = "hostIp", 
	            value = "Host IP (ex) 192.168.0.162", 
	            required = true, 
	            dataType = "string", 
	            paramType = "path"
	    ),
		@ApiImplicitParam(
	            name = "startTime", 
	            value = "조회 기간(ex) 1h: 현재부터 한시간전, 1d: 현재부터 하루전..", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),
		@ApiImplicitParam(
	            name = "time", 
	            value = "시간별 평균값(ex) 1s:조회가간중 1초간 평균값, 5s:조회기간중 5초간 평균값", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),@ApiImplicitParam(
	            name = "limit", 
	            value = "조회 건수 (ex) 1000 : 1천건까지조회", 
	            required = true, 
	            dataType = "int", 
	            paramType = "query"
	    )
	})
	@ApiResponses(value={
			@ApiResponse( code=200, message="SUCCESS"),
			@ApiResponse( code=500, message="Internal Server Error")
	})
	public String getSwapFreeMemory(@PathVariable(value="clusterId", required=false) String clusterId,
			 @PathVariable(value="hostIp", required=true) String hostIp
			,@RequestParam(value="startTime", required=false, defaultValue="1h") String startTime
			,@RequestParam(value="time", required=false, defaultValue="5s") String time
			,@RequestParam(value="limit", required=false, defaultValue="1000") int limit
	) {
		return hostMemoryService.getSwapFreeMemory(clusterId, hostIp, startTime, time, limit);
	}
	
	@RequestMapping(value="/swap/free/percent", method=RequestMethod.GET)
	@ApiOperation(value="Host swap free memory percent", httpMethod="GET", notes="Host swap free memory percent")
	@ApiImplicitParams({
		@ApiImplicitParam(
	            name = "hostIp", 
	            value = "Host IP (ex) 192.168.0.162", 
	            required = true, 
	            dataType = "string", 
	            paramType = "path"
	    ),
		@ApiImplicitParam(
	            name = "startTime", 
	            value = "조회 기간(ex) 1h: 현재부터 한시간전, 1d: 현재부터 하루전..", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),
		@ApiImplicitParam(
	            name = "time", 
	            value = "시간별 평균값(ex) 1s:조회가간중 1초간 평균값, 5s:조회기간중 5초간 평균값", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),@ApiImplicitParam(
	            name = "limit", 
	            value = "조회 건수 (ex) 1000 : 1천건까지조회", 
	            required = true, 
	            dataType = "int", 
	            paramType = "query"
	    )
	})
	@ApiResponses(value={
			@ApiResponse( code=200, message="SUCCESS"),
			@ApiResponse( code=500, message="Internal Server Error")
	})
	public String getSwapFreePercentMemory(@PathVariable(value="clusterId", required=false) String clusterId,
			 @PathVariable(value="hostIp", required=true) String hostIp
			,@RequestParam(value="startTime", required=false, defaultValue="1h") String startTime
			,@RequestParam(value="time", required=false, defaultValue="5s") String time
			,@RequestParam(value="limit", required=false, defaultValue="1000") int limit
	) {
		return hostMemoryService.getSwapFreePercentMemory(clusterId, hostIp, startTime, time, limit);
	}
	
	@RequestMapping(value="/swap/used/byte", method=RequestMethod.GET)
	@ApiOperation(value="Host swap used memory byte", httpMethod="GET", notes="Host swap used memory byte")
	@ApiImplicitParams({
		@ApiImplicitParam(
	            name = "hostIp", 
	            value = "Host IP (ex) 192.168.0.162", 
	            required = true, 
	            dataType = "string", 
	            paramType = "path"
	    ),
		@ApiImplicitParam(
	            name = "startTime", 
	            value = "조회 기간(ex) 1h: 현재부터 한시간전, 1d: 현재부터 하루전..", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),
		@ApiImplicitParam(
	            name = "time", 
	            value = "시간별 평균값(ex) 1s:조회가간중 1초간 평균값, 5s:조회기간중 5초간 평균값", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),@ApiImplicitParam(
	            name = "limit", 
	            value = "조회 건수 (ex) 1000 : 1천건까지조회", 
	            required = true, 
	            dataType = "int", 
	            paramType = "query"
	    )
	})
	@ApiResponses(value={
			@ApiResponse( code=200, message="SUCCESS"),
			@ApiResponse( code=500, message="Internal Server Error")
	})
	public String getSwapUsedMemory(@PathVariable(value="clusterId", required=false) String clusterId,
			 @PathVariable(value="hostIp", required=true) String hostIp
			,@RequestParam(value="startTime", required=false, defaultValue="1h") String startTime
			,@RequestParam(value="time", required=false, defaultValue="5s") String time
			,@RequestParam(value="limit", required=false, defaultValue="1000") int limit
	) {
		return hostMemoryService.getSwapUsedMemory(clusterId, hostIp, startTime, time, limit);
	}
	
	@RequestMapping(value="/swap/used/percent", method=RequestMethod.GET)
	@ApiOperation(value="Host swap used memory percent", httpMethod="GET", notes="Host swap used memory percent")
	@ApiImplicitParams({
		@ApiImplicitParam(
	            name = "hostIp", 
	            value = "Host IP (ex) 192.168.0.162", 
	            required = true, 
	            dataType = "string", 
	            paramType = "path"
	    ),
		@ApiImplicitParam(
	            name = "startTime", 
	            value = "조회 기간(ex) 1h: 현재부터 한시간전, 1d: 현재부터 하루전..", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),
		@ApiImplicitParam(
	            name = "time", 
	            value = "시간별 평균값(ex) 1s:조회가간중 1초간 평균값, 5s:조회기간중 5초간 평균값", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),@ApiImplicitParam(
	            name = "limit", 
	            value = "조회 건수 (ex) 1000 : 1천건까지조회", 
	            required = true, 
	            dataType = "int", 
	            paramType = "query"
	    )
	})
	@ApiResponses(value={
			@ApiResponse( code=200, message="SUCCESS"),
			@ApiResponse( code=500, message="Internal Server Error")
	})
	public String getSwapUsedPercentMemory(@PathVariable(value="clusterId", required=false) String clusterId,
			 @PathVariable(value="hostIp", required=true) String hostIp
			,@RequestParam(value="startTime", required=false, defaultValue="1h") String startTime
			,@RequestParam(value="time", required=false, defaultValue="5s") String time
			,@RequestParam(value="limit", required=false, defaultValue="1000") int limit
	) {
		return hostMemoryService.getSwapUsedPercentMemory(clusterId, hostIp, startTime, time, limit);
	}
	
	@RequestMapping(value="/swap/total/byte", method=RequestMethod.GET)
	@ApiOperation(value="Host swap total memory byte", httpMethod="GET", notes="Host swap total memory byte")
	@ApiImplicitParams({
		@ApiImplicitParam(
	            name = "hostIp", 
	            value = "Host IP (ex) 192.168.0.162", 
	            required = true, 
	            dataType = "string", 
	            paramType = "path"
	    ),
		@ApiImplicitParam(
	            name = "startTime", 
	            value = "조회 기간(ex) 1h: 현재부터 한시간전, 1d: 현재부터 하루전..", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),
		@ApiImplicitParam(
	            name = "time", 
	            value = "시간별 평균값(ex) 1s:조회가간중 1초간 평균값, 5s:조회기간중 5초간 평균값", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),@ApiImplicitParam(
	            name = "limit", 
	            value = "조회 건수 (ex) 1000 : 1천건까지조회", 
	            required = true, 
	            dataType = "int", 
	            paramType = "query"
	    )
	})
	@ApiResponses(value={
			@ApiResponse( code=200, message="SUCCESS"),
			@ApiResponse( code=500, message="Internal Server Error")
	})
	public String getSwapTotalMemory(@PathVariable(value="clusterId", required=false) String clusterId,
			 @PathVariable(value="hostIp", required=true) String hostIp
			,@RequestParam(value="startTime", required=false, defaultValue="1h") String startTime
			,@RequestParam(value="time", required=false, defaultValue="5s") String time
			,@RequestParam(value="limit", required=false, defaultValue="1000") int limit
	) {
		return hostMemoryService.getSwapTotalMemory(clusterId, hostIp, startTime, time, limit);
	}
	
	@RequestMapping(value="/swap/pagein", method=RequestMethod.GET)
	@ApiOperation(value="Host swap memory pagein", httpMethod="GET", notes="Host swap memory pagein")
	@ApiImplicitParams({
		@ApiImplicitParam(
	            name = "hostIp", 
	            value = "Host IP (ex) 192.168.0.162", 
	            required = true, 
	            dataType = "string", 
	            paramType = "path"
	    ),
		@ApiImplicitParam(
	            name = "startTime", 
	            value = "조회 기간(ex) 1h: 현재부터 한시간전, 1d: 현재부터 하루전..", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),
		@ApiImplicitParam(
	            name = "time", 
	            value = "시간별 평균값(ex) 1s:조회가간중 1초간 평균값, 5s:조회기간중 5초간 평균값", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),@ApiImplicitParam(
	            name = "limit", 
	            value = "조회 건수 (ex) 1000 : 1천건까지조회", 
	            required = true, 
	            dataType = "int", 
	            paramType = "query"
	    )
	})
	@ApiResponses(value={
			@ApiResponse( code=200, message="SUCCESS"),
			@ApiResponse( code=500, message="Internal Server Error")
	})
	public String getSwapPagein(@PathVariable(value="clusterId", required=false) String clusterId,
			 @PathVariable(value="hostIp", required=true) String hostIp
			,@RequestParam(value="startTime", required=false, defaultValue="1h") String startTime
			,@RequestParam(value="time", required=false, defaultValue="5s") String time
			,@RequestParam(value="limit", required=false, defaultValue="1000") int limit
	) {
		return hostMemoryService.getSwapPagein(clusterId, hostIp, startTime, time, limit);
	}
	
	@RequestMapping(value="/swap/pageout", method=RequestMethod.GET)
	@ApiOperation(value="Host swap memory pageout", httpMethod="GET", notes="Host swap memory pageout")
	@ApiImplicitParams({
		@ApiImplicitParam(
	            name = "hostIp", 
	            value = "Host IP (ex) 192.168.0.162", 
	            required = true, 
	            dataType = "string", 
	            paramType = "path"
	    ),
		@ApiImplicitParam(
	            name = "startTime", 
	            value = "조회 기간(ex) 1h: 현재부터 한시간전, 1d: 현재부터 하루전..", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),
		@ApiImplicitParam(
	            name = "time", 
	            value = "시간별 평균값(ex) 1s:조회가간중 1초간 평균값, 5s:조회기간중 5초간 평균값", 
	            required = true, 
	            dataType = "string", 
	            paramType = "query"
	    ),@ApiImplicitParam(
	            name = "limit", 
	            value = "조회 건수 (ex) 1000 : 1천건까지조회", 
	            required = true, 
	            dataType = "int", 
	            paramType = "query"
	    )
	})
	@ApiResponses(value={
			@ApiResponse( code=200, message="SUCCESS"),
			@ApiResponse( code=500, message="Internal Server Error")
	})
	public String getSwapPageout(@PathVariable(value="clusterId", required=false) String clusterId,
			 @PathVariable(value="hostIp", required=true) String hostIp
			,@RequestParam(value="startTime", required=false, defaultValue="1h") String startTime
			,@RequestParam(value="time", required=false, defaultValue="5s") String time
			,@RequestParam(value="limit", required=false, defaultValue="1000") int limit
	) {
		return hostMemoryService.getSwapPageout(clusterId, hostIp, startTime, time, limit);
	}
}
