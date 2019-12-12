package com.taiji.streamfunction.operator;

import com.taiji.streamfunction.service.IReceive;
import org.springframework.stereotype.Component;

@Component
public class Consume {
    private IReceive receive;

    public void setReceive(IReceive receive) {
        this.receive = receive;
    }

    public boolean receive(String s) {
        boolean receive = this.receive.receive(s);
        return receive;
    }

}
