package am.itspace.onlinechesstournamentcommon.service;

import am.itspace.onlinechesstournamentcommon.entity.Admin;

public interface AdminService {

    Admin findByEmail(String email);
}
