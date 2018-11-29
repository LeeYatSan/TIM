/**
 *@author
 *LI_Yichen
 *ID: 16130120145
 *e-mail: niuqiao2010@163.com
 */

package com;

import java.util.ArrayList;

public class TicketCollection extends ArrayList{

    TicketCollection()
    {
        TicketInfo test = new TicketInfo();
        add(test);
    }

    public TicketCollection getTicketCollection(){return this;}
}
