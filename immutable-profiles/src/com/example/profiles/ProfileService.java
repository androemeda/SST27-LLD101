package com.example.profiles;

/**
 * Assembles immutable profiles using Builder pattern.
 */
public class ProfileService {

    public UserProfile createMinimal(String id, String email) {
        return UserProfile.builder(id, email).build();
    }

    public UserProfile createWithDisplayName(String id, String email, String displayName) {
        return UserProfile.builder(id, email)
            .displayName(displayName)
            .build();
    }
}
