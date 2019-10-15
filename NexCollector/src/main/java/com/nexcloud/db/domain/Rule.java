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
package com.nexcloud.db.domain;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rule {
	private Integer agent_id;
	
	private String target_system;
	
	private String target;
	
	private String type;
	
	private String scale_type;
	
	private String data_source;
	
	private String table;
	
	private String metric;
	
	private String group_by;
	
	private String condition;
	
	private String message;
	
	private String math;
	
	private String new_engine;
	
	private String severity;
	
	private String notify;
	
	private String slack_token;
	
	private String slack_channel;

	public String getNotify() {
		return notify;
	}

	public void setNotify(String notify) {
		this.notify = notify;
	}

	public String getSlack_token() {
		return slack_token;
	}

	public void setSlack_token(String slack_token) {
		this.slack_token = slack_token;
	}

	public String getSlack_channel() {
		return slack_channel;
	}

	public void setSlack_channel(String slack_channel) {
		this.slack_channel = slack_channel;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public Integer getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(Integer agent_id) {
		this.agent_id = agent_id;
	}

	public String getTarget_system() {
		return target_system;
	}

	public void setTarget_system(String target_system) {
		this.target_system = target_system;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getScale_type() {
		return scale_type;
	}

	public void setScale_type(String scale_type) {
		this.scale_type = scale_type;
	}

	public String getData_source() {
		return data_source;
	}

	public void setData_source(String data_source) {
		this.data_source = data_source;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

	public String getGroup_by() {
		return group_by;
	}

	public void setGroup_by(String group_by) {
		this.group_by = group_by;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMath() {
		return math;
	}

	public void setMath(String math) {
		this.math = math;
	}

	public String getNew_engine() {
		return new_engine;
	}

	public void setNew_engine(String new_engine) {
		this.new_engine = new_engine;
	}
}
