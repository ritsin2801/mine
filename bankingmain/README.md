
# Microservices Assignment (Java)

## PORTs

#### Eureka Server: `http://localhost:8761`

#### API Gateway: `http://localhost:8580`

#### Customer Management Service: `http://localhost:8581`

#### Account Management Service: `http://localhost:8582`

#### Config Server: `http://localhost:8583`

(config server gets configuration from `https://github.com/anirudhdabral/microservice-assignment-config`)


## Customer Management Service

#### Add customer:
`http://localhost:8580/customer/addCustomer`

(returns `null` if customer already exists)

#### Get all customers: 
`http://localhost:8580/customer/getCustomers`

(returns `[]` if no customer exists)

#### Get single customer details: 
`http://localhost:8580/customer/getCustomer/{customerId}`

(returns `null` if customer not exists)

#### Update customer details:
`http://localhost:8580/customer/updateCustomer`

(returns `false` if customer not exists, else returns `true`)

#### Delete customer:
`http://localhost:8580/customer/deleteCustomer/{customerId}`

(returns `false` if customer not exists, else returns `true`. Also deletes account from Account Management Service)

## Account Management Service

#### Add money to account:
`http://localhost:8580/account/addMoney`

(returns `false` if account not exists, else returns `true`)

#### Withdraw money from account:
`http://localhost:8580/account/withdrawMoney`

(returns `false` if account not exists or insufficient balance, else returns `true`)

#### Get account details:
`http://localhost:8580/account/getAccount/{accountNumber}`

(returns `null` if customer not exists)

#### Delete account:
`http://localhost:8580/account/deleteAccount/{accountNumber}`

(returns `false` if account not exists, else returns `true`)

## JSON sample formats

### Add/Update customer:
`{
    "customerId": 1,
    "firstName": "Anirudh",
    "lastName": "Dabral",
    "accountNumber": 123,
    "address": "Kanpur",
    "phone": 1234567890,
    "gender": "M"
}`

### Add/Withdraw money:
`{
    "customerId": 1,
    "accountNumber": 123,
    "amount": 345.1
}`