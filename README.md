# camunda8-microservice-instance-creator
A microservice to connect to Camunda 8 BPMN using Zeebe Client

This is a learning tutorial

Path to bpmn src/main/resources/bpmn

There are two bpmn files -
1. insurance_claim (main bpmn)
2. payment-process (Call Activity inside insurance claim)


# insurance_claim.bpmn: 
![insurance_claim](https://github.com/user-attachments/assets/18f689a9-68ce-4222-a888-4cf699b5ebd2)

# payment_process.bpmn
![payment-process](https://github.com/user-attachments/assets/fd4e5d32-37e4-40a2-b5d4-5df6d1481a4d)


It contains a POST API to create a process instance. 
Sample request of POST API: /start-instance

{
    "claimReference": "ABC1233",
    "claimDate":"260a2025",
    "claimAmount":1200.0
}
