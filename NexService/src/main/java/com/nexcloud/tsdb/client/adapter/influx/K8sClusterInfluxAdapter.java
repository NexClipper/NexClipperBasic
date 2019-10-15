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
package com.nexcloud.tsdb.client.adapter.influx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nexcloud.tsdb.adapter.K8sClusterAdapter;
import com.nexcloud.tsdb.client.influx.InfluxClient;

@Component
public class K8sClusterInfluxAdapter implements K8sClusterAdapter {
	
	@Autowired private InfluxClient influxClient;

	@Override
	public String getCpuTotal(String clusterId, String startTime, String time, int limit) {
		return influxClient.get(getQuery(clusterId,"cpu_total", "cpuTotal", startTime, time, limit));
	}
	@Override
	public String getCpuUsed(String clusterId, String startTime, String time, int limit) {
		return influxClient.get(getQuery(clusterId,"cpu_used", "cpuUsed", startTime, time, limit));
	}
	@Override
	public String getCpuUsedPercent(String clusterId, String startTime, String time, int limit) {
		return influxClient.get(getQuery(clusterId,"cpu_used_percent", "cpuPercent", startTime, time, limit));
	}
	@Override
	public String getMemoryTotal(String clusterId, String startTime, String time, int limit) {
		return influxClient.get(getQuery(clusterId,"mem_total", "memoryTotal", startTime, time, limit));
	}
	@Override
	public String getMemoryUsed(String clusterId, String startTime, String time, int limit) {
		return influxClient.get(getQuery(clusterId,"mem_used", "memoryUsed", startTime, time, limit));
	}
	@Override
	public String getMemoryUsedPercent(String clusterId, String startTime, String time, int limit) {
		return influxClient.get(getQuery(clusterId,"mem_used_percent", "memoryPercent", startTime, time, limit));
	}
	@Override
	public String getPodTotal(String clusterId, String startTime, String time, int limit) {
		return influxClient.get(getQuery(clusterId,"pod_total", "podTotal", startTime, time, limit));
	}
	@Override
	public String getPodUsed(String clusterId, String startTime, String time, int limit) {
		return influxClient.get(getQuery(clusterId,"pod_used", "podUsed", startTime, time, limit));
	}
	@Override
	public String getPodUsedPercent(String clusterId, String startTime, String time, int limit) {
		return influxClient.get(getQuery(clusterId,"pod_used_percent", "podPercent", startTime, time, limit));
	}
	private String getQuery(String clusterId, String field, String alias, String startTime, String time, int limit) {
		return  "SELECT mean(" + field + ") AS " + alias
				+ " FROM \"k8s_cluster\""
				+ " WHERE cluster_id = '" + clusterId + "' AND time > now() - " + startTime
				+ " GROUP By time(" + time + ") fill(linear)"
				+ " ORDER By time asc"
				+ " LIMIT " + limit;
	}
}
