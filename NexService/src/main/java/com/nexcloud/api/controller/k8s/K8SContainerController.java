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
package com.nexcloud.api.controller.k8s;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nexcloud.api.service.k8s.K8sContainerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/v1/cluster/{clusterId}/kubernetes/container")
public class K8SContainerController {
	
	
	static final Logger logger = LoggerFactory.getLogger(K8SContainerController.class);
	@Autowired private K8sContainerService k8sContainerService;

	@ApiOperation(value="Cpu Used", httpMethod="GET", notes="Cpu Used")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/cpu/used", method=RequestMethod.GET)
	public String getCpuUsed(@PathVariable(value="clusterId", required=false) String clusterId,
		@RequestParam(value="startTime", defaultValue="1h") String startTime,
		@RequestParam(value="time", defaultValue="5s") String time,
		@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sContainerService.getCpuUsed(clusterId, startTime, time, limit);
	}

	@ApiOperation(value="Cpu Used Percent", httpMethod="GET", notes="Cpu Used Percent")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/cpu/used/percent", method=RequestMethod.GET)
	public String getCpuUsedPercent(@PathVariable(value="clusterId", required=false) String clusterId,
		@RequestParam(value="startTime", defaultValue="1h") String startTime,
		@RequestParam(value="time", defaultValue="5s") String time,
		@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sContainerService.getCpuUsedPercent(clusterId, startTime, time, limit);
	}
	
	@ApiOperation(value="Cpu Limit", httpMethod="GET", notes="Cpu Limit")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/cpu/limit", method=RequestMethod.GET)
	public String getCpuLimit(@PathVariable(value="clusterId", required=false) String clusterId,
		@RequestParam(value="startTime", defaultValue="1h") String startTime,
		@RequestParam(value="time", defaultValue="5s") String time,
		@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sContainerService.getCpuLimit(clusterId, startTime, time, limit);
	}
	
	@ApiOperation(value="Cpu Request", httpMethod="GET", notes="Cpu Request")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/cpu/request", method=RequestMethod.GET)
	public String getCpuRequest(@PathVariable(value="clusterId", required=false) String clusterId,
		@RequestParam(value="startTime", defaultValue="1h") String startTime,
		@RequestParam(value="time", defaultValue="5s") String time,
		@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sContainerService.getCpuRequest(clusterId, startTime, time, limit);
	}	
	
	@ApiOperation(value="Memory Used", httpMethod="GET", notes="Memory Used")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/memory/used", method=RequestMethod.GET)
	public String getMemoryUsed(@PathVariable(value="clusterId", required=false) String clusterId,
		@RequestParam(value="startTime", defaultValue="1h") String startTime,
		@RequestParam(value="time", defaultValue="5s") String time,
		@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sContainerService.getMemoryUsed(clusterId, startTime, time, limit);
	}

	@ApiOperation(value="Memory Used Percent", httpMethod="GET", notes="Memory Used Percent")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/memory/used/percent", method=RequestMethod.GET)
	public String getMemoryUsedPercent(@PathVariable(value="clusterId", required=false) String clusterId,
		@RequestParam(value="startTime", defaultValue="1h") String startTime,
		@RequestParam(value="time", defaultValue="5s") String time,
		@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sContainerService.getMemoryUsedPercent(clusterId, startTime, time, limit);
	}
	
	@ApiOperation(value="Memory Limit", httpMethod="GET", notes="Memory Limit")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/memory/limit", method=RequestMethod.GET)
	public String getMemoryLimit(@PathVariable(value="clusterId", required=false) String clusterId,
		@RequestParam(value="startTime", defaultValue="1h") String startTime,
		@RequestParam(value="time", defaultValue="5s") String time,
		@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sContainerService.getMemoryLimit(clusterId, startTime, time, limit);
	}
	
	@ApiOperation(value="Memory Request", httpMethod="GET", notes="Memory Request")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/memory/request", method=RequestMethod.GET)
	public String getMemoryRequest(@PathVariable(value="clusterId", required=false) String clusterId,
		@RequestParam(value="startTime", defaultValue="1h") String startTime,
		@RequestParam(value="time", defaultValue="5s") String time,
		@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sContainerService.getMemoryRequest(clusterId, startTime, time, limit);
	}
	
	// by container
	
	@ApiOperation(value="Cpu Used By Container", httpMethod="GET", notes="Cpu Used By Container")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/{container}/cpu/used", method=RequestMethod.GET)
	public String getCpuUsedByContainer(@PathVariable(value="clusterId", required=false) String clusterId,
		@PathVariable(value="container", required=false) String container,
		@RequestParam(value="startTime", defaultValue="1h") String startTime,
		@RequestParam(value="time", defaultValue="5s") String time,
		@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sContainerService.getCpuUsedByContainer(clusterId, container, startTime, time, limit);
	}

	@ApiOperation(value="Cpu Used Percent By Container", httpMethod="GET", notes="Cpu Used Percent By Container")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/{container}/cpu/used/percent", method=RequestMethod.GET)
	public String getCpuUsedPercentByContainer(@PathVariable(value="clusterId", required=false) String clusterId,
		@PathVariable(value="container", required=false) String container,
		@RequestParam(value="startTime", defaultValue="1h") String startTime,
		@RequestParam(value="time", defaultValue="5s") String time,
		@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sContainerService.getCpuUsedPercentByContainer(clusterId, container, startTime, time, limit);
	}
	
	@ApiOperation(value="Cpu Limit By Container", httpMethod="GET", notes="Cpu Limit By Container")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/{container}/cpu/limit", method=RequestMethod.GET)
	public String getCpuLimitByContainer(@PathVariable(value="clusterId", required=false) String clusterId,
		@PathVariable(value="container", required=false) String container,
		@RequestParam(value="startTime", defaultValue="1h") String startTime,
		@RequestParam(value="time", defaultValue="5s") String time,
		@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sContainerService.getCpuLimitByContainer(clusterId, container, startTime, time, limit);
	}
	
	@ApiOperation(value="Cpu Request By Container", httpMethod="GET", notes="Cpu Request By Container")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/{container}/cpu/request", method=RequestMethod.GET)
	public String getCpuRequestByContainer(@PathVariable(value="clusterId", required=false) String clusterId,
		@PathVariable(value="container", required=false) String container,
		@RequestParam(value="startTime", defaultValue="1h") String startTime,
		@RequestParam(value="time", defaultValue="5s") String time,
		@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sContainerService.getCpuRequestByContainer(clusterId, container, startTime, time, limit);
	}	
	
	@ApiOperation(value="Memory Used By Container", httpMethod="GET", notes="Memory Used By Container")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/{container}/memory/used", method=RequestMethod.GET)
	public String getMemoryUsedByContainer(@PathVariable(value="clusterId", required=false) String clusterId,
		@PathVariable(value="container", required=false) String container,
		@RequestParam(value="startTime", defaultValue="1h") String startTime,
		@RequestParam(value="time", defaultValue="5s") String time,
		@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sContainerService.getMemoryUsedByContainer(clusterId, container, startTime, time, limit);
	}

	@ApiOperation(value="Memory Used Percent By Container", httpMethod="GET", notes="Memory Used Percent By Container")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/{container}/memory/used/percent", method=RequestMethod.GET)
	public String getMemoryUsedPercentByContainer(@PathVariable(value="clusterId", required=false) String clusterId,
		@PathVariable(value="container", required=false) String container,
		@RequestParam(value="startTime", defaultValue="1h") String startTime,
		@RequestParam(value="time", defaultValue="5s") String time,
		@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sContainerService.getMemoryUsedPercentByContainer(clusterId, container, startTime, time, limit);
	}
	
	@ApiOperation(value="Memory Limit By Container", httpMethod="GET", notes="Memory Limit By Container")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/{container}/memory/limit", method=RequestMethod.GET)
	public String getMemoryLimitByContainer(@PathVariable(value="clusterId", required=false) String clusterId,
		@PathVariable(value="container", required=false) String container,
		@RequestParam(value="startTime", defaultValue="1h") String startTime,
		@RequestParam(value="time", defaultValue="5s") String time,
		@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sContainerService.getMemoryLimitByContainer(clusterId, container, startTime, time, limit);
	}
	
	@ApiOperation(value="Memory Request By Container", httpMethod="GET", notes="Memory Request By Container")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/{container}/memory/request", method=RequestMethod.GET)
	public String getMemoryRequestByContainer(@PathVariable(value="clusterId", required=false) String clusterId,
		@PathVariable(value="container", required=false) String container,
		@RequestParam(value="startTime", defaultValue="1h") String startTime,
		@RequestParam(value="time", defaultValue="5s") String time,
		@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sContainerService.getMemoryRequestByContainer(clusterId, container, startTime, time, limit);
	}
}
