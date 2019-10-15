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
package com.nexcloud.tsdb.client.adapter.prometheus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.nexcloud.tsdb.adapter.K8sPodAdapter;
import com.nexcloud.tsdb.client.prometheus.PrometheusClient;

@Component
public class K8sPodPrometheusAdapter implements K8sPodAdapter{
	@Autowired private PrometheusClient prometheusClient;

	@Override
	public String getCpuUsed(String clusterId, String startTime, String time, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCpuUsedPercent(String clusterId, String startTime, String time, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCpuLimit(String clusterId, String startTime, String time, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCpuRequest(String clusterId, String startTime, String time, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMemoryUsed(String clusterId, String startTime, String time, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMemoryUsedPercent(String clusterId, String startTime, String time, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMemoryLimit(String clusterId, String startTime, String time, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMemoryRequest(String clusterId, String startTime, String time, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCpuUsed(String clusterId, String pod, String startTime, String time, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCpuUsedPercent(String clusterId, String pod, String startTime, String time, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCpuLimit(String clusterId, String pod, String startTime, String time, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCpuRequest(String clusterId, String pod, String startTime, String time, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMemoryUsed(String clusterId, String pod, String startTime, String time, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMemoryUsedPercent(String clusterId, String pod, String startTime, String time, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMemoryLimit(String clusterId, String pod, String startTime, String time, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMemoryRequest(String clusterId, String pod, String startTime, String time, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
