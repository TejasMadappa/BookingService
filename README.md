# BookingService
Service to handle booking rooms for customers

# API link:
http://localhost:8082/api/bookings

### Below is the sample payload to add a new booking.

    {
	    "customerId":"1",
	    "roomId":"1",
	    "rerservationStartDateTime":"2020-06-26T22:08:28.097832",
	    "rerservationEndDateTime":"2020-06-27T22:08:28.097832"
    }
    
Customer id and room id should be already registered before consuming this service. 

### For registering customer
Project link  : https://github.com/TejasMadappa/CustomerManagement

API : http://localhost:8081/api/customers

### For adding a new room
Project link : https://github.com/TejasMadappa/RoomManagement

API : http://localhost:8080/api/rooms
