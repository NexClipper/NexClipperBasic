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
function Tilemap() {
	this.area;
	this.data;
	this.option = {
		chart: {
			type: 'tilemap',
			inverted: true,
			style: {
				margin : 'auto',
				fontFamily: 'Dosis, sans-serif'
			},
		},
		title: {
			text: ''
		},
		subtitle: {
			text: ''
		},
		xAxis: {
			visible: false
		},
		yAxis: {
			visible: false
		},

		colorAxis: {
			dataClasses: [
				{
					from: -1,
					color: '#000000',
					name: 'Disconnect'
				},
				{
					from: 0,
					to: 60,
					color: colors.success,
					name: '0 - 60 %'
				},
				{
					from: 60,
					to: 80,
					color: colors.warning,
					name: '60 - 80 %'
				}, 
				{
					from: 80,
					color: colors.danger,
					name: '> 80 %'
				}
			]
		},
		tooltip: {
			headerFormat: '',
			pointFormat: 'The utillization of <b> {point.name}</b> is <b>{point.value} %</b>',
			enabled: true
		},
		plotOptions: {
			series: {
				dataLabels: {
					enabled: true,
					format: '{point.hc-a2}',
					color: '#ffffff',
					style: {
						textOutline: false,
						fontSize: '100%'
					}
				},
				cursor: 'pointer',
				point: {
					events: {
						click: function () {
							location.href = "/infrastructure/host/" + this.name + "/detail";
						}
					}
				}
			}
		},
		exporting: {
			enabled: false    
		},
		series: []
	};
}
Tilemap.prototype.option = function(option){
	this.option = option;
	return this;
}
Tilemap.prototype.area = function(area){
	this.area = area;
	return this;
}
Tilemap.prototype.event = function(event){
	this.event = event;
	return this;
}
Tilemap.prototype.clickEvent = function(clickEvent){
	this.option.plotOptions.series.point.events.click = clickEvent;
	return this;
}

Tilemap.prototype.data = function(data){
	//var div = document.getElementById(this.area);
	//var w = div.parentElement.offsetWidth;
	//var h = div.offsetHeight;
	var cur_x = 0;
	//var length = Number(Math.sqrt(data.length*w/h).toFixed(0));
	data.forEach(function (item, i){
		if(i != 0 && (i % 4) == 0) cur_x++;
		
		item.x = cur_x;
		item.y = i % 4;
	})
	
	this.data = this.option.series = [{
		name: '',
		data: data
	}];
	return this;
}
Tilemap.prototype.draw = function(){
	this.chart = Highcharts.chart(this.area, this.option);
	return this;
}
