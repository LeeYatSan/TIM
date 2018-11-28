# TIM

Ticket Information Manager

## UML CLASS DIAGRAM
![image](https://github.com/LeeYatSan/TIM/blob/master/TIM.svg)


- LINK https://www.lucidchart.com/invitations/accept/94408bc6-9124-4f77-ad66-c5bef60a92b4

### 部分函数方法解释

#### Class BackEnd 后端类
- +TicketCollection getTicketCollection(String SCity, TCity, String date)//返回搜索结果
- +boolean checkPayment(String price, String pay)//检查输入金额是否符合票价
- +boolean checkCity(String city)//检查在数据库中存有输入城市数据
- +boolean checkNum(String ID,, String Date)//检查指定班次日期是否有余票
- +void purchace(String ID, String Date)//购买操作，用于前端页面通知后端购买行为的发生

#### Class TicketInfo 车票信息类
以下方法均为获取对应数据
- +String getID()
- +String getSCity()
- +String getTCity()
- +String  getDate()
- +String getNum()
- +String getPrice()

