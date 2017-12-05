$(document).ready(function () {
	$("#carjqGrid").jqGrid({
		styleUI : 'Bootstrap',
		datatype: "local",
		editurl: 'editCar',
		colModel: [
			{ label: 'vehicleId', name: 'vehicleId', key: true, width: 50 },
			{ label: 'model', name: 'model', width: 200 ,editable: true,editrules : { required: true},edittype:"text"},
			{ label: 'year', name: 'year', width: 100 ,editable: true,editrules : { required: true},edittype:"text"},
			{ label: 'vehicleNo', name: 'vehicleNo', width: 100 ,editable: true,editrules : { required: true},edittype:"text"},
			{ label:'carType', name: 'carType', width: 100 ,editable: true,editrules : { required: true},edittype: "select",
				editoptions: {
					value: rateType
				}},
				{ label: 'ownerName', name: 'ownerName', width: 250 ,editable: true,editrules : { required: true},edittype:"text"},
				{ label:'dailyRate', name: 'dailyRate', width: 100},
				{ label:'weeklyRate', name: 'weeklyRate', width: 100},
				{ label:'status', name: 'status', width: 150 },
				{ label:'joiningDate', name: 'joiningDate', width: 120 },
				{ label:'leavingDate', name: 'leavingDate', width: 120 }
				],
				viewrecords: true,
				height: 400,
				rowNum: 20,
				loadonce: true,
				width: null,
				shrinkToFit: false,
				pager: "#carjqGridPager"
	});
	$('#carjqGrid').navGrid('#carjqGridPager',
			{ edit: false, add: false, del: true, search: true, refresh: false, view: true, position: "left", cloneToTop: true },
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
		editurl: 'editOwner',
		colModel: [
			{ label: 'ownerId', name: 'ownerId', key: true, width: 150 },
			{ label: 'name', name: 'name', width: 200, editable: true,editrules : { required: true},edittype:"text" },
			{ label: 'address', name: 'address', width: 400, editable: true,editrules : { required: true},edittype:"text" },
			{ label: 'ownerType', name: 'ownerType', width: 160, editable: true,editrules : { required: true},edittype: "select",
				editoptions: {
					value: ownerType
				} },
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
			{ edit: false, add: false, del: true, search: true, refresh: false, view: true, position: "left", cloneToTop: false },
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
		editurl: 'editCustomer',
		colModel: [
			{ label: 'id', name: 'id', key: true, width: 150 },
			{ label: 'name', name: 'name', width: 250, editable: true,editrules : { required: true},edittype:"text" },
			{ label: 'phone', name: 'phone', width: 200, editable: true,editrules : { required: true},edittype:"text" },
			{ label: 'customerType', name: 'customerType', width: 200, editable: true,editrules : { required: true},edittype: "select",
				editoptions: {
					value: customerType
				} },
				{ label:'status', name: 'status', width: 200 },
				{ label:'joiningDate', name: 'joiningDate', width: 210},
				{ label:'leavingDate', name: 'leavingDate', width: 210}
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
			{ edit: false, add: false, del: true, search: true, refresh: false, view: true, position: "left", cloneToTop: false },
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

	$("#ratejqGrid").jqGrid({
		styleUI : 'Bootstrap',
		datatype: 'local',
		editurl: 'editRate',
		colModel: [
			{ label: 'carTypeId', name: 'carTypeId', key: true, width: 340 },
			{ label: 'carType', name: 'carType', width: 340},
			{ label: 'dailyRate', name: 'dailyRate', width: 340, editable: true,editrules : { required: true},edittype:"text" },
			{ label: 'weeklyRate', name: 'weeklyRate', width: 340, editable: true,editrules : { required: true},edittype:"text"}
				],
				viewrecords: true,
				height: 400,
				rowNum: 20,
				loadonce: true,
				width: null,
				shrinkToFit: false,
				pager: "#ratejqGridPager"
	});
	$('#ratejqGrid').navGrid('#ratejqGridPager',
			{ edit: true, add: false, del: true, search: false, refresh: false, view: false, position: "left", cloneToTop: false },
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
	getCars();
	getCustomers();
	getOwners();
	getRates();
});
function getCars(){
	$.ajax({
		url:'cars?filter=',
		type:'get',
		success: function(gridData){
			$("#carjqGrid").jqGrid('setGridParam', { data: gridData}).trigger('reloadGrid');
		}
	});
}
function getCustomers(){
	$.ajax({
		url:'customers?filter=',
		type:'get',
		success: function(gridData){
			$("#customerjqGrid").jqGrid('setGridParam', { data: gridData}).trigger('reloadGrid');
		}
	});
}
function getOwners(){
	$.ajax({
		url:'owners',
		type:'get',
		success: function(gridData){
			$("#ownerjqGrid").jqGrid('setGridParam', { data: gridData}).trigger('reloadGrid');
		}
	});
}
function getRates(){
	$.ajax({
		url:'rate',
		type:'get',
		success: function(gridData){
			$("#ratejqGrid").jqGrid('setGridParam', { data: gridData}).trigger('reloadGrid');
		}
	});
}
$('#carModal').on('click',function(){
	$('#carType').html('');
	$('#carOwnerType').html('');
	$.ajax({
		url:'owners',
		type:'get',
		success: function(gridData){
			for(var i=0;i<gridData.length;i++){
				$('#carOwnerType').append('<option value="'+gridData[i].ownerId+'">'+gridData[i].name+'</option');
			}
		}
	});
	$.ajax({
		url:'rate',
		type:'get',
		success: function(gridData){
			for(var i=0;i<gridData.length;i++){
				$('#carType').append('<option value="'+gridData[i].carTypeId+'">'+gridData[i].carType+'</option');
			}
		}
	});
	
});
$('#ownerModal').on('click',function(){
	$('#ownerType').html('');
	$.ajax({
		url:'ownerType',
		type:'get',
		success: function(gridData){
			for(var i=0;i<gridData.length;i++){
				$('#ownerType').append('<option value="'+gridData[i].ownerTypeId+'">'+gridData[i].ownerType+'</option');
			}
		}
	});

});
$('#customerModal').on('click',function(){
	$('#customerType').html('');
	$.ajax({
		url:'customerType',
		type:'get',
		success: function(gridData){
			for(var i=0;i<gridData.length;i++){
				$('#customerType').append('<option value="'+gridData[i].customerTypeId+'">'+gridData[i].customerType+'</option');
			}
		}
	});
});

$('#addCarBtn').on('click',function(){
	console.log($("#carType").val());
	$.ajax({
		url:'addCar?model='+$("#model").val()+'&year='+$("#year").val()+'&vehicleNo='+$("#vehicleNo").val()+'&carTypeId='+$("#carType").val()+'&ownerId='+$("#carOwnerType").val(),
		type:'get',
		success: function(gridData){
			console.log(gridData);
			getCars();
		}
	});
});
$('#addOwnerBtn').on('click',function(){
	console.log($("#name").val());
	$.ajax({
		url:'addOwner?name='+$("#name").val()+'&address='+$("#address").val()+'&ownerTypeId='+$("#ownerType").val(),
		type:'get',
		success: function(gridData){
			getOwners();
		}
	});
});
$('#addCustomerBtn').on('click',function(){
	$.ajax({
		url:'addCustomer?name='+$("#customerName").val()+'&phone='+$("#phone").val()+'&customerType='+$("#customerType").val(),
		type:'get',
		success: function(gridData){
			getCustomers();
		}
	});
});
$('#addRateBtn').on('click',function(){
	$.ajax({
		url:'addRate?carType='+$("#carType2").val()+'&dailyRate='+$("#dailyRate").val()+'&weeklyRate='+$("#weeklyRate").val(),
		type:'get',
		success: function(gridData){
			getRates();
		}
	});
});