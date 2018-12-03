# TIM

Ticket Information Manager

## UML CLASS DIAGRAM
[LINK](https://www.lucidchart.com/invitations/accept/94408bc6-9124-4f77-ad66-c5bef60a92b4)
![image](https://github.com/LeeYatSan/TIM/blob/master/TIM.svg)

[NOTE] The date format is YYYY/MM/DD

### Instruction of some methods

#### Class BackEnd - Back-end class
 
|     Method      |  Function  |
| ----------------------- | ------------- |
| +TicketCollection getTicketCollection(String SCity, TCity, String date)    | Retrun searching results. |
| +int checkPayment(String price, String pay)    | Check whether the inputted payment is enough to pay or not, and return the result (An integer) of price minus pay.  |
| +boolean checkCity(String city) | Check whether the inputted city name exists [TRUE] in the database or not [FALSE]. |
| +boolean checkNum(String ID, String Date) | Check whether there is a remaining ticket of specific date [TRUE] and train ID or not [FALSE]. |
| +void purchase(String ID, String Date， String pay, String change) | The purchase operation, which used by front-end GUI to notice the back-end that a successful purchase is done and it needs to refresh the database.  |


#### Class TicketInfo - Contains ticket information.
 
|     Method         |  Function  |
| ---------------    | ------------- |
| +String getID()    | Return ticket ID |
| +String getSCity() | Return departure city |
| +String getTCity() | Return arrival city |
| +String getDate()  | Return departure date and time |
| +String getNum()   | Return specific remaining tickets number |
| +String getPrice() | Return ticket price |

#### Class DataTransmission - Transfer data between GUI and DB
|     Method         |  Function  |
| ---------------    | ------------- |
| +TicketCollection getTickets(String SCity,String TCity,String date)    | Return search results. |
| +TicketCollection getTicket(String City) | Return search results. |
| +TicketInfo getTCity(String ID,String date) | Return search results. |
| +void updateTicketNum(String ID)  | Ticket number - 1 |
| +void purchaseRecord(String ID,String date,String pay,String change)   | Record the certain purchase. |
| +void close() | Cut out the connection. |

