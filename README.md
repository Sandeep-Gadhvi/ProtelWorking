Protel Services
Protel Services is a telecom management system designed to manage customer information, subscription plans, and support tickets. This project is built using Java Spring Boot for the backend, MySQL for database management, and HTML, CSS, and JavaScript for the frontend.

The project follows a Standard Spring directory struture:-
src
├── main
│   ├── java
│   │   └── com
│   │       └── protel
│   │           ├── controller
│   │           ├── model
│   │           ├── repository
│   │           ├── service
│   │           └── ProtelcrmApplication.java
│   └── resources
│       └── static
│           ├── css
│           ├── images
│           ├── js
│           ├──cd.html
│           ├── customers.html
│           ├── Subscriptions.html
│           ├── subscriptions-details.html
│           ├── index.html
│           └── plans-details.html
└── test
    └── java
        └── com
            └── protel
                └── ProtelcrmApplicationTests.java****

                
Models
1. Customer
File: Customer.java

Description: Represents a customer in the system.

Attributes:

customer_id: Unique identifier for the customer (Long).
first_name: Customer's first name (String).
last_name: Customer's last name (String).
email: Customer's email address (String).
phone: Customer's phone number (Long).
Constructor:

Default constructor.
Parameterized constructor for setting all attributes.
Getters and Setters:

Methods for accessing and modifying each attribute.
2. CustomerDTO
File: CustomerDTO.java

Description: Data Transfer Object for the Customer entity. Currently, it's an empty placeholder and can be implemented based on specific requirements.

3. Plans
File: Plans.java

Description: Represents a telecom plan in the system.

Attributes:

plan_id: Unique identifier for the plan (Long).
plan_name: Name of the plan (String).
plan_type: Type of the plan (String).
plan_price: Price of the plan (Double).
Constructor:

Default constructor.
Parameterized constructor for setting all attributes.
Getters and Setters:

Methods for accessing and modifying each attribute.
4. Subscription
File: Subscription.java

Description: Represents a subscription linking a customer to a telecom plan.

Attributes:

SubscriptionID: Unique identifier for the subscription (Long).
Customer: The customer associated with this subscription (Customer object).
Plan: The plan associated with this subscription (Plans object).
Constructor:

Default constructor.
Parameterized constructor for setting all attributes.
Getters and Setters:

Methods for accessing and modifying each attribute.
5. SubscriptionDTO
File: SubscriptionDTO.java

Description: Data Transfer Object for the Subscription entity.

Attributes:

customerId: ID of the customer (Long).
planId: ID of the plan (Long).
Getters and Setters:

Methods for accessing and modifying each attribute.
6. Tickets
File: Tickets.java

Description: Represents a support ticket in the system.

Attributes:

ticket_id: Unique identifier for the ticket (Long).
ticket_description: Description of the ticket (String).
ticket_status: Status of the ticket (String).
ticket_date: Date when the ticket was created (Date).
subscription: The subscription associated with the ticket (Subscription object).
Constructor:

Default constructor.
Parameterized constructor for setting all attributes.
Getters and Setters:

Methods for accessing and modifying each attribute.
7. TicketsDTO
File: TicketsDTO.java

Description: Data Transfer Object for the Tickets entity.

Attributes:

ticket_description: Description of the ticket (String).
ticket_status: Status of the ticket (String).
ticket_date: Date when the ticket was created (Date).
subscriptionID: ID of the associated subscription (Long).
Getters and Setters:

Methods for accessing and modifying each attribute.

Controllers
1. CustomerController
File: CustomerController.java

Description: Manages CRUD operations for Customer entities.

Endpoints:

GET /customers: Retrieve all customers.
GET /customers/{id}: Retrieve a specific customer by ID.
POST /customers/customer: Create a new customer.
PUT /customers/{id}: Update an existing customer.
DELETE /customers/{id}: Delete a customer by ID.
Cross-Origin: Configured for http://localhost:63342.

2. PlansController
File: PlansController.java

Description: Manages CRUD operations for Plans entities.

Endpoints:

POST /plans/plan: Create a new plan.
GET /plans/{id}: Retrieve a specific plan by ID.
GET /plans: Retrieve all plans.
DELETE /plans/{id}: Delete a plan by ID.
Cross-Origin: Configured for http://localhost:63342.

3. SubscriptionController
File: SubscriptionController.java

Description: Manages CRUD operations for Subscription entities.

Endpoints:

POST /subscriptions/subscription: Create a new subscription.
GET /subscriptions/{id}: Retrieve a specific subscription by ID.
GET /subscriptions: Retrieve all subscriptions.
DELETE /subscriptions/{id}: Delete a subscription by ID.
Cross-Origin: Configured for http://localhost:63342.

4. TicketsController
File: TicketsController.java

Description: Manages CRUD operations for Tickets entities.

Endpoints:

POST /tickets/ticket: Create a new ticket.
GET /tickets/ticket: Retrieve all tickets.
GET /tickets/ticket/{ticketId}: Retrieve a specific ticket by ID.
PATCH /tickets/ticket/{ticketId}: Update a ticket by ID.
DELETE /tickets/ticket/{ticketId}: Delete a ticket by ID.
Cross-Origin: Configured for http://localhost:63342
Database
The project uses MySQL for database management. Ensure you have MySQL installed and configured, and create the necessary tables as described in the project setup.

Workflow
1. Customer Lifecycle
Add Customer: Create a new customer using the POST /customers/customer endpoint.
Retrieve Customers: Get a list of all customers or a specific customer using GET /customers or GET /customers/{id}.
Update Customer: Modify customer details using PUT /customers/{id}.
Delete Customer: Remove a customer from the system using DELETE /customers/{id}.
2. Plan Lifecycle
Add Plan: Create a new plan using the POST /plans/plan endpoint.
Retrieve Plans: Get a list of all plans or a specific plan using GET /plans or GET /plans/{id}.
Delete Plan: Remove a plan from the system using DELETE /plans/{id}.
3. Subscription Lifecycle
Add Subscription: Create a new subscription linking a customer and a plan using POST /subscriptions/subscription.
Retrieve Subscriptions: Get a list of all subscriptions or a specific subscription using GET /subscriptions or GET /subscriptions/{id}.
Delete Subscription: Remove a subscription from the system using DELETE /subscriptions/{id}.
4. Ticket Lifecycle
Add Ticket: Create a new support ticket associated with a subscription using POST /tickets/ticket.
Retrieve Tickets: Get a list of all tickets or a specific ticket using GET /tickets/ticket or GET /tickets/ticket/{ticketId}.
Update Ticket: Modify ticket details using PATCH /tickets/ticket/{ticketId}.
Delete Ticket: Remove a ticket from the system using DELETE /tickets/ticket/{ticketId}
