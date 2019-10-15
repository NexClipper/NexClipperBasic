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
package com.nexcloud.workflow.docker.domain;
import java.util.ArrayList;
import java.util.List;

import com.nexcloud.workflow.docker.domain.system.SystemInfo;

public class Docker {
	private SystemInfo docker_info;
	private List<Containers> containers;
	
	public SystemInfo getDocker_info() {
		return docker_info;
	}

	public void setDocker_info(SystemInfo docker_info) {
		this.docker_info = docker_info;
	}
	
	public Docker() {
		this.containers = new ArrayList<Containers>();
	}
	
	public List<Containers> getContainers() {
		if( containers == null )
			containers = new ArrayList<Containers>();
		return containers;
	}

	public void setContainers(List<Containers> containers) {
		this.containers = containers;
	}
}