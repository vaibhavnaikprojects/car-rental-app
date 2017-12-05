<div class="panel panel-primary">
    <div class="panel-body" style="height: 500px;overflow-y:auto;text-align: justify;">
    	<div class="row">
    		<div class="col-lg-3">
    			<div class="panel panel-primary" style="height: 400px">
    				<div class="panel-heading">Owner Reports</div>
    				<div class="panel-body">
    				<div class="form-horizontal">
    					<div class="form-group">
    						<div class="col-sm-12">
		    					<select id="owners" class="form-control">
		    					</select>
	    					</div>
    					</div>
    					<div class="form-group">
							<div class="col-sm-12">
								<div class='input-group date' id='ownerStartDatetimepicker'>
									<input type="text" class="form-control" id="ownerStartDate" name="ownerStartDate" placeholder="Start Date"/>
									<span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span></span>
								</div>
							</div>
						</div>
    					<div class="form-group">
							<div class="col-sm-12">
								<div class='input-group date' id='ownerEndDatetimepicker'>
									<input type="text" class="form-control" id="ownerEndDate" name="ownerEndDate" placeholder="End Date" readonly="readonly" />
									<span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span></span>
								</div>
							</div>
						</div>
						<button type="button" id="ownerReport" class="btn btn-block btn-primary">Owner Weekly Report</button>
						</div>
    				</div>
    			</div>
    		</div>
    		<div class="col-lg-9">
    			<div class="panel panel-primary" style="height: 400px">
    				<div class="panel-heading">Details</div>
    				<div class="panel-body">
    					<div class="col-lg-9">
    							<div id="ownerList" class="list-group"></div>
    					</div>
    					<div class="col-lg-3">
    						<h4 id="ownerTotalAmount"></h4>
    					</div>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
</div>