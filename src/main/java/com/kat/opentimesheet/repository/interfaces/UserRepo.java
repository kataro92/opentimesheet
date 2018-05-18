package com.kat.opentimesheet.repository.interfaces;

import com.kat.opentimesheet.common.model.TsUserEntity;

public interface UserRepo {
    TsUserEntity getUserByUsernameAndPassword(String username, String md5_password);
}
