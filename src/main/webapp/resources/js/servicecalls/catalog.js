$(document).ready(function () {
	$("#carjqGrid").jqGrid({
		styleUI : 'Bootstrap',
		datatype: "local",
		colModel: [
			{ label: 'vehicleId', name: 'vehicleId', key: true, width: 100 },
			{ label: 'model', name: 'model', width: 200 ,editable: true },
			{ label: 'year', name: 'year', width: 100 ,editable: true },
			{ label: 'vehicleNo', name: 'vehicleNo', width: 150 ,editable: true },
			{ label:'carType', name: 'carType', width: 150 ,editable: true },
			{ label:'dailyRate', name: 'dailyRate', width: 100 ,editable: true },
			{ label:'weeklyRate', name: 'weeklyRate', width: 100 ,editable: true },
			{ label:'status', name: 'status', width: 150 },
			{ label:'joiningDate', name: 'joiningDate', width: 150 },
			{ label:'leavingDate', name: 'leavingDate', width: 150 }
			],
			viewrecords: true,
			height: 400,
			rowNum: 20,
			loadonce: true,
			shrinkToFit: false,
			pager: "#carjqGridPager"
	});
	$('#carjqGrid').navGrid('#carjqGridPager',
			{ edit: true, add: true, del: true, search: true, refresh: true, view: true, position: "left", cloneToTop: false },
			{
				editCaption: "Edit Record",
				recreateForm: true,
				checkOnUpdate : true,
				checkOnSubmit : true,
				closeAfterEdit: true,
				errorTextFormat: function (data) {
					return 'Error: ' + data.responseText
				}
			},
			// options for the Add Dialog
			{
				closeAfterAdd: true,
				recreateForm: true,
				errorTextFormat: function (data) {
					return 'Error: ' + data.responseText
				}
			},
			// options for the Delete Dailog
			{
				errorTextFormat: function (data) {
					return 'Error: ' + data.responseText
			}
		});
	$("#ownerjqGrid").jqGrid({
		styleUI : 'Bootstrap',
		datatype: "local",
		colModel: [
			{ label: 'ownerId', name: 'ownerId', key: true, width: 100 },
			{ label: 'name', name: 'name', width: 200, editable: true },
			{ label: 'address', name: 'address', width: 400, editable: true },
			{ label: 'ownerType', name: 'ownerType', width: 160, editable: true },
			{ label: 'status', name: 'status', width: 160},
			{ label: 'joiningDate', name: 'joiningDate', width: 160 },
			{ label: 'leavingDate', name: 'leavingDate', width: 160 }
			],
			viewrecords: true,
			height: 400,
			rowNum: 20,
			loadonce: true,
			width: null,
			shrinkToFit: false,
			pager: "#ownerjqGridPager"
	});
	$('#ownerjqGrid').navGrid('#ownerjqGridPager',
			{ edit: true, add: true, del: true, search: true, refresh: true, view: true, position: "left", cloneToTop: false },
			{
				editCaption: "Edit Record",
				recreateForm: true,
				checkOnUpdate : true,
				checkOnSubmit : true,
				closeAfterEdit: true,
				errorTextFormat: function (data) {
					return 'Error: ' + data.responseText
				}
			},
			// options for the Add Dialog
			{
				closeAfterAdd: true,
				recreateForm: true,
				errorTextFormat: function (data) {
					return 'Error: ' + data.responseText
				}
			},
			// options for the Delete Dailog
			{
				errorTextFormat: function (data) {
					return 'Error: ' + data.responseText
			}
		});
	$("#customerjqGrid").jqGrid({
		styleUI : 'Bootstrap',
		datatype: 'local',
		colModel: [
			{ label: 'id', name: 'id', key: true, width: 150 },
			{ label: 'name', name: 'name', width: 200, editable: true },
			{ label: 'phone', name: 'phone', width: 200, editable: true },
			{ label: 'customerType', name: 'customerType', width: 200, editable: true },
			{ label:'status', name: 'status', width: 200 },
			{ label:'joiningDate', name: 'joiningDate', width: 210 },
			{ label:'leavingDate', name: 'leavingDate', width: 210 }
			],
			viewrecords: true,
			height: 400,
			rowNum: 20,
			loadonce: true,
			width: null,
			shrinkToFit: false,
			pager: "#customerjqGridPager"
	});
	$('#customerjqGrid').navGrid('#customerjqGridPager',
			{ edit: true, add: true, del: true, search: true, refresh: true, view: true, position: "left", cloneToTop: false },
			{
				editCaption: "Edit Record",
				recreateForm: true,
				checkOnUpdate : true,
				checkOnSubmit : true,
				closeAfterEdit: true,
				errorTextFormat: function (data) {
					return 'Error: ' + data.responseText
				}
			},
			// options for the Add Dialog
			{
				closeAfterAdd: true,
				recreateForm: true,
				errorTextFormat: function (data) {
					return 'Error: ' + data.responseText
				}
			},
			// options for the Delete Dailog
			{
				errorTextFormat: function (data) {
					return 'Error: ' + data.responseText
			}
		});
	$.ajax({
		url:'cars',
		type:'get',
		success: function(gridData){
			$("#carjqGrid").jqGrid('setGridParam', { data: gridData}).trigger('reloadGrid');
		}
	});
	$.ajax({
		url:'customers',
		type:'get',
		success: function(gridData){
			$("#customerjqGrid").jqGrid('setGridParam', { data: gridData}).trigger('reloadGrid');
		}
	});
	$.ajax({
		url:'owners',
		type:'get',
		success: function(gridData){
			$("#ownerjqGrid").jqGrid('setGridParam', { data: gridData}).trigger('reloadGrid');
		}
	});
});