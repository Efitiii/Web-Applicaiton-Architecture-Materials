 
//************** ORDER MATTERS **************
// Need to set up functions in the following sequence...
    //Create stomp client over sockJS protocol
   //   /taxi is the stomp-endpoint configured in Spring on the server
   // the connection is made and then a stomp client is created over the socket.
    var socket = new SockJS("/ComproTaxi/taxi");
    var stompClient = Stomp.over(socket);

    var blueCar=null;
    var greenCar=null;
    var redCar = null;
    var orangeCar=null;
    
	// Deal with moving the Cars
    function moveCar(frame) {
   		var message = JSON.parse(frame.body);
   		var latlng = message.latLng
   		switch (message.name) {
   		case "Orange":
   			orangeCar.setPosition(new google.maps.LatLng(latlng.lat,latlng.lng));       		
   			break;
   		case "Red":
   			redCar.setPosition(new google.maps.LatLng(latlng.lat,latlng.lng));
   			break;
   		case "Blue":
   			blueCar.setPosition(new google.maps.LatLng(latlng.lat,latlng.lng));       		
   			break;
   		case "Green":
   			greenCar.setPosition(new google.maps.LatLng(latlng.lat,latlng.lng));       		
   			break;
   		}
     } 
 
    function createRoute(frame) {
   		var message = JSON.parse(frame.body);   		
   		calculateAndDisplayRoute(message);		
    }
    
    // delete route & put car back at the ComPro taxi parking lot
    function removeRoute(frame) {
   		var message = JSON.parse(frame.body);   		
   		deleteRoute(message.name);
   		moveCar(frame);
    }
    
    
    // Callback function to be called when stomp client is connected to server
    var headers = null;
    var connectCallback = function() {
        stompClient.subscribe('/topic/car', moveCar);
        stompClient.subscribe('/topic/removeRoute', removeRoute);
        stompClient.subscribe('/topic/createRoute', createRoute);
      }; 

    // Callback function to be called on error
    var errorCallback = function(error) {
      alert(error.headers.message);
    };

    // Connect to server via websocket
    stompClient.connect("guest", "guest", connectCallback, errorCallback);
    
//************** ORDER MATTERS **************
    
    
    // Send new Route request to server
	function sendNewRouteRequest(routeRequest) {
	    var sendData = JSON.stringify(routeRequest);
	    stompClient.send("/taxiApp/newRouteRequest", {}, sendData);	     
	}
	
    // Send new Route details to server
	function sendRoute(steps) {
	    var sendData = JSON.stringify(steps);
	    stompClient.send("/taxiApp/addNewRouteDetails", {}, sendData);	     
	}
	
	// Initialize the cars
	$(document).ready(function() {
   
	 blueCar = 
    		new google.maps.Marker({
    			position: new google.maps.LatLng(41.022800, -91.966117),
    			icon: 'resources/images/blueCar.png',
    			map: map
    		});

     redCar = 
    		new google.maps.Marker({
		        position: new google.maps.LatLng(41.022800, -91.967117),
		        icon: 'resources/images/redCar.png',
		        map: map
		    });

     greenCar = 
    		new google.maps.Marker({
	        position: new google.maps.LatLng(41.023846, -91.967117),
	        icon: 'resources/images/greenCar.png',
	        map: map
	    });
     orangeCar = 
    		new google.maps.Marker({
		        position: new google.maps.LatLng(41.023846, -91.966100),
		        icon: 'resources/images/orangeCar.png',
		        map: map
		    });

});

 
  
