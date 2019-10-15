<!-- 
  Copyright 2019 NexCloud Co.,Ltd.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
 
      http://www.apache.org/licenses/LICENSE-2.0
 
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
-->
<div class="m-subheader">
	<div class="d-flex align-items-center">
		<div class="mr-auto">
			<h3 class="m-subheader__title">
				Host
			</h3>
		</div>
	</div>
</div>
<div class="m-content">
	<div class="row">
		<div class="col-lg-12">
			<div class="m-portlet m-portlet--head-sm m-portlet--full-height ">
				<div class="m-portlet__head">
					<div class="m-portlet__head-caption">
						<div class="m-portlet__head-title">
							<div class="m-portlet__head-text">Host Map</div>
						</div>
					</div>
					<div class="m-portlet__head-tools"></div>
				</div>
				<div class="m-portlet__body">
					<div class="m-widget14" style="max-width:800px; margin: 0 auto">
						<div id = "infrastructureMapChartArea">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="m-portlet m-portlet--head-sm m-portlet--full-height ">
				<div class="m-portlet__head">
					<div class="m-portlet__head-caption">
						<div class="m-portlet__head-title">
							<div class="m-portlet__head-text">Host List</div>
						</div>
					</div>
					<div class="m-portlet__head-tools"></div>
				</div>
				<div class="m-portlet__body">
					<div class="m-widget14">
						<div id="hostListTableArea"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="/resources/js/module/table/mDataTable.js" type="text/javascript"></script>
<script src="/resources/js/module/chart/tilemap.js" type="text/javascript"></script>
<script type="text/javascript">
function drawHost (data) {
	console.log(data);
	drawHostList(data);
	drawInfrastructureMap(data);
}

function drawInfrastructureMap (data) {
	var tilemapData = [];
	data.forEach(function (item){
		tilemapData.push({'hc-a2' : item.host_name, name : item.host_ip, value: item.cpu.cpu_per });
	})
	new Tilemap().area("infrastructureMapChartArea").data(tilemapData).draw();
}
function drawHostList (data) {
	var tableData = [];
	data.forEach(function (item){
		var m = {
			hostName : item.host_name,
			hostIp : item.host_ip,
			cpuPercent : Number(item.cpu.cpu_user_per),
			memoryPercent : Number(item.mem.used_per),
			load15 : Number(item.cpu.load15),
			event : "0"
		}
		var diskUsed = 0;
		var diskTotal = 0;
		item.disks.forEach(function(disk){
			diskUsed += disk.used;
			diskTotal += disk.total;
		})
		m.diskPercent = Number(diskUsed / (diskTotal * 100)).toFixed(2);
		tableData.push(m);
	});
	var columns = [
		{ 
			field : "hostName", 
			title : "Host Name", 
			width : 100, 
			template : function(row){
				return "<a href='/infrastructure/host/"+row.hostIp+"/detail'><span style='cursor:pointer;' class='font-weight-bold m--font-brand'>" + row.hostName + "</span></a>";
			}
		},
		{ field : "hostIp", title : "Host Ip", width : 100},
		{ field : "cpuPercent", title : "CPU (%)", width : 100,
			template: function (row) {
				return '<div class="m-table__progress"><div class="m-table__progress-sm progress m-progress--sm"> <div class="m-table__progress-bar progress-bar bg-brand" role="progressbar" aria-valuenow="' + row.cpuPercent + '" aria-valuemin="0" aria-valuemax="100" style="width:' + row.cpuPercent + '%;"></div></div><span class="m-table__stats">' + row.cpuPercent + '</span> </div>';
			}
		},
		{ field : "memoryPercent", title : "Memory (%)", width : 100,
			template: function (row) {
				return '<div class="m-table__progress"><div class="m-table__progress-sm progress m-progress--sm"> <div class="m-table__progress-bar progress-bar bg-brand" role="progressbar" aria-valuenow="' + row.memoryPercent + '" aria-valuemin="0" aria-valuemax="100" style="width:' + row.memoryPercent + '%;"></div></div><span class="m-table__stats">' + row.memoryPercent + '</span> </div>';
			}
		},
		{ field : "diskPercent", title : "Disk (%)", width : 100,
			template: function (row) {
				return '<div class="m-table__progress"><div class="m-table__progress-sm progress m-progress--sm"> <div class="m-table__progress-bar progress-bar bg-brand" role="progressbar" aria-valuenow="' + row.diskPercent + '" aria-valuemin="0" aria-valuemax="100" style="width:' + row.diskPercent + '%;"></div></div><span class="m-table__stats">' + row.diskPercent + '</span> </div>';
			}
		},
		{ field : "load15", title : "Load15", width : 100},
		{ field : "event", title : "event", width : 100}
	];
	new MDT().area("hostListTableArea").columns(columns).data(tableData).makeSearch().draw();
}
new Client().url("/api/v1/host/snapshot").callback(drawHost).get(); 
</script>