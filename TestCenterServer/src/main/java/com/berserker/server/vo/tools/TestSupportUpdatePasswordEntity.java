package com.berserker.server.vo.tools;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestSupportUpdatePasswordEntity {
    private String mobile;
    private transient String password;
    private int env_code;
}
