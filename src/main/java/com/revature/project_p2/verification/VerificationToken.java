package com.revature.project_p2.verification;

import com.revature.project_p2.user.User;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.time.Instant;

public class VerificationToken {
    private Long id;
    private String token;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;
    private Instant expiryDate;
}
