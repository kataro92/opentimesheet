package com.kat.opentimesheet.service.interfaces;

import com.kat.opentimesheet.common.dto.LoggedUser;

public interface AuthorityService {
    LoggedUser validateUser(String username, String password);
}
