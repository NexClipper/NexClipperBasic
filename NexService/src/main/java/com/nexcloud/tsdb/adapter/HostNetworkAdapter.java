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
package com.nexcloud.tsdb.adapter;
public interface HostNetworkAdapter {
	public String getNetworkRxbyte(String clusterId, String hostIp, String interfaceId, String startTime, String time, int limit);

	public String getNetworkRxdrop(String clusterId, String hostIp, String interfaceId, String startTime, String time, int limit);
	
	public String getNetworkRxerror(String clusterId, String hostIp, String interfaceId, String startTime, String time, int limit);
	
	public String getNetworkRxoverrun(String clusterId, String hostIp, String interfaceId, String startTime, String time, int limit);
	
	public String getNetworkRxpacket(String clusterId, String hostIp, String interfaceId, String startTime, String time, int limit);
	
	public String getNetworkTxbyte(String clusterId, String hostIp, String interfaceId, String startTime, String time, int limit);
	
	public String getNetworkTxdrop(String clusterId, String hostIp, String interfaceId, String startTime, String time, int limit);
	
	public String getNetworkTxerror(String clusterId, String hostIp, String interfaceId, String startTime, String time, int limit);
	
	public String getNetworkTxoverrun(String clusterId, String hostIp, String interfaceId, String startTime, String time, int limit);
	
	public String getNetworkTxpacket(String clusterId, String hostIp, String interfaceId, String startTime, String time, int limit);
	
	public String getNetworkTxcarrier(String clusterId, String hostIp, String interfaceId, String startTime, String time, int limit);
	
	public String getNetworkTxcollision(String clusterId, String hostIp, String interfaceId, String startTime, String time, int limit);
	
	public String getNetworkSpeed(String clusterId, String hostIp, String interfaceId, String startTime, String time, int limit);
}
