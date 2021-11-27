
var selectedIssueId = undefined;

function returnSeat(issueId) {
	
	selectedIssueId = issueId;
	
	$.post( '/rest/seatissue/'+selectedIssueId+'/return').done(function (msg){
				if( msg=='successful' ) {
					window.location = '/Studentseatissue/list';
				}
			});
	
	
}

