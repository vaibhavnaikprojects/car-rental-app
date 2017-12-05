<!-- Modal -->
<div id="addCar" class="modal fade" role="dialog">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add Car</h4>
      </div>
      <div class="modal-body">
        <div class="row">
        	<div class="col-lg-12">
        		<div class="form-group">
        			<input type="text" class="form-control" id="model" placeholder="Model" required="required"/>
        		</div>
        		<div class="form-group">
        			<input type="text" class="form-control" id="year" placeholder="Year" required="required"/>
        		</div>
        		<div class="form-group">
        			<input type="text" class="form-control" id="vehicleNo" placeholder="Vehicle No" required="required"/>
        		</div>
        		<div class="form-group">
	        		<select class="form-control" id="carType" required="required">
	        		</select>
	        	</div>
	        	<div class="form-group">
	        		<select class="form-control" id="carOwnerType" required="required">
	        		</select>
        		</div>
        	</div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button id="addCarBtn" type="button" class="btn btn-primary" data-dismiss="modal">Submit</button>
      </div>
    </div>
  </div>
</div>
<div id="addOwner" class="modal fade" role="dialog">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add Owner</h4>
      </div>
      <div class="modal-body">
        <div class="row">
        	<div class="col-lg-12">
        		<div class="form-group">
        			<input type="text" class="form-control" id="name" placeholder="Name" required="required"/>
        		</div>
        		<div class="form-group">
        			<input type="text" class="form-control" id="address" placeholder="Address" required="required"/>
        		</div>
        		<div class="form-group">
	        		<select class="form-control" id="ownerType" required="required">
	        		</select>
        		</div>
        	</div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button id="addOwnerBtn" type="button" class="btn btn-primary" data-dismiss="modal">Submit</button>
      </div>
    </div>
  </div>
</div>
<div id="addCustomer" class="modal fade" role="dialog">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add Customer</h4>
      </div>
      <div class="modal-body">
        <div class="row">
        	<div class="col-lg-12">
        		<div class="form-group">
        			<input type="text" class="form-control" id="customerName" placeholder="Name" required="required"/>
        		</div>
        		<div class="form-group">
        			<input type="text" class="form-control" id="phone" placeholder="Phone" required="required"/>
        		</div>
        		<div class="form-group">
	        		<select class="form-control" id="customerType" required="required">
	        		</select>
        		</div>
        	</div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button id="addCustomerBtn" type="button" class="btn btn-primary" data-dismiss="modal">Submit</button>
      </div>
    </div>
  </div>
</div>
<div id="addRate" class="modal fade" role="dialog">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add Rate</h4>
      </div>
      <div class="modal-body">
        <div class="row">
        	<div class="col-lg-12">
        		<div class="form-group">
        			<input type="text" class="form-control" id="carType2" placeholder="Car Type" required="required"/>
        		</div>
        		<div class="form-group">
        			<input type="number" class="form-control" id="dailyRate" placeholder="Daily Rate" required="required"/>
        		</div>
        		<div class="form-group">
        			<input type="number" class="form-control" id="weeklyRate" placeholder="Weekly Rate" required="required"/>
        		</div>
        	</div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button id="addRateBtn" type="button" class="btn btn-primary" data-dismiss="modal">Submit</button>
      </div>
    </div>
  </div>
</div>