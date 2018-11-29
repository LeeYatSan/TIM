# TIM

Ticket Information Manager

## UML CLASS DIAGRAM
![image](https://github.com/LeeYatSan/TIM/blob/master/TIM.svg)


- LINK https://www.lucidchart.com/invitations/accept/94408bc6-9124-4f77-ad66-c5bef60a92b4

### 部分函数方法解释

#### Class BackEnd 后端类
##### +TicketCollection getTicketCollection(String SCity, TCity, String date)
Retrun search results.
##### +int checkPayment(String price, String pay)
Check whether the inputted payment is enough to pay or not, and return the result (An integer) of price minus pay.
##### +boolean checkCity(String city)
Check whether the inputted city name exists in the database or not.
##### +boolean checkNum(String ID,, String Date)
Check whether their is a remaining ticket of specific date and train ID or not.
##### +void purchace(String ID, String Date)
The purchase operation, which used by front-end GUI to notice the back-end that a successful purchase is done and it needs to refresh the database. 

#### Class TicketInfo 车票信息类
The following methods are all used to return a specific data of a TicketInfo instance.

- +String getID()
- +String getSCity()
- +String getTCity()
- +String  getDate()
- +String getNum()
- +String getPrice()
