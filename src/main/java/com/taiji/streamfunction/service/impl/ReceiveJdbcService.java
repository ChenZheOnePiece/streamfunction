package com.taiji.streamfunction.service.impl;

import com.taiji.streamfunction.service.IReceive;

public class ReceiveJdbcService implements IReceive {

    //    @Autowired
//    private JdbcTemplate jdbcTemplate;
    @Override
    public boolean receive(String o) {
        //   jdbcTemplate.update("INSERT INTO test(id, name, tag) VALUES (?,?,?)", foo.id, foo.name, foo.tag);
        return false;
    }
}
