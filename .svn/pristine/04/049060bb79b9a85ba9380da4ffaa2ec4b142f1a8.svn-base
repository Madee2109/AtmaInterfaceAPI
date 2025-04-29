function displayProgress()
{	
	document.getElementById("FreezeAllWork").style.display = "block";
}
function hideProgress()
{
	
	document.getElementById("FreezeAllWork").style.display = "none";
}

function custompopupopen()
{	
	document.getElementById("custompopup").style.display = "block";
}
function custompopupclose()
{
	
	document.getElementById("custompopup").style.display = "none";
}

function previewbutton(){
	
	 document.getElementById('inform:previewbutton').click();
	
}
function opennewwindow( URL) 
{
	
//alert(URL);
day = new Date();
id = day.getTime();
eval("page" + id + " = window.open(URL, '" + id + "', 'dependent=yes,toolbar=0,scrollbars=1,location=0,statusbar=1,menubar=0,resizable=1,width=780,height=580, left=100 right = 20,top = 20,bottom=20');");
return false;
}
function runreport( runid) 
{
	
URL="../runreport/"+runid;
day = new Date();
id = day.getTime();
eval("page" + id + " = window.open(URL, '" + id + "', 'dependent=yes,toolbar=0,scrollbars=1,location=0,statusbar=1,menubar=0,resizable=1,width=780,height=580, left=100 right = 20,top = 20,bottom=20');");
return false;
}
function viewreport( runid) 
{
	
URL="../reportviewer/"+runid;
day = new Date();
id = day.getTime();
eval("page" + id + " = window.open(URL, '" + id + "', 'dependent=yes,toolbar=0,scrollbars=1,location=0,statusbar=1,menubar=0,resizable=1 left=100 right = 20,top = 20,bottom=20');");
return false;
}

function findbrowsertype(){
	var userag = navigator.userAgent;
	//alert(userag);
	if(/Edg/.test(userag)){
		return 1;
	}
    return !!userag.match(/Trident.*rv[ :]*11\./)  ;
  }
function synchronizefrozontable() {
	
	
	 var ie9_flag= findbrowsertype();
	 
	// alert(ie9_flag);
	 var w_height = $(window).height();
	  
	    var minheight = 20;
	  
	        var $leftRows = $('.ui-datatable-frozenlayout-left').find('tr');
	        var $rightRows = $('.ui-datatable-frozenlayout-right').find('tr');
	        $leftRows.each(function (index) {
	        	 var $leftRow = $(this);
		            var $rightRow = $rightRows.eq(index);
		 		
		           var height1 = $leftRow.innerHeight();
		           var height2 = $rightRow.innerHeight();
		           
		           if(height1>minheight){
		        	   minheight=height1;
		           }
		           if(height2>minheight){
		        	   minheight=height2;
		           }
	        })
	      
	         $leftRows.each(function (index) {
	       
	        	
	            var $leftRow = $(this);
	            var $rightRow = $rightRows.eq(index);
	 		
	           var left_height = $leftRow.innerHeight();
	           
	           $leftRow.innerHeight(minheight);
	           if($rightRow.innerHeight() == $leftRow.innerHeight()){
	        	   //alert(index+"-left right equal");
	           }
	           else if ($rightRow.innerHeight() > $leftRow.innerHeight()) {
	        	  // alert(index+"-left small");
	                $leftRow.innerHeight($rightRow.outerHeight());
	                if (ie9_flag===1) {
	                	$leftRow.innerHeight($rightRow.innerHeight());
	                } 
	               // $leftRow.outerHeight($rightRow.innerHeight());
	            } else {
	            	 
	                //$rightRow.outerHeight($leftRow.innerHeight());
	                 if (ie9_flag===1) {
	                	$rightRow.innerHeight($leftRow.innerHeight());
	                	
	                } else{
	                	$rightRow.innerHeight($leftRow.outerHeight());
	                } 
	            }
	           
	             
	        })
	        
	          var lastrow =($rightRows.length)-1;
	         if(lastrow >2){
	        	 if (ie9_flag===1) {
	        		 $(".ui-datatable-scrollable-body").height(w_height - 330);
			       	  var $leftRow = $leftRows.eq(lastrow);
			        	$leftRow.innerHeight($leftRow.innerHeight()+20); 
	        	 }else{
		        	  $(".ui-datatable-scrollable-body").height(w_height - 330);
		       	  var $leftRow = $leftRows.eq(lastrow);
		      /*  	$leftRow.innerHeight($leftRow.outerHeight()+20); */
	        	 }
	         }
          
	         
	         
	    }

function synchronizeRowsHeight( minheight) {
	
	
           
	         
	         
	    }
function synchronizeRowsHeightold( minheight) {
	
	
	 var ie9_flag=false;
	    var w_height = $(window).height();
	  
	        var $leftRows = $('.ui-datatable-frozenlayout-left').find('tr');
	        var $rightRows = $('.ui-datatable-frozenlayout-right').find('tr');
	      
	         $leftRows.each(function (index) {
	       
	        	
	            var $leftRow = $(this);
	            var $rightRow = $rightRows.eq(index);
	 		
	           var left_height = $leftRow.innerHeight();
	           
	           $leftRow.innerHeight(minheight);
	           if($rightRow.innerHeight() == $leftRow.innerHeight()){
	        	   //alert(index+"-left right equal");
	           }
	           else if ($rightRow.innerHeight() > $leftRow.innerHeight()) {
	        	  // alert(index+"-left small");
	                $leftRow.innerHeight($rightRow.outerHeight());
	                if (ie9_flag) {
	                	$leftRow.innerHeight($rightRow.innerHeight());
	                } 
	               // $leftRow.outerHeight($rightRow.innerHeight());
	            } else {
	            	 
	                //$rightRow.outerHeight($leftRow.innerHeight());
	                 if (ie9_flag) {
	                	$rightRow.innerHeight($leftRow.innerHeight());
	                	
	                } else{
	                	$rightRow.innerHeight($leftRow.outerHeight());
	                } 
	            }
	           
	             
	        })
	        
	          var lastrow =($rightRows.length)-1;
	         if(lastrow >2){
	        	 if (ie9_flag) {
	        		 $(".ui-datatable-scrollable-body").height(w_height - 330);
			       	  var $leftRow = $leftRows.eq(lastrow);
			        	$leftRow.innerHeight($leftRow.innerHeight()+20); 
	        	 }else{
		        	  $(".ui-datatable-scrollable-body").height(w_height - 330);
		       	  var $leftRow = $leftRows.eq(lastrow);
		      /*  	$leftRow.innerHeight($leftRow.outerHeight()+20); */
	        	 }
	         }
          
	         
	         
	    }

function focusdivid(divid){
	alert(divid	);
	smoothScroll(document.getElementById(divid));
	
	
}

window.smoothScroll = function(target) {
    var scrollContainer = target;
  //  alert(target);
    do { //find scroll container
        scrollContainer = scrollContainer.parentNode;
        if (!scrollContainer) return;
        scrollContainer.scrollTop += 1;
    } while (scrollContainer.scrollTop == 0);
    
    var targetY = 0;
   
    do { //find the top of target relatively to the container
        if (target == scrollContainer) break;
        targetY += target.offsetTop;
    } while (target = target.offsetParent);
    
    scroll = function(c, a, b, i) {
        i++; if (i > 30) return;
        c.scrollTop = a + (b - a) / 30 * i;
        setTimeout(function(){ scroll(c, a, b, i); }, 20);
    }
  
  //  targetY = targetY-50;
    // start scrolling
    scroll(scrollContainer, scrollContainer.scrollTop, targetY, 0);
}
   