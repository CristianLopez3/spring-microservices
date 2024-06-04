package com.finance.mobileappws.shared;


import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class Utils {

    public static String generateUserId() {
        return UUID.randomUUID().toString();
    }

}
